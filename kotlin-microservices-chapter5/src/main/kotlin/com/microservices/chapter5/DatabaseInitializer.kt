package com.microservices.chapter5

import com.microservices.chapter5.Customer.Telephone
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

//@Component // moved to CustomerRepository
class DatabaseInitializer {

	@Autowired
	lateinit var customerRepository: CustomerRepository

//	@Autowired
//	lateinit var mongoOperation: ReactiveMongoOperations

	companion object {
		val initialCustomers = listOf(
				Customer(1, "Kotlin"),
				Customer(2, "Spring"),
				Customer(3, "Microservice", Telephone("+44", "123123")))
	}

//	@PostConstruct
	fun initData() {
//		mongoOperation.collectionExists("Customers").subscribe {
//			if (it != true)
//				mongoOperation.createCollection("Customers").subscribe {
//					println("Customers collections created")
//				}
//			else
//				println("Customers collections already exists")
//		}

//		customerRepository.saveAll(initialCustomers).subscribe {
//			println("Default customers created")
//		}
	}
}
