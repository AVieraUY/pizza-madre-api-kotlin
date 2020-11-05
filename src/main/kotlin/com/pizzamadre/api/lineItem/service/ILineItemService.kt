package com.pizzamadre.api.lineItem.service

import com.pizzamadre.api.lineItem.domain.LineItem
import org.springframework.stereotype.Service

@Service
interface ILineItemService {
    fun get(id: Long): LineItem
    fun list(): List<LineItem>
    fun modify(lineItem: LineItem): LineItem
    fun save(lineItem: LineItem): LineItem
    fun remove(id: Long): Boolean
}