package com.devQuestion.Developer.Questions.domains.reponse

/**
 * Created by JoaoPedroCardoso on 05/06/18
 */
data class AnswerResponse(val id: String, val description: String, val action: List<ActionResponse>?, val questionId:
String?, val nextQuestionId: String?)