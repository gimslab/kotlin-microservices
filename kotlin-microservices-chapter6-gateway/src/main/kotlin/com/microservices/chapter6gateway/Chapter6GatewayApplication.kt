package com.microservices.chapter6gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableZuulProxy
class Chapter6GatewayApplication

fun main(args: Array<String>) {
	runApplication<Chapter6GatewayApplication>(*args)
}
