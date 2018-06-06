package com.devQuestion.Developer.Questions.resources

import com.devQuestion.Developer.Questions.domains.reponse.ActionResponse
import com.devQuestion.Developer.Questions.domains.request.ActionRequest
import com.devQuestion.Developer.Questions.services.ActionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/actions")
class ActionResource @Autowired constructor(private val actionService: ActionService){

    @GetMapping
    fun findAll(): ResponseEntity<List<ActionResponse>> = ResponseEntity.ok().body(actionService.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable( value = "id") id: Long): ResponseEntity<ActionResponse> = ResponseEntity.ok()
            .body(actionService.findById(id))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable( value = "id") id: Long): ResponseEntity<Any> = ResponseEntity.ok()
            .body(actionService.delete(id))

    @PostMapping
    fun insert(@RequestBody action: ActionRequest) = ResponseEntity.ok().body(actionService.insert(action))

}