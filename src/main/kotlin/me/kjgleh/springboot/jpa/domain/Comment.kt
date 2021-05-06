package me.kjgleh.springboot.jpa.domain

import javax.persistence.*

@Entity
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val content: String
) {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_post_id")
    lateinit var post: Post
}
