package com.devQuestion.Developer.Questions.services.converter

import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.reponse.AnswerResponse
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
import com.devQuestion.Developer.Questions.services.QuestionService
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by JoaoPedroCardoso on 05/06/18
 */


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
