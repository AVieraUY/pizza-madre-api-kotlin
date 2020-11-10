package com.pizzamadre.api.product.dto

import java.math.BigDecimal

class ProductDTO(val id: Long? = null, val name: String, val description: String, val image: String, val category: CategoryDTO, val price: BigDecimal)

enum class CategoryDTO {
    PIZZA, EMPANADA, BURGER, MILANESA, POSTRE
}