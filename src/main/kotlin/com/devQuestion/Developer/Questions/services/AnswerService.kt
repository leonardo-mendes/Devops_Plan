package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.reponse.AnswerResponse
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import com.devQuestion.Developer.Questions.services.converter.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AnswerService{

    @Autowired
    lateinit var answerRepository: AnswerRepository

    fun findAll(): List<AnswerResponse> {
        val list = answerRepository.findAll().toList()
        return list.stream().map{ obj -> AnswerResponse(obj.id.toString(),obj.description,obj.action?.toResponse(),
                obj.question?.id.toString(),obj.nextQuestion?.id.toString()) }.collect(Collectors.toList())
    }

    fun findById(id: Long): AnswerResponse = answerRepository.findById(id).get().toResponse()

    fun delete(id: Long) = answerRepository.delete(answerRepository.findById(id).get())

    fun insert(answer: Answer) = answerRepository.save(answer)

}