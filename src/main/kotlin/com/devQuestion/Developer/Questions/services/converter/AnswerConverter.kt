package com.devQuestion.Developer.Questions.services.converter

import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.reponse.AnswerResponse
import com.devQuestion.Developer.Questions.services.QuestionService
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by JoaoPedroCardoso on 05/06/18
 */

//TODO Fix it
@Autowired
lateinit var questionService: QuestionService

fun List<Answer>.toResponse(): List<AnswerResponse> {
    val response = arrayListOf<AnswerResponse>()
    this.forEach {response.add(
            AnswerResponse(id = it.id.toString(),
                    description = it.description,
                    action = it.action?.toResponse(),
                    questionId = it.question?.id.toString(),
                    nextQuestionId = it.nextQuestion?.id.toString())
    )  }
    return response
}

fun Answer.toResponse(): AnswerResponse = AnswerResponse(id.toString(),description,action?.toResponse(),question?.id.toString(),
        nextQuestion?.id.toString())

fun AnswerResponse.toDomain(): Answer {
    val question = questionId?.isNotEmpty().let {
        questionService.findById(questionId!!.toLong()).toResponseDomain()
    }
    val nextQuestion = nextQuestionId?.isNotEmpty().let {
        questionService.findById(nextQuestionId!!.toLong()).toResponseDomain()
    }

    return Answer(description = description, action = action?.toResponseDomain()
            , question = question, nextQuestion = nextQuestion)
}

fun List<AnswerResponse>.toDomain(): List<Answer> {
    val response = arrayListOf<Answer>()
    this.forEach {response.add(it.toDomain())  }
    return response
}
