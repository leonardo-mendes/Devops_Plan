package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Action
import com.devQuestion.Developer.Questions.repositories.ActionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ActionService{

    @Autowired
    lateinit var actionRepository: ActionRepository

    fun findAll(): List<Action> = actionRepository.findAll().toList()

    fun insert(action: Action) = actionRepository.save(action)

}