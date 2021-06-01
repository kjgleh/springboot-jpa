package me.kjgleh.springboot.jpa.manyToOne.uniDirection.repository

import me.kjgleh.springboot.jpa.manyToOne.uniDirection.domain.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository: JpaRepository<Team, Long>
