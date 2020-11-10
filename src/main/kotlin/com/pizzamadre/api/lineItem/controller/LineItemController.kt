package com.pizzamadre.api.lineItem.controller

import com.pizzamadre.api.lineItem.dto.LineItemDTO
import com.pizzamadre.api.lineItem.exception.NotFoundException
import com.pizzamadre.api.lineItem.service.ILineItemService
import com.pizzamadre.api.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_LINE_ITEM)
class LineItemController : ILineItemController {
    @Autowired
    val lineItemService: ILineItemService? = null

    @GetMapping("/{id}")
    override fun getLineItem(@PathVariable("id") id: Long): ResponseEntity<LineItemDTO> {
        return try {
            ResponseEntity(lineItemService!!.get(id), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> ResponseEntity(HttpStatus.NOT_FOUND)
                else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }

    @GetMapping
    override fun getLineItems(): ResponseEntity<List<LineItemDTO>> {
        return try {
            ResponseEntity(lineItemService!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping
    override fun updateLineItem(@RequestBody(required = true) lineItemDTO: LineItemDTO): ResponseEntity<LineItemDTO> {
        return try {
            ResponseEntity(lineItemService!!.modify(lineItemDTO), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> ResponseEntity(HttpStatus.NOT_FOUND)
                else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }

    @PostMapping
    override fun saveLineItem(@RequestBody(required = true) lineItemDTO: LineItemDTO): ResponseEntity<LineItemDTO> {
        return try {
            ResponseEntity(lineItemService!!.save(lineItemDTO), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteLineItem(@PathVariable("id") id: Long): ResponseEntity<Boolean> {
        return try {
            ResponseEntity(lineItemService!!.remove(id), HttpStatus.OK)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> ResponseEntity(HttpStatus.NOT_FOUND)
                else -> ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }
}