package com.pizzamadre.api.product.service

import com.pizzamadre.api.product.domain.Product
import com.pizzamadre.api.product.domain.ProductRepository
import com.pizzamadre.api.product.exception.NotFoundException
import com.pizzamadre.api.product.exception.ProductException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService : IProductService {
    @Autowired
    val productRepository: ProductRepository? = null

    @Throws(ProductException::class, NotFoundException::class)
    override fun get(id: Long): Product {
        val o: Optional<Product>
        try {
            o = productRepository!!.findById(id)
        } catch (e: Exception) {
            throw ProductException(e.message)
        }

        if (!o.isPresent) {
            throw NotFoundException("No se encontró el producto id. $id")
        }

        return o.get()
    }

    @Throws(ProductException::class)
    override fun list(): List<Product> {
        try {
            return productRepository!!.findAll()
        } catch (e: Exception) {
            throw ProductException(e.message)
        }
    }

    @Throws(ProductException::class, NotFoundException::class)
    override fun modify(product: Product): Product {
        try {
            get(product.id)
            return productRepository!!.save(product)
        } catch (e: Exception) {
            when (e) {
                is ProductException, is NotFoundException -> throw e
                else -> throw ProductException(e.message)
            }
        }
    }

    @Throws(ProductException::class)
    override fun save(product: Product): Product {
        try {
            return productRepository!!.save(product)
        } catch (e: Exception) {
            throw ProductException(e.message)
        }
    }

    @Throws(ProductException::class, NotFoundException::class)
    override fun remove(id: Long): Boolean {
        try {
            val p = get(id)
            productRepository!!.delete(p)
        } catch (e: Exception) {
            when (e) {
                is ProductException, is NotFoundException -> throw e
                else -> throw ProductException(e.message)
            }
        }

        return true
    }
}