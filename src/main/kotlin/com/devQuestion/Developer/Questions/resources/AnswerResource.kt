package com.devQuestion.Developer.Questions.resources

import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.reponse.AnswerResponse
import com.devQuestion.Developer.Questions.services.AnswerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/answers")
class AnswerResource {

    @Autowired
    lateinit var answerService: AnswerService

    @GetMapping
    fun findAll(): ResponseEntity<List<AnswerResponse>> = ResponseEntity.ok().body(answerService.findAll())


    @PostMapping
    fun insert(@RequestBody answer: Answer) = ResponseEntity.ok().body(answerService.insert(answer))

}