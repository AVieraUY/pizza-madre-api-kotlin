package com.pizzamadre.api.order.domain

import com.pizzamadre.api.lineItem.domain.LineItem
import javax.persistence.*

@Entity
@Table(name = "order")
data class Order(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long?, var userId: Long?, var paymentMethod: PaymentMethod?, @OneToMany(mappedBy = "order") var items: List<LineItem>?) {
    // Needed by MapStruct
    constructor(): this(null, null, null, null)
}

enum class PaymentMethod {
    EFECTIVO, POS
}