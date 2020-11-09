package com.pizzamadre.api.lineItem.service

import com.pizzamadre.api.lineItem.dto.LineItemDTO
import org.springframework.stereotype.Service

@Service
interface ILineItemService {
    fun get(id: Long): LineItemDTO
    fun list(): List<LineItemDTO>
    fun modify(lineItemDTO: LineItemDTO): LineItemDTO
    fun save(lineItemDTO: LineItemDTO): LineItemDTO
    fun remove(id: Long): Boolean
}