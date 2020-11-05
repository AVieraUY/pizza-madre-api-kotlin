package com.pizzamadre.api.lineItem.service

import com.pizzamadre.api.lineItem.domain.LineItem
import com.pizzamadre.api.lineItem.domain.LineItemRepository
import com.pizzamadre.api.lineItem.exception.LineItemException
import com.pizzamadre.api.lineItem.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class LineItemService : ILineItemService {
    @Autowired
    val lineItemRepository: LineItemRepository? = null

    @Throws(LineItemException::class, NotFoundException::class)
    override fun get(id: Long): LineItem {
        val op: Optional<LineItem>
        try {
            op = lineItemRepository!!.findById(id)
        } catch (e: Exception) {
            throw LineItemException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontró el line item id. $id")
        }

        return op.get()
    }

    @Throws(LineItemException::class)
    override fun list(): List<LineItem> {
        try {
            return lineItemRepository!!.findAll()
        } catch (e: Exception) {
            throw LineItemException(e.message)
        }
    }

    @Throws(LineItemException::class, NotFoundException::class)
    override fun modify(lineItem: LineItem): LineItem {
        try {
            get(lineItem.id!!)
            return lineItemRepository!!.save(lineItem)
        } catch (e: Exception) {
            when (e) {
                is LineItemException, is NotFoundException -> throw e
                else -> throw LineItemException(e.message)
            }
        }
    }

    @Throws(LineItemException::class)
    override fun save(lineItem: LineItem): LineItem {
        try {
            return lineItemRepository!!.save(lineItem)
        } catch (e: Exception) {
            throw LineItemException(e.message)
        }
    }

    @Throws(LineItemException::class, NotFoundException::class)
    override fun remove(id: Long): Boolean {
        try {
            val li = get(id)
            lineItemRepository!!.delete(li)
        } catch (e: Exception) {
            when (e) {
                is LineItemException, is NotFoundException -> throw e
                else -> throw LineItemException(e.message)
            }
        }
        return true
    }

}