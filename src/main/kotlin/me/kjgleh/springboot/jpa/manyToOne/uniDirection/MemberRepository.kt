package me.kjgleh.springboot.jpa.manyToOne.uniDirection

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long>
