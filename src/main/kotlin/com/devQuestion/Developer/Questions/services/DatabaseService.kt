package com.devQuestion.Developer.Questions.services

import com.devQuestion.Developer.Questions.domains.Action
import com.devQuestion.Developer.Questions.domains.Answer
import com.devQuestion.Developer.Questions.domains.Question
import com.devQuestion.Developer.Questions.repositories.ActionRepository
import com.devQuestion.Developer.Questions.repositories.AnswerRepository
import com.devQuestion.Developer.Questions.repositories.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.ParseException
import java.util.*

@Service
class DatabaseService {

    @Autowired
    lateinit var actionRepository: ActionRepository

    @Autowired
    lateinit var questionRepository: QuestionRepository

    @Autowired
    lateinit var answerRepository: AnswerRepository

    @Throws(ParseException::class)
    fun instantiateTestDataBase() {

        val question1 = Question(description = "question1")
        val question2 = Question(description = "question2")
        val question3 = Question(description = "question3")
        val question4 = Question(description = "question4")

        val answer1 = Answer(description = "answer1", question = question1, nextQuestion = question2)
        val answer2 = Answer(description = "answer2", question = question1, nextQuestion = question3)
        val answer3 = Answer(description = "answer3", question = question2, nextQuestion = question4)
        val answer4 = Answer(description = "answer4", question = question2, nextQuestion = question4)
        val answer5 = Answer(description = "answer5", question = question3, nextQuestion = question4)
        val answer6 = Answer(description = "answer6", question = question3, nextQuestion = question4)

        val action1 = Action(description = "action1", answer = answer1)
        val action2 = Action(description = "action2", answer = answer1)
        val action3 = Action(description = "action3", answer = answer2)
        val action4 = Action(description = "action4", answer = answer3)
        val action5 = Action(description = "action5", answer = answer5)
        val action6 = Action(description = "action6", answer = answer6)

        question1.answer.let {
            it?.addAll(Arrays.asList(answer1, answer2))
        }

        question2.answer.let {
            it?.addAll(Arrays.asList(answer3, answer4))
        }

        question3.answer.let {
            it?.addAll(Arrays.asList(answer5, answer6))
        }

        answer1.action.let {
            it?.addAll(Arrays.asList(action1, action2))
        }

        answer2.action.let {
            it?.add(action3)
        }

        answer3.action.let {
            it?.addAll(Arrays.asList(action4))
        }

        answer5.action.let {
            it?.addAll(Arrays.asList(action5))
        }

        answer6.action.let {
            it?.addAll(Arrays.asList(action6))
        }

        questionRepository.saveAll(Arrays.asList(question1, question2, question3, question4))
        answerRepository.saveAll(Arrays.asList(answer1, answer2, answer3, answer4, answer5, answer6))
        actionRepository.saveAll(Arrays.asList(action1, action2, action3, action4, action4, action5, action6))

    }

}