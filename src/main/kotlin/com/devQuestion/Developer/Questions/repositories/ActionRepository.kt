package com.devQuestion.Developer.Questions.repositories

import com.devQuestion.Developer.Questions.domains.Action
import org.springframework.data.repository.CrudRepository

interface ActionRepository : CrudRepository<Action, Long>