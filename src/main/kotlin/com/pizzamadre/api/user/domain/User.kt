package com.pizzamadre.api.user.domain

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(val ci:String, val nombre:String, val direccion:String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = 0L
}