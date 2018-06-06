package com.devQuestion.Developer.Questions.services.Action

import com.devQuestion.Developer.Questions.ServiceBaseTest
import com.devQuestion.Developer.Questions.repositories.ActionRepository
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import com.devQuestion.Developer.Questions.services.ActionService
import com.nhaarman.mockito_kotlin.*
import javassist.NotFoundException
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.util.*

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

    @Test
    fun findActionByIdWithSuccess() {
        var action = beanAction()
        var actionCollection = Optional.of(action)
        whenever(actionRepository.findById(any())).thenReturn(actionCollection)
        val response = actionService.findById(action.id)
        assertEquals(action.description, response.description)
        assertEquals(action.id.toString(), response.id)
    }

    @Ignore
    @Test(expected = NotFoundException::class)
    fun findActionByIdWithIdNotFound() {
        whenever(actionRepository.findById(1L)).thenThrow(NotFoundException("Action id Not Found!"))
        actionService.findById(1L)
    }

    @Test
    fun findAllActionWithSuccess() {
        var action = beanAction()
        var actionCollection = Arrays.asList(action)
        whenever(actionRepository.findAll()).thenReturn(actionCollection)
        val response = actionService.findAll()
        assertTrue(response.isNotEmpty())
        assertTrue(response[0].id.isNotEmpty())
    }

    @Test
    fun deleteActionWithSuccess() {
        var action = beanAction()
        doNothing().`when`(actionRepository).delete(action)
        actionService.delete(action.id)
    }

    @Ignore
    @Test(expected = NotFoundException::class)
    fun deleteActionWithIdNotFound() {
        var action = beanAction()
        doThrow(NotFoundException("Action id Not Found!")).whenever(actionRepository).delete(action)
    }

}