package com.pizzamadre.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class PizzamadreApiApplication

fun main(args: Array<String>) {
    runApplication<PizzamadreApiApplication>(*args)
}
