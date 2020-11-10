package com.pizzamadre.api.lineItem.controller

import com.pizzamadre.api.lineItem.dto.LineItemDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller

@Controller
interface ILineItemController {
    fun getLineItem(id: Long): ResponseEntity<LineItemDTO>
    fun getLineItems(): ResponseEntity<List<LineItemDTO>>
    fun updateLineItem(lineItemDTO: LineItemDTO): ResponseEntity<LineItemDTO>
    fun saveLineItem(lineItemDTO: LineItemDTO): ResponseEntity<LineItemDTO>
    fun deleteLineItem(id: Long): ResponseEntity<Boolean>
}