package me.kjgleh.springboot.jpa.manyToOne.biDirection.domain

import javax.persistence.*

@Entity(name = "bi_member")
class BiMember(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    val id: Long = 0L,

    val username: String,

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    val team: BiTeam
)
