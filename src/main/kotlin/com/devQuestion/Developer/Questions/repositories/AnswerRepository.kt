package com.devQuestion.Developer.Questions.repositories

import com.devQuestion.Developer.Questions.domains.Answer
import org.springframework.data.repository.CrudRepository

interface AnswerRepository : CrudRepository<Answer, Long>