package me.kjgleh.springboot.jpa.manyToOne.uniDirection

import com.appmattus.kotlinfixture.decorator.optional.AlwaysOptionalStrategy
import com.appmattus.kotlinfixture.decorator.optional.optionalStrategy
import com.appmattus.kotlinfixture.decorator.recursion.NullRecursionStrategy
import com.appmattus.kotlinfixture.decorator.recursion.recursionStrategy
import com.appmattus.kotlinfixture.kotlinFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
internal class MemberRepositoryTest constructor(
    @Autowired
    private val teamRepository: TeamRepository,
    @Autowired
    private val memberRepository: MemberRepository
) {

    private val fixture = kotlinFixture {
        recursionStrategy(NullRecursionStrategy)
        optionalStrategy(AlwaysOptionalStrategy)
    }

    @Test
    fun `save correctly`() {
        // Arrange
        val team = fixture<Team>()
        teamRepository.save(team)

        val member = fixture<Member> {
            property(Member::team) {
                team
            }
        }

        // Act
        val sut = memberRepository
        sut.save(member)

        // Assert
        val actual = sut.findAll()
        assertThat(actual.size).isEqualTo(1)
    }
}
