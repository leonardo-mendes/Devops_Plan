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

@Autowired
lateinit var answerRepository: AnswerRepository

@Autowired
lateinit var questionRepositorys: QuestionRepository

private var questionService: QuestionService = QuestionService(questionRepositorys)

private var answerService: AnswerService = AnswerService(answerRepository,questionService)

fun Action.toResponse(): ActionResponse = ActionResponse(id.toString(),description,answer?.id.toString())

fun List<Action>.toResponse(): List<ActionResponse> {
    val response = arrayListOf<ActionResponse>()
    this.forEach {response.add(
            ActionResponse(it.id.toString(),it.description,it.answer?.id.toString())
    )  }
 return response
}


fun List<ActionResponse>.toResponseDomain(): List<Action> {
    val response = arrayListOf<Action>()
    this.forEach {
        val answer = it.answerId?.isNotEmpty().run{
            answerService.findById(it.answerId!!.toLong()).toDomain()
        }

        response.add(
                Action(0L,it.description,answer)
        )  }
    return response
}

fun ActionResponse.toResponseDomain(): Action {
    val answer = answerId?.isNotEmpty().let {
        answerService.findById(answerId!!.toLong()).toDomain()
    }
    return Action(description = description,answer = answer)
}

fun List<ActionRequest>.toRequestDomain(): List<Action> {
    val response = arrayListOf<Action>()
    this.forEach {
        val answer = it.answerId?.run{
            answerService.findById(it.answerId).toDomain()
        }

        response.add(
                Action(0L,it.description,answer)
        )  }
    return response
}

fun ActionRequest.toRequestDomain(): Action {
    val answer = answerId?.let {
        answerService.findById(answerId).toDomain()
    }
    return Action(description = description,answer = answer)
}
