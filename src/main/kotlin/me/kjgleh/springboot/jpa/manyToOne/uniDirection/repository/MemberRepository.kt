package me.kjgleh.springboot.jpa.manyToOne.uniDirection.repository

import me.kjgleh.springboot.jpa.manyToOne.uniDirection.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long>
