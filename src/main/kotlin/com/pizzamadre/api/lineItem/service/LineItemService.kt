package com.pizzamadre.api.lineItem.service

import com.pizzamadre.api.config.Mapper
import com.pizzamadre.api.lineItem.domain.LineItem
import com.pizzamadre.api.lineItem.domain.LineItemRepository
import com.pizzamadre.api.lineItem.dto.LineItemDTO
import com.pizzamadre.api.lineItem.exception.LineItemException
import com.pizzamadre.api.lineItem.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class LineItemService : ILineItemService {
    @Autowired
    val lineItemRepository: LineItemRepository? = null
    @Autowired
    lateinit var mapper: Mapper

    @Throws(LineItemException::class, NotFoundException::class)
    override fun get(id: Long): LineItemDTO {
        val op: Optional<LineItem>
        try {
            op = lineItemRepository!!.findById(id)
        } catch (e: Exception) {
            throw LineItemException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontró el line item id. $id")
        }

        return mapper.lineItemToLineItemDto(op.get())
    }

    @Throws(LineItemException::class)
    override fun list(): List<LineItemDTO> {
        try {
            return mapper.lineItemsToLineItemDtos(lineItemRepository!!.findAll())
        } catch (e: Exception) {
            throw LineItemException(e.message)
        }
    }

    @Throws(LineItemException::class, NotFoundException::class)
    override fun modify(lineItemDTO: LineItemDTO): LineItemDTO {
        try {
            get(lineItemDTO.id!!)
            return mapper.lineItemToLineItemDto(lineItemRepository!!.save(mapper.lineItemDtoToLineItem(lineItemDTO)))
        } catch (e: Exception) {
            when (e) {
                is LineItemException, is NotFoundException -> throw e
                else -> throw LineItemException(e.message)
            }
        }
    }

    @Throws(LineItemException::class)
    override fun save(lineItemDTO: LineItemDTO): LineItemDTO {
        try {
            return mapper.lineItemToLineItemDto(lineItemRepository!!.save(mapper.lineItemDtoToLineItem(lineItemDTO)))
        } catch (e: Exception) {
            throw LineItemException(e.message)
        }
    }

    @Throws(LineItemException::class, NotFoundException::class)
    override fun remove(id: Long): Boolean {
        try {
            val li = get(id)
            lineItemRepository!!.delete(mapper.lineItemDtoToLineItem(li))
        } catch (e: Exception) {
            when (e) {
                is LineItemException, is NotFoundException -> throw e
                else -> throw LineItemException(e.message)
            }
        }
        return true
    }

}