package com.pizzamadre.api.order.controller

import com.pizzamadre.api.order.service.IOrderService
import com.pizzamadre.api.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(Constants.URL_BASE_ORDER)
class OrderController {

    @Autowired
    val orderService: IOrderService? = null
}