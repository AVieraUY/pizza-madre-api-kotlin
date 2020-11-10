package com.pizzamadre.api.user.domain

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long?, var ci: String?, var nombre: String?, var direccion: String?) {
    // Needed by MapStruct
    constructor(): this(null, null, null, null)
}