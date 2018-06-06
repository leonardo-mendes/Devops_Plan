package com.devQuestion.Developer.Questions.services.converter

import com.devQuestion.Developer.Questions.domains.Question
import com.devQuestion.Developer.Questions.domains.reponse.QuestionResponse

/**
 * Created by JoaoPedroCardoso on 05/06/18
 */

fun Question.toResponse(): QuestionResponse = QuestionResponse(id.toString(),description,answer?.toResponse())