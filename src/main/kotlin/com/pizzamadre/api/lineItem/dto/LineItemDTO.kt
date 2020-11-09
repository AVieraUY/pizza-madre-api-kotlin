package com.pizzamadre.api.lineItem.dto

import com.pizzamadre.api.order.dto.OrderDTO
import com.pizzamadre.api.product.dto.ProductDTO
import java.math.BigDecimal

class LineItemDTO(val id: Long? = null, val quantity: Long, val price: BigDecimal, val order: OrderDTO, val product: ProductDTO) {
}