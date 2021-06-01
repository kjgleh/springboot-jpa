package me.kjgleh.springboot.jpa.manyToOne.uniDirection.domain

import javax.persistence.*

@Entity
class Team(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    val id: Long = 0L,

    val name: String
)
