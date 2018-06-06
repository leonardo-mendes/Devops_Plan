package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Action
import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.Question
import com.devQuestion.Developer.Questions.domains.reponse.QuestionResponse
import com.devQuestion.Developer.Questions.domains.request.AnswerRequest
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
import com.devQuestion.Developer.Questions.services.converter.toResponse
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class QuestionService @Autowired constructor(private val questionRepository: QuestionRepository,
                                             private val answerRepository: AnswerRepository){

    fun findAll(): List<QuestionResponse> {
        val list = questionRepository.findAll().toList()
        return list.stream().map{ obj -> QuestionResponse(obj.id.toString(),obj.description,obj.answer?.toResponse()) }
                .collect(Collectors.toList())
    }

    fun findById(id: Long): QuestionResponse = questionRepository.findById(id).get().toResponse()

    fun delete(id: Long) = questionRepository.deleteById(id)

    fun insert(question: Question) = questionRepository.save(question)

    fun update(id: Long, answerId: Long, actionList: List<Action>) {
        val question = questionRepository.findById(id)

        if(!question.isPresent){
            throw NotFoundException("Question Not Found!")
        }
        val questionSave = question.get()
        questionSave.answer?.forEach { answer: Answer ->
            run {
                if (answer.id == answerId) {
                    answer.action = actionList
                }
            }
        }
        questionRepository.save(questionSave)
    }

    fun updateNextQuestion(id: Long, answerRequest: Answer, actionList: List<Action>) {
        val question = questionRepository.findById(id)

        if(!question.isPresent){
            throw NotFoundException("Question Not Found!")
        }

        val finalAnswer = arrayListOf<Answer>()
        finalAnswer.addAll(question.get().answer!!)
        finalAnswer.add(answerRequest)
        question.get().answer = finalAnswer

        val questionSave = question.get()
        questionSave.answer?.forEach { answer: Answer ->
            run {
                if (answer.id == answerRequest.id) {
                    answer.action = actionList
                }
            }
        }

        questionRepository.save(questionSave)
    }
}