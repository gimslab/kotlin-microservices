package com.microservices.chapter2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class Chapter2Application {

	@Bean
	@ConditionalOnExpression("#{'\${service.message.type}'=='simple'}")
	fun exampleService(): ServiceInterface = ExampleService()

	@Bean
	@ConditionalOnExpression("#{'\${service.message.type}'=='advance'}")
	fun advanceService(): ServiceInterface = AdvanceService()
}

fun main(args: Array<String>) {
	runApplication<Chapter2Application>(*args)
}

@Controller
class FirstController(val service: ServiceInterface) {

	@RequestMapping(value = ["/user/{name}"], method = [GET])
	@ResponseBody
	fun hello(@PathVariable name: String) = service.getHello(name)
}
