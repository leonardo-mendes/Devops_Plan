package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AnswerService{

    @Autowired
    lateinit var answerRepository: AnswerRepository

    fun findAll(): List<Answer> = answerRepository.findAll().toList()

    fun insert(answer: Answer) = answerRepository.save(answer)

}