package com.tomjung.customer.management

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class CustomerRouter(private val customerHandler: CustomerHandler) {
    @Bean
    fun customerRoutes() = router {
        "/customer".nest {
            GET("/{id}", customerHandler::get)
        }
        "/customers".nest {
            GET("", customerHandler::search)
        }
    }
}