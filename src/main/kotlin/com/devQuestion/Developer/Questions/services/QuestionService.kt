package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.Question
import com.devQuestion.Developer.Questions.domains.reponse.QuestionResponse
import com.devQuestion.Developer.Questions.domains.request.AnswerRequest
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
import com.devQuestion.Developer.Questions.services.converter.toResponse
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class QuestionService @Autowired constructor(private val questionRepository: QuestionRepository){

    fun findAll(): List<QuestionResponse> {
        val list = questionRepository.findAll().toList()
        return list.stream().map{ obj -> QuestionResponse(obj.id.toString(),obj.description,obj.answer?.toResponse()) }
                .collect(Collectors.toList())
    }

    fun findById(id: Long): QuestionResponse = questionRepository.findById(id).get().toResponse()

    fun delete(id: Long) = questionRepository.delete(questionRepository.findById(id).get())

    fun insert(question: Question) = questionRepository.save(question)

    fun update(id: Long, answerRequest: Answer) {
        val question = questionRepository.findById(id)

        if(!question.isPresent){
            throw NotFoundException("Question Not Found!")
        }

        val finalAnswer = Arrays.asList(answerRequest)

        question.get().answer?.isNotEmpty().let {
            finalAnswer.addAll(question.get().answer!!)
        }

        question.get().answer = finalAnswer
        questionRepository.save(question.get())
    }
}