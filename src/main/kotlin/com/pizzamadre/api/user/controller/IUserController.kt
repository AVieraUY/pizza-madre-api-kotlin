package com.pizzamadre.api.user.controller

import com.pizzamadre.api.user.domain.User
import org.springframework.http.ResponseEntity

interface IUserController {
    fun getUser(id: Long): ResponseEntity<User>
    fun getUsers(): ResponseEntity<List<User>>
    fun updateUser(user: User): ResponseEntity<User>
    fun createUser(user: User): ResponseEntity<User>
    fun deleteUser(id: Long): ResponseEntity<Boolean>
}