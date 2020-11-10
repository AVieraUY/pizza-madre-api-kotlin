package com.pizzamadre.api.order.dto

import com.pizzamadre.api.lineItem.dto.LineItemDTO

class OrderDTO(val id: Long? = null, val userId: Long, val paymentMethod: PaymentMethodDTO, val items: List<LineItemDTO>?)

enum class PaymentMethodDTO {
    EFECTIVO, POS
}