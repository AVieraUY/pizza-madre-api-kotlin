package com.pizzamadre.api.product.controller

import com.pizzamadre.api.product.domain.Product
import com.pizzamadre.api.product.exception.NotFoundException
import com.pizzamadre.api.product.service.IProductService
import com.pizzamadre.api.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_PRODUCT)
class ProductController : IProductController {

    @Autowired
    val productService: IProductService? = null

    @GetMapping("/{id}")
    override fun getProduct(@PathVariable("id") id: Long): ResponseEntity<Product> {
        return try {
            ResponseEntity(productService!!.get(id), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> ResponseEntity(HttpStatus.NOT_FOUND)
                else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }

    @GetMapping
    override fun getProducts(): ResponseEntity<List<Product>> {
        return try {
            ResponseEntity(productService!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    override fun updateProduct(@RequestBody(required = true) product: Product): ResponseEntity<Product> {
        return try {
            ResponseEntity(productService!!.modify(product), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> ResponseEntity(HttpStatus.NOT_FOUND)
                else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }

    @PostMapping
    override fun createProduct(@RequestBody(required = true) product: Product): ResponseEntity<Product> {
        return try {
            ResponseEntity(productService!!.save(product), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteProduct(@PathVariable("id") id: Long): ResponseEntity<Boolean> {
        return try {
            ResponseEntity(productService!!.remove(id), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> ResponseEntity(HttpStatus.NOT_FOUND)
                else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }
}