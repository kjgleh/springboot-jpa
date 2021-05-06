package me.kjgleh.springboot.jpa

import me.kjgleh.springboot.jpa.domain.Comment
import me.kjgleh.springboot.jpa.domain.Post
import me.kjgleh.springboot.jpa.repository.PostRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class PostController(
    private val postRepository: PostRepository
) {

    @GetMapping("/save")
    fun save() {
        val comment = Comment(
            content = UUID.randomUUID().toString()
        )
        val post = Post(
            content = UUID.randomUUID().toString(),
            comments = listOf(
                comment
            )
        )

        comment.apply {
            this.post = post
        }

        postRepository.save(post)
    }
}
