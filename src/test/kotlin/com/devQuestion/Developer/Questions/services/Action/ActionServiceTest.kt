package com.devQuestion.Developer.Questions.services.Action

import com.devQuestion.Developer.Questions.ServiceBaseTest
import com.devQuestion.Developer.Questions.repositories.ActionRepository
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import com.devQuestion.Developer.Questions.services.ActionService
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

/**
 * Created by JoaoPedroCardoso on 06/06/18
 */
class ActionServiceTest: ServiceBaseTest() {


    private val actionRepository: ActionRepository = mock()
    private val answerRepository: AnswerRepository = mock()

    private lateinit var actionService: ActionService

    @Before
    fun init() {
        actionService = ActionService(actionRepository,answerRepository)
    }

    @Ignore
    @Test
    fun createSalesForceSuccess() {

    }

}