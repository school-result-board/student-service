package com.hoona.zaid.student

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudentApplication

fun main(args: Array<String>) {
    runApplication<StudentApplication>(*args)
}
