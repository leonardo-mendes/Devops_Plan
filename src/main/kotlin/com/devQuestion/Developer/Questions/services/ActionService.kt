package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Action
import com.devQuestion.Developer.Questions.domains.reponse.ActionResponse
import com.devQuestion.Developer.Questions.repositories.ActionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ActionService{

    @Autowired
    lateinit var actionRepository: ActionRepository

    fun findAll(): List<ActionResponse> {
        val list = actionRepository.findAll().toList()
        return list.stream().map{ obj -> ActionResponse(obj.id.toString(),obj.description,
                obj.answer?.id.toString()) }.collect(Collectors.toList())
    }

    fun insert(action: Action) = actionRepository.save(action)

}