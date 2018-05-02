package com.devQuestion.Developer.Questions.domains

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany


@Entity
data class Question(
        @Id
        @GeneratedValue
        var id: Long = 0L,
        var description: String="",

        @OneToMany
        var answer: List<Answer>? = null
)