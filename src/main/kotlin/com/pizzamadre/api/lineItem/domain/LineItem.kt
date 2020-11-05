package com.pizzamadre.api.lineItem.domain

import com.pizzamadre.api.order.domain.Order
import com.pizzamadre.api.product.domain.Product
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "line_item")
data class LineItem(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null, val quantity: Long, val price: BigDecimal, @ManyToOne val order: Order, @ManyToOne val product: Product)