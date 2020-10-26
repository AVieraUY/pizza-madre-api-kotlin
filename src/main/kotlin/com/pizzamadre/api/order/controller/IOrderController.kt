package com.pizzamadre.api.order.controller

import com.pizzamadre.api.order.domain.Order
import org.springframework.http.ResponseEntity

interface IOrderController {
    fun getOrder(id:Long) : ResponseEntity<Order>
    fun getOrders() : ResponseEntity<List<Order>>
    fun updateOrder(order:Order) : ResponseEntity<Order>
    fun createOrder(order:Order) : ResponseEntity<Order>
    fun deleteOrder(id:Long) : ResponseEntity<Boolean>
}