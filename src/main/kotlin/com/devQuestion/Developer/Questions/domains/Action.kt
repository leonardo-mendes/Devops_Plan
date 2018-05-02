package com.devQuestion.Developer.Questions.domains

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Action(
    @Id
    @GeneratedValue
    var id: Long = 0L,
    var description: String = "",

    @ManyToOne
    @JoinColumn(name="answer_id")
    var answer: Answer? = null
)