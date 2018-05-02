package com.devQuestion.Developer.Questions.repositories

import com.devQuestion.Developer.Questions.domains.Question
import org.springframework.data.repository.CrudRepository

interface QuestionRepository : CrudRepository<Question, Long>