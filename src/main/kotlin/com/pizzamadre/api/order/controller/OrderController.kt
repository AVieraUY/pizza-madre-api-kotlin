package com.pizzamadre.api.order.controller

import com.pizzamadre.api.order.domain.Order
import com.pizzamadre.api.order.exception.NotFoundException
import com.pizzamadre.api.order.service.IOrderService
import com.pizzamadre.api.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_ORDER)
class OrderController : IOrderController {

    @Autowired
    val orderService: IOrderService? = null

    @GetMapping("/{id}")
    override fun getOrder(@PathVariable("id") id: Long): ResponseEntity<Order> {
        return try {
            ResponseEntity(orderService!!.get(id), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> ResponseEntity(HttpStatus.NOT_FOUND)
                else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }

    @GetMapping
    override fun getOrders(): ResponseEntity<List<Order>> {
        return try {
            ResponseEntity(orderService!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    override fun updateOrder(@RequestBody(required = true) order: Order): ResponseEntity<Order> {
        return try {
            ResponseEntity(orderService!!.modify(order), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> ResponseEntity(HttpStatus.NOT_FOUND)
                else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }

    @PostMapping
    override fun createOrder(@RequestBody(required = true) order: Order): ResponseEntity<Order> {
        return try {
            ResponseEntity(orderService!!.save(order), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteOrder(@PathVariable("id") id: Long): ResponseEntity<Boolean> {
        return try {
            ResponseEntity(orderService!!.remove(id), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> ResponseEntity(HttpStatus.NOT_FOUND)
                else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }
}