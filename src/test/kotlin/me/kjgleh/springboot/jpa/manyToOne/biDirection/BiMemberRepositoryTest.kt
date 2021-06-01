package me.kjgleh.springboot.jpa.manyToOne.biDirection

import com.appmattus.kotlinfixture.decorator.optional.AlwaysOptionalStrategy
import com.appmattus.kotlinfixture.decorator.optional.optionalStrategy
import com.appmattus.kotlinfixture.decorator.recursion.NullRecursionStrategy
import com.appmattus.kotlinfixture.decorator.recursion.recursionStrategy
import com.appmattus.kotlinfixture.kotlinFixture
import me.kjgleh.springboot.jpa.manyToOne.biDirection.domain.BiMember
import me.kjgleh.springboot.jpa.manyToOne.biDirection.domain.BiTeam
import me.kjgleh.springboot.jpa.manyToOne.biDirection.repository.BiMemberRepository
import me.kjgleh.springboot.jpa.manyToOne.biDirection.repository.BiTeamRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
internal class BiMemberRepositoryTest constructor(
    @Autowired
    private val biTeamRepository: BiTeamRepository,
    @Autowired
    private val biMemberRepository: BiMemberRepository
) {

    private val fixture = kotlinFixture {
        recursionStrategy(NullRecursionStrategy)
        optionalStrategy(AlwaysOptionalStrategy)
    }

    @Test
    fun `save correctly`() {
        // Arrange
        val team = fixture<BiTeam> {
            property(BiTeam::members) {
                mutableListOf()
            }
        }
        biTeamRepository.save(team)

        val member = BiMember(
            username = fixture(),
            team = team
        ).apply {
            this.team.members.add(this)
        }

        // Act
        val sut = biMemberRepository
        sut.save(member)

        // Assert
        val actual = sut.findAll()
        assertThat(actual.size).isEqualTo(1)
        assertThat(team.members.size).isEqualTo(1)
    }
}
