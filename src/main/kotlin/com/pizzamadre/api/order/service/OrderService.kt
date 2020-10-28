package com.pizzamadre.api.order.service

import com.pizzamadre.api.order.domain.Order
import com.pizzamadre.api.order.domain.OrderRepository
import com.pizzamadre.api.order.exception.NotFoundException
import com.pizzamadre.api.order.exception.OrderException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderService : IOrderService {
    @Autowired
    val orderRepository: OrderRepository? = null

    @Throws(OrderException::class, NotFoundException::class)
    override fun get(id: Long): Order {
        val o: Optional<Order>
        try {
            o = orderRepository!!.findById(id)
        } catch (e: Exception) {
            throw OrderException(e.message)
        }

        if (!o.isPresent) {
            throw NotFoundException("No se encontró la órden id. $id")
        }

        return o.get()
    }

    @Throws(OrderException::class)
    override fun list(): List<Order> {
        try {
            return orderRepository!!.findAll()
        } catch (e: Exception) {
            throw OrderException(e.message)
        }
    }

    @Throws(OrderException::class, NotFoundException::class)
    override fun modify(order: Order): Order {
        try {
            get(order.id)
            return orderRepository!!.save(order)
        } catch (e: Exception) {
            when (e) {
                is OrderException, is NotFoundException -> throw e
                else -> throw OrderException(e.message)
            }
        }
    }

    @Throws(OrderException::class)
    override fun save(order: Order): Order {
        try {
            return orderRepository!!.save(order)
        } catch (e: Exception) {
            throw OrderException(e.message)
        }
    }

    @Throws(OrderException::class, NotFoundException::class)
    override fun remove(id: Long): Boolean {
        try {
            val o = get(id)
            orderRepository!!.delete(o)
        } catch (e: Exception) {
            throw OrderException(e.message)
        }
        return true
    }
}