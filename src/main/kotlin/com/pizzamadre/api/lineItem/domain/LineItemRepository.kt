package com.pizzamadre.api.lineItem.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LineItemRepository : JpaRepository<LineItem, Long> {
}