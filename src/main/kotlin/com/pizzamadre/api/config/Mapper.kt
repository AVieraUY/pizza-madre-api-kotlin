package com.pizzamadre.api.config

import com.pizzamadre.api.lineItem.domain.LineItem
import com.pizzamadre.api.lineItem.dto.LineItemDTO
import com.pizzamadre.api.order.domain.Order
import com.pizzamadre.api.order.dto.OrderDTO
import com.pizzamadre.api.product.domain.Product
import com.pizzamadre.api.product.dto.ProductDTO
import com.pizzamadre.api.user.domain.User
import com.pizzamadre.api.user.dto.UserDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface Mapper {
    fun orderToOrderDto(order: Order): OrderDTO
    fun orderDtoToOrder(orderDTO: OrderDTO): Order
    fun ordersToOrderDtos(orders: List<Order>): List<OrderDTO>
    fun orderDtosToOrders(orderDTOs: List<OrderDTO>): List<Order>


    fun productToProductDto(product: Product): ProductDTO
    fun productDtoToProduct(productDTO: ProductDTO): Product
    fun productsToProductDtos(products: List<Product>): List<ProductDTO>
    fun productDtosToProducts(productDTOs: List<ProductDTO>): List<Product>


    fun userToUserDto(user: User): UserDTO
    fun userDtoToUser(userDTO: UserDTO): User
    fun usersToUserDtos(users: List<User>): List<UserDTO>
    fun userDtosToUsers(userDTOs: List<UserDTO>): List<User>

    fun lineItemToLineItemDto(lineItem: LineItem): LineItemDTO
    fun lineItemDtoToLineItem(lineItemDTO: LineItemDTO): LineItem
    fun lineItemsToLineItemDtos(lineItems: List<LineItem>): List<LineItemDTO>
    fun lineItemDtosToLineItems(lineItemDTOs: List<LineItemDTO>): List<LineItem>
}