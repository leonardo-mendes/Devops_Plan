package com.devQuestion.Developer.Questions.domains.request

/**
 * Created by JoaoPedroCardoso on 05/06/18
 */
data class AnswerRequest(val description: String, val action: List<ActionRequest>?, val questionId: Long, val
nextQuestionId: Long)