package com.isladellago.securitymngr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecuritymngrApplication {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<SecuritymngrApplication>(*args)
		}
	}
}
