package com.pizzamadre.api.user.service

import com.pizzamadre.api.user.domain.User
import com.pizzamadre.api.user.exception.NotFoundException
import com.pizzamadre.api.user.exception.UserException
import com.pizzamadre.api.user.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class UserService : IUserService {
    @Autowired
    val userRepository: UserRepository? = null

    @Throws(UserException::class, NotFoundException::class)
    override fun get(id: Long): User {
        val op: Optional<User>
        try {
            op = userRepository!!.findById(id)
        } catch (e: Exception) {
            throw UserException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontró el usuario id. $id.")
        }

        return op.get()
    }

    @Throws(UserException::class)
    override fun list(): List<User> {
        try {
            return userRepository!!.findAll()
        } catch (e: Exception) {
            throw UserException(e.message)
        }
    }

    @Throws(UserException::class, NotFoundException::class)
    override fun modify(user: User): User {
        try {
            get(user.id!!)
            return userRepository!!.save(user)
        } catch (e: Exception) {
            when (e) {
                is UserException, is NotFoundException -> throw e
                else -> throw UserException(e.message)
            }
        }
    }

    @Throws(UserException::class)
    override fun save(user: User): User {
        try {
            return userRepository!!.save(user)
        } catch (e: Exception) {
            throw UserException(e.message)
        }
    }

    @Throws(UserException::class, NotFoundException::class)
    override fun remove(id: Long): Boolean {
        try {
            val u = get(id)
            userRepository!!.delete(u)
        } catch (e: Exception) {
            when(e) {
                is UserException, is NotFoundException -> throw e
                else -> throw UserException(e.message)
            }
        }
        return true
    }

}