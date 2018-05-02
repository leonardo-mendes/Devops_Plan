package com.devQuestion.Developer.Questions.domains

import javax.persistence.*

@Entity
data class Answer(
        @Id
        @GeneratedValue
        var id: Long = 0L,
        var description: String= "",

        @OneToMany
        var action: List<Action>,

        @ManyToOne
        @JoinColumn(name="question_id")
        var question: Question,

        @ManyToOne
        @JoinColumn(name="next_question_id")
        var nextQuestion: Question
)