package me.kjgleh.springboot.jpa.repository

import com.appmattus.kotlinfixture.decorator.optional.AlwaysOptionalStrategy
import com.appmattus.kotlinfixture.decorator.optional.optionalStrategy
import com.appmattus.kotlinfixture.decorator.recursion.NullRecursionStrategy
import com.appmattus.kotlinfixture.decorator.recursion.recursionStrategy
import com.appmattus.kotlinfixture.kotlinFixture
import me.kjgleh.springboot.jpa.domain.Comment
import me.kjgleh.springboot.jpa.domain.Post
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class PostRepositoryTest @Autowired constructor(
    private val postRepository: PostRepository
) {

    private val fixture = kotlinFixture {
        recursionStrategy(NullRecursionStrategy)
        optionalStrategy(AlwaysOptionalStrategy)
    }

    @Test
    fun `save correctly`() {
        // Arrange
        val comment = fixture<Comment>()
        val post = fixture<Post> {
            property(Post::comments) {
                listOf(comment)
            }
        }
        comment.apply { this.post = post }

        // Act
        val sut = postRepository
        val actual = sut.save(post)

        // Assert
        assertThat(post.id).isNotNull
        actual.comments.forEach {
            assertThat(it.post.id).isEqualTo(post.id)
        }
    }
}
