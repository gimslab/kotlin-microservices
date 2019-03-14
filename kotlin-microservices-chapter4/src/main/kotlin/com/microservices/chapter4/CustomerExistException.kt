package com.microservices.chapter4

import java.lang.Exception

class CustomerExistException(override val message: String) : Exception(message)

