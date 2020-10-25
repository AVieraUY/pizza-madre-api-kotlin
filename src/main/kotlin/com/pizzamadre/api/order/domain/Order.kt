package com.pizzamadre.api.order.domain

import com.pizzamadre.api.product.domain.Product
import org.hibernate.annotations.CascadeType
import javax.persistence.*

@Entity
@Table(name = "order")
data class Order(val userId: Long, val paymentMethod: PaymentMethod) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L

    @OneToMany(fetch = FetchType.LAZY)
    val products: List<Product> = listOf()
}

enum class PaymentMethod {
    EFECTIVO, POS
}