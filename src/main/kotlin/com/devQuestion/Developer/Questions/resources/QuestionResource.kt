package com.devQuestion.Developer.Questions.resources

import com.devQuestion.Developer.Questions.domains.Question
import com.devQuestion.Developer.Questions.domains.reponse.QuestionResponse
import com.devQuestion.Developer.Questions.services.QuestionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/questions")
class QuestionResource {

    @Autowired
    lateinit var questionService: QuestionService

    @GetMapping
    fun findAll(): ResponseEntity<List<QuestionResponse>> = ResponseEntity.ok().body(questionService.findAll())


    @PostMapping
    fun insert(@RequestBody question: Question) = ResponseEntity.ok().body(questionService.insert(question))

}