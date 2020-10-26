package com.pizzamadre.api.order.service

import com.pizzamadre.api.order.domain.Order
import com.pizzamadre.api.order.domain.OrderRepository
import com.pizzamadre.api.order.exceptions.NotFoundException
import com.pizzamadre.api.order.exceptions.OrderException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService : IOrderService {
    @Autowired
    val orderRepository:OrderRepository? = null

    @Throws(OrderException::class, NotFoundException::class)
    override fun get(id: Long): Order {
        TODO("Not yet implemented")
    }

    @Throws(OrderException::class)
    override fun list(): List<Order> {
        TODO("Not yet implemented")
    }

    @Throws(OrderException::class, NotFoundException::class)
    override fun modify(order: Order): Order {
        TODO("Not yet implemented")
    }

    @Throws(OrderException::class)
    override fun save(order: Order): Order {
        TODO("Not yet implemented")
    }

    @Throws(OrderException::class, NotFoundException::class)
    override fun remove(id: Long): Boolean {
        TODO("Not yet implemented")
    }
}