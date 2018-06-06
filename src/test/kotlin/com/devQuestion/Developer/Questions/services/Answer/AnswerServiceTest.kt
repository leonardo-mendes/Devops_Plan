package com.devQuestion.Developer.Questions.services.Answer

import com.devQuestion.Developer.Questions.ServiceBaseTest
import com.devQuestion.Developer.Questions.repositories.ActionRepository
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
import com.devQuestion.Developer.Questions.services.ActionService
import com.devQuestion.Developer.Questions.services.AnswerService
import com.devQuestion.Developer.Questions.services.QuestionService
import com.nhaarman.mockito_kotlin.*
import javassist.NotFoundException
import junit.framework.Assert
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.util.*

/**
 * Created by JoaoPedroCardoso on 06/06/18
 */
class AnswerServiceTest: ServiceBaseTest() {

    private val actionRepository: ActionRepository = mock()
    private val answerRepository: AnswerRepository = mock()
    private val questionRepository: QuestionRepository = mock()
    private val questionService: QuestionService = mock()

    private lateinit var answerService: AnswerService

    @Before
    fun init() {
        answerService = AnswerService(actionRepository = actionRepository,answerRepository = answerRepository,
                questionRepository = questionRepository,questionService = questionService)
    }

    @Test
    fun findAnswerByIdWithSuccess() {
        var answer = beanAnswer()
        var answerCollection = Optional.of(answer)
        whenever(answerRepository.findById(any())).thenReturn(answerCollection)
        val response = answerService.findById(answer.id)
        Assert.assertEquals(answer.description, response.description)
        Assert.assertEquals(answer.id.toString(), response.id)
    }

    @Ignore
    @Test(expected = NotFoundException::class)
    fun findAnswerByIdWithIdNotFound() {
        whenever(answerRepository.findById(1L)).thenThrow(NotFoundException("Action id Not Found!"))
        answerService.findById(1L)
    }

    @Test
    fun findAllAnswerWithSuccess() {
        var answer = beanAnswer()
        var answerCollection = Arrays.asList(answer)
        whenever(answerRepository.findAll()).thenReturn(answerCollection)
        val response = answerService.findAll()
        assertTrue(response.isNotEmpty())
        assertTrue(response[0].id.isNotEmpty())
    }

    @Test
    fun deleteAnswerWithSuccess() {
        var answer = beanAnswer()
        doNothing().`when`(answerRepository).delete(answer)
        answerService.delete(answer.id)
    }

    @Ignore
    @Test(expected = NotFoundException::class)
    fun deleteAnswerWithIdNotFound() {
        var answer = beanAnswer()
        doThrow(NotFoundException("Action id Not Found!")).whenever(answerRepository).delete(answer)
    }

}