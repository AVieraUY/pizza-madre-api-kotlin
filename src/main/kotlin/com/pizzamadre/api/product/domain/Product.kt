package com.pizzamadre.api.product.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null, val name: String, val description: String, val image: String, val category: Category, val price: BigDecimal) {
}

enum class Category {
    PIZZA, EMPANADA, BURGER, MILANESA, POSTRE
}