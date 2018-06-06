package com.devQuestion.Developer.Questions

import com.devQuestion.Developer.Questions.domains.Action
import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.Question
import java.util.*

/**
 * Created by JoaoPedroCardoso on 06/06/18
 */
abstract class ServiceBaseTest {

    fun beanAction(): Action = Action(0L,"Test Action",null)

    fun beanAnswer(): Answer = Answer(0L,"Test Answer", Arrays.asList(beanAction()),null,null)

    fun beanQuestion(): Question = Question(0L,"Test Question",Arrays.asList(beanAnswer()))
}