package me.kjgleh.springboot.jpa.manyToOne.biDirection.repository

import me.kjgleh.springboot.jpa.manyToOne.biDirection.domain.BiTeam
import org.springframework.data.jpa.repository.JpaRepository

interface BiTeamRepository: JpaRepository<BiTeam, Long>
