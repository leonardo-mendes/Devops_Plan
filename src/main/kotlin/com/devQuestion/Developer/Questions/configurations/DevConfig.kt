package com.devQuestion.Developer.Questions.configurations

import com.devQuestion.Developer.Questions.services.DatabaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import java.text.ParseException

@Configuration
@Profile("dev") // Com essa notação eu falo que todos os bins presentes aqui estão ativos quando no meu application.proprieis estiver com o test active
class DevConfig {

    @Autowired
    private val dbtest: DatabaseService? = null

    @Value("\${spring.jpa.hibernate.ddl-auto}")
    private val strategy: String? = null

    @Bean
    @Throws(ParseException::class)
    fun instantiateDataBase(): Boolean? {

        if (!"create".equals(strategy!!, ignoreCase = true)) {
            return false
        }

        dbtest!!.instantiateTestDataBase()
        return true
    }

}