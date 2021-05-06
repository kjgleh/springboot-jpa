package me.kjgleh.springboot.jpa.domain

import javax.persistence.*

@Entity
class Post(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val content: String,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "post")
    val comments: List<Comment>
)
