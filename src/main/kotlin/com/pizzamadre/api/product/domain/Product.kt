package com.pizzamadre.api.product.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(val name: String, val description: String, val image: String, val category: Category, val price: BigDecimal) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L
}

enum class Category {
    PIZZA, EMPANADA, BURGER, MILANESA, POSTRE
}