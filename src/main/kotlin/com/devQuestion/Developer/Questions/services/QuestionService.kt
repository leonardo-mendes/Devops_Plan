package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Question
import com.devQuestion.Developer.Questions.domains.reponse.QuestionResponse
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
import com.devQuestion.Developer.Questions.services.converter.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class QuestionService{

    @Autowired
    lateinit var questionRepository: QuestionRepository

    fun findAll(): List<QuestionResponse> {
        val list = questionRepository.findAll().toList()
        return list.stream().map{ obj -> QuestionResponse(obj.id.toString(),obj.description,obj.answer?.toResponse()) }
                .collect(Collectors.toList())
    }

    fun insert(question: Question) = questionRepository.save(question)

}