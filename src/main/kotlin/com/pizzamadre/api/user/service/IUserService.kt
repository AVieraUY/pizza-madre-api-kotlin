package com.pizzamadre.api.user.service

import com.pizzamadre.api.user.domain.User
import org.springframework.stereotype.Service

@Service
interface IUserService {
    fun get(id: Long): User
    fun list(): List<User>
    fun modify(user: User): User
    fun save(user: User): User
    fun remove(id: Long): Boolean
}