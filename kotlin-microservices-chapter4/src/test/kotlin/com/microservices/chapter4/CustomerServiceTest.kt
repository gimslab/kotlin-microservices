package com.microservices.chapter4

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CustomerServiceTest {

	@Autowired
	lateinit var customerService: CustomerService

	@Test
	fun `we should get a customer with a valid id`() {
		val customer = customerService.getCustomer(1)
		Assert.assertNotNull(customer)
		Assert.assertEquals(customer.block()!!.name, "Kotlin")
	}

	@Test
	fun `we should get all customers`() {
		val customers = customerService.searchCustomers("")
		Assert.assertEquals(customers.collectList().block()!!.size, 3)
	}
}