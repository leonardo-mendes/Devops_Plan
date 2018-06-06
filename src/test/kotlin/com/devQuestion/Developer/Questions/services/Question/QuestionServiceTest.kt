package com.devQuestion.Developer.Questions.services.Question

import com.devQuestion.Developer.Questions.ServiceBaseTest
import com.devQuestion.Developer.Questions.repositories.ActionRepository
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
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
class QuestionServiceTest: ServiceBaseTest() {

    private val answerRepository: AnswerRepository = mock()
    private val questionRepository: QuestionRepository = mock()

    private lateinit var questionService: QuestionService

    @Before
    fun init() {
        questionService = QuestionService(questionRepository = questionRepository,answerRepository = answerRepository)
    }

    @Test
    fun findQuestionByIdWithSuccess() {
        var question = beanQuestion()
        var questionCollection = Optional.of(question)
        whenever(questionRepository.findById(any())).thenReturn(questionCollection)
        val response = questionService.findById(question.id)
        Assert.assertEquals(question.description, response.description)
        Assert.assertEquals(question.id.toString(), response.id)
    }

    @Ignore
    @Test(expected = NotFoundException::class)
    fun findQuestionByIdWithIdNotFound() {
        whenever(questionRepository.findById(1L)).thenThrow(NotFoundException("Action id Not Found!"))
        questionService.findById(1L)
    }

    @Test
    fun findAllQuestionWithSuccess() {
        var question = beanQuestion()
        var questionCollection = Arrays.asList(question)
        whenever(questionRepository.findAll()).thenReturn(questionCollection)
        val response = questionService.findAll()
        assertTrue(response.isNotEmpty())
        assertTrue(response[0].id.isNotEmpty())
    }

    @Test
    fun deleteAnswerWithSuccess() {
        var question = beanQuestion()
        doNothing().`when`(questionRepository).delete(question)
        questionService.delete(question.id)
    }

    @Ignore
    @Test(expected = NotFoundException::class)
    fun deleteAnswerWithIdNotFound() {
        var question = beanQuestion()
        doThrow(NotFoundException("Action id Not Found!")).whenever(questionRepository).delete(question)
    }
}