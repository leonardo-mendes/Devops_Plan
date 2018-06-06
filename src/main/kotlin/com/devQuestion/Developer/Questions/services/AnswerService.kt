package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Action
import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.reponse.AnswerResponse
import com.devQuestion.Developer.Questions.domains.request.ActionRequest
import com.devQuestion.Developer.Questions.domains.request.AnswerRequest
import com.devQuestion.Developer.Questions.repositories.ActionRepository
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
import com.devQuestion.Developer.Questions.services.converter.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Consumer
import java.util.stream.Collectors

@Service
class AnswerService @Autowired constructor(private val answerRepository: AnswerRepository,
                                           private val questionRepository: QuestionRepository,
                                           private val questionService: QuestionService,
                                           private val actionRepository: ActionRepository){

    fun findAll(): List<AnswerResponse> {
        val list = answerRepository.findAll().toList()
        return list.stream().map{ obj -> AnswerResponse(obj.id.toString(),obj.description,obj.action?.toResponse(),
                obj.question?.id.toString(),obj.nextQuestion?.id.toString()) }.collect(Collectors.toList())
    }

    fun findById(id: Long): AnswerResponse = answerRepository.findById(id).get().toResponse()

    fun delete(id: Long) = answerRepository.deleteById(id)

    fun insert(answer: AnswerRequest) {
        val actionList = arrayListOf<Action>()

        val question =  questionRepository.findById(answer.questionId).get()
        val nextQuestion = questionRepository.findById(answer.nextQuestionId).get()
        answer.action?.stream()?.forEach({ t ->
            if (answerRepository.findById(t.answerId).isPresent){
                run {
                    actionList.add(Action(description = t.description,answer = answerRepository.findById(t.answerId).get()))
                }
            }else{
                run {
                    actionList.add(Action(description = t.description))
                }
            }
        })

        val retorno = actionRepository.saveAll(actionList).toList()

        val insert = Answer(description = answer.description
                , action = retorno
                , question = question
                ,nextQuestion = nextQuestion
        )

        val answer = answerRepository.save(insert)
        questionService.update(question.id,answer.id,retorno)
        questionService.updateNextQuestion(nextQuestion.id,answer,retorno)
    }

}