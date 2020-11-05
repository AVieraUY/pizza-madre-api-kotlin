package com.pizzamadre.api.order.domain

import com.pizzamadre.api.lineItem.domain.LineItem
import javax.persistence.*

@Entity
@Table(name = "order")
data class Order(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null, val userId: Long, val paymentMethod: PaymentMethod, @OneToMany val items: List<LineItem>) {
}

enum class PaymentMethod {
    EFECTIVO, POS
}