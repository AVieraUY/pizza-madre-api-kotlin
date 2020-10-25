package com.pizzamadre.api.product.controller

import com.pizzamadre.api.product.domain.Product
import org.springframework.http.ResponseEntity

interface IProductController {
    fun getProduct(id:Long) : ResponseEntity<Product>
    fun getProducts() : ResponseEntity<List<Product>>
    fun updateProduct(product:Product) : ResponseEntity<Product>
    fun createProduct(product:Product) : ResponseEntity<Product>
    fun deleteProduct(id: Long): ResponseEntity<Boolean>
}