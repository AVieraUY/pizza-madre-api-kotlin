package com.pizzamadre.api.product.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long?, var name: String?, var description: String?, var image: String?, var category: Category?, var price: BigDecimal?) {
    // Needed by MapStruct
    constructor(): this(null, null, null, null, null, null)
}

enum class Category {
    PIZZA, EMPANADA, BURGER, MILANESA, POSTRE
}