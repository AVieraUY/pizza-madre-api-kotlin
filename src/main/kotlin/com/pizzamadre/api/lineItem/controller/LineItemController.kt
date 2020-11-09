package com.pizzamadre.api.lineItem.controller

import com.pizzamadre.api.utils.Constants
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(Constants.URL_BASE_LINE_ITEM)
class LineItemController: ILineItemController {
}