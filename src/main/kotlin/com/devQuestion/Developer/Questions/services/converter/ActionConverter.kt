package com.devQuestion.Developer.Questions.services.converter

import com.devQuestion.Developer.Questions.domains.Action
import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.reponse.ActionResponse
import com.devQuestion.Developer.Questions.domains.reponse.AnswerResponse
import com.devQuestion.Developer.Questions.domains.request.ActionRequest
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
import com.devQuestion.Developer.Questions.services.AnswerService
import com.devQuestion.Developer.Questions.services.QuestionService
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by JoaoPedroCardoso on 05/06/18
 */

fun Action.toResponse(): ActionResponse = ActionResponse(id.toString(),description,answer?.id.toString())

fun List<Action>.toResponse(): List<ActionResponse> {
    val response = arrayListOf<ActionResponse>()
    this.forEach {response.add(
            ActionResponse(it.id.toString(),it.description,it.answer?.id.toString())
    )  }
 return response
}

