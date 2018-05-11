package com.devQuestion.Developer.Questions

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DeveloperQuestionsApplication : CommandLineRunner {

    override fun run(vararg args: String?) {
    }
}

fun main(args: Array<String>) {
    runApplication<DeveloperQuestionsApplication>(*args)
}