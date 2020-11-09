package com.pizzamadre.api.utils

class Constants {
    companion object {
        private const val URL_API_BASE = "/pizza-madre-api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION

        const val URL_BASE_USER = "$URL_BASE/users"
        const val URL_BASE_PRODUCT = "$URL_BASE/products"
        const val URL_BASE_ORDER = "$URL_BASE/orders"
        const val URL_BASE_LINE_ITEM = "$URL_BASE/line-items"
    }
}