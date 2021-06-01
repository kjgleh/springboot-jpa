package me.kjgleh.springboot.jpa.manyToOne.biDirection.repository

import me.kjgleh.springboot.jpa.manyToOne.biDirection.domain.BiMember
import org.springframework.data.jpa.repository.JpaRepository

interface BiMemberRepository : JpaRepository<BiMember, Long>
