package me.kjgleh.springboot.jpa.manyToOne.uniDirection

import javax.persistence.*

@Entity
class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    val id: Long = 0L,

    val username: String,

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    val team: Team
)
