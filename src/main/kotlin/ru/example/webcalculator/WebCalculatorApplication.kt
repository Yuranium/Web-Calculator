package ru.example.webcalculator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebCalculatorApplication

fun main(args: Array<String>) {
    runApplication<WebCalculatorApplication>(*args)
}
