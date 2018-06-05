package com.devQuestion.Developer.Questions.domains

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Answer(
        @Id
        @GeneratedValue
        var id: Long = 0L,
        var description: String= "",

        @OneToMany(mappedBy = "answer")
        var action: List<Action>? = null,

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name="question_id")
        var question: Question? = null,

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name="next_question_id")
        var nextQuestion: Question? = null
)