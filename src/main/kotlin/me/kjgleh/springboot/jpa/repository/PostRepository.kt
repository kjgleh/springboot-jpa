package me.kjgleh.springboot.jpa.repository

import me.kjgleh.springboot.jpa.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Long>
