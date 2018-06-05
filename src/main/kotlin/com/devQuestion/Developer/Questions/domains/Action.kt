package com.devQuestion.Developer.Questions.domains

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Action(
    @Id
    @GeneratedValue
    var id: Long = 0L,
    var description: String = "",

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="answer_id")
    var answer: Answer? = null
)