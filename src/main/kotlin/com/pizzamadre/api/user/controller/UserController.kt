package com.pizzamadre.api.user.controller

import com.pizzamadre.api.user.domain.User
import com.pizzamadre.api.user.exception.NotFoundException
import com.pizzamadre.api.user.service.IUserService
import com.pizzamadre.api.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_USER)
class UserController : IUserController {
    @Autowired
    val userService: IUserService? = null

    @GetMapping("/{id}")
    @ResponseBody
    override fun getUser(@PathVariable("id") id: Long): ResponseEntity<User> {
        return try {
            ResponseEntity(userService!!.get(id), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping
    override fun getUsers(): ResponseEntity<List<User>> {
        return try {
            ResponseEntity(userService!!.list(), HttpStatus.OK)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    override fun updateUser(@RequestBody(required = true) user: User): ResponseEntity<User> {
        return try {
            ResponseEntity(userService!!.modify(user), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping
    override fun createUser(@RequestBody(required = true) user: User): ResponseEntity<User> {
        return try {
            ResponseEntity(userService!!.save(user), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteUser(@PathVariable("id") id: Long): ResponseEntity<Boolean> {
        return try {
            ResponseEntity(userService!!.remove(id), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}