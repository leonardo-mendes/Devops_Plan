package com.devQuestion.Developer.Questions.domains

import javax.persistence.*

@Entity
data class Answer(
        @Id
        @GeneratedValue
        var id: Long = 0L,
        var description: String= "",

        @OneToMany
        var action: MutableList<Action>? = null,

        @ManyToOne
        @JoinColumn(name="question_id")
        var question: Question? = null,

        @ManyToOne
        @JoinColumn(name="next_question_id")
        var nextQuestion: Question? = null
)