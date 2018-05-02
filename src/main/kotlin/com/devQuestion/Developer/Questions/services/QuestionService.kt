package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Question
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuestionService{

    @Autowired
    lateinit var questionRepository: QuestionRepository

    fun findAll(): List<Question> = questionRepository.findAll().toList()

    fun insert(question: Question) = questionRepository.save(question)

}