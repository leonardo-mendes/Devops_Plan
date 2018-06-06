package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Action
import com.devQuestion.Developer.Questions.domains.reponse.ActionResponse
import com.devQuestion.Developer.Questions.domains.request.ActionRequest
import com.devQuestion.Developer.Questions.repositories.ActionRepository
import com.devQuestion.Developer.Questions.services.converter.toDomain
import com.devQuestion.Developer.Questions.services.converter.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ActionService{

    @Autowired
    lateinit var actionRepository: ActionRepository

    @Autowired
    lateinit var answerService: AnswerService

    fun findAll(): List<ActionResponse> {
        val list = actionRepository.findAll().toList()
        return list.stream().map{ obj -> ActionResponse(obj.id.toString(),obj.description,
                obj.answer?.id.toString()) }.collect(Collectors.toList())
    }

    fun findById(id: Long): ActionResponse = actionRepository.findById(id).get().toResponse()

    fun delete(id: Long) = actionRepository.delete(actionRepository.findById(id).get())

    fun insert(action: ActionRequest) = actionRepository.save(Action(description = action.description,
            answer = answerService.findById(action.answerId).toDomain()))
}