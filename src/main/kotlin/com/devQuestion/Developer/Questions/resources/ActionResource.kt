package com.devQuestion.Developer.Questions.resources

import com.devQuestion.Developer.Questions.domains.Action
import com.devQuestion.Developer.Questions.domains.reponse.ActionResponse
import com.devQuestion.Developer.Questions.services.ActionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/actions")
class ActionResource {

    @Autowired
    lateinit var actionService: ActionService

    @GetMapping
    fun findAll(): ResponseEntity<List<ActionResponse>> = ResponseEntity.ok().body(actionService.findAll())


    @PostMapping
    fun insert(@RequestBody action: Action) = ResponseEntity.ok().body(actionService.insert(action))

}