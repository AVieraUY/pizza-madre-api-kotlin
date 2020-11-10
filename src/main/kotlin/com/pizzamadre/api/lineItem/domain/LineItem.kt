package com.pizzamadre.api.lineItem.domain

import com.pizzamadre.api.order.domain.Order
import com.pizzamadre.api.product.domain.Product
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "line_item")
data class LineItem(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long?, var quantity: Long?, var price: BigDecimal?, @ManyToOne @JoinColumn(name = "order_id", referencedColumnName = "id") var order: Order?, @ManyToOne var product: Product?) {
    // Needed by MapStruct
    constructor(): this(null, null, null, null, null)
}