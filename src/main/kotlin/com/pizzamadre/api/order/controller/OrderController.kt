package com.pizzamadre.api.order.controller

import com.pizzamadre.api.order.domain.Order
import com.pizzamadre.api.order.service.IOrderService
import com.pizzamadre.api.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_ORDER)
class OrderController : IOrderController {

    @Autowired
    val orderService: IOrderService? = null

    @GetMapping("/{id}")
    override fun getOrder(@PathVariable("id") id: Long): ResponseEntity<Order> {
        TODO("Not yet implemented")
    }

    @GetMapping
    override fun getOrders(): ResponseEntity<List<Order>> {
        TODO("Not yet implemented")
    }

    @PutMapping
    override fun updateOrder(@RequestBody(required = true) order: Order): ResponseEntity<Order> {
        TODO("Not yet implemented")
    }

    @PostMapping
    override fun createOrder(@RequestBody(required = true) order: Order): ResponseEntity<Order> {
        TODO("Not yet implemented")
    }

    @DeleteMapping("/{id}")
    override fun deleteOrder(@PathVariable("id") id: Long): ResponseEntity<Boolean> {
        TODO("Not yet implemented")
    }
}