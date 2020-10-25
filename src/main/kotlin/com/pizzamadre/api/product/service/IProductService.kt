package com.pizzamadre.api.product.service

import com.pizzamadre.api.product.domain.Product
import org.springframework.stereotype.Service

@Service
interface IProductService {
    fun get(id:Long) : Product
    fun list() : List<Product>
    fun modify(product: Product) : Product
    fun save(product: Product) : Product
    fun remove(id: Long): Boolean
}