package com.pizzamadre.api.order.service

import com.pizzamadre.api.order.domain.Order
import org.springframework.stereotype.Service

@Service
interface IOrderService {
    fun get(id:Long) : Order
    fun list() : List<Order>
    fun modify(order:Order) : Order
    fun save(order:Order) : Order
    fun remove(id:Long) : Boolean
}