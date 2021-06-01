package me.kjgleh.springboot.jpa.manyToOne.biDirection.domain

import javax.persistence.*

@Entity(name = "bi_team")
class BiTeam(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    val id: Long = 0L,

    val name: String,

    @OneToMany(mappedBy = "team")
    val members: MutableList<BiMember>
)
