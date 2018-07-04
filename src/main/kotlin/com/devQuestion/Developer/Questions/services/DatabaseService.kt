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

        val question1 = Question(description = "Voce ja tem passaporte?")
        val question2 = Question(description = "O Pais que voce vai precisa de visto?")
        val question3 = Question(description = "O seu visto esta atualizado?")
        val question4 = Question(description = "question4")

        val answer1 = Answer(description = "Nao", question = question1, nextQuestion = question2)
        val answer2 = Answer(description = "Sim", question = question1)
        val answer3 = Answer(description = "Sim", question = question2, nextQuestion = question4)
        val answer4 = Answer(description = "Nao", question = question2)
        val answer5 = Answer(description = "Sim", question = question3)
        val answer6 = Answer(description = "Nao", question = question3)

        val action1 = Action(description = "Dar entrada na papelada, pedir passaporte!")
        val action2 = Action(description = "action2")
        val action3 = Action(description = "action3")
        val action4 = Action(description = "Buscar a embaixada para pegar documentos")
        val action5 = Action(description = "Be happy")
        val action6 = Action(description = "Atualizar o visto")

        questionRepository.saveAll(Arrays.asList(question1, question2, question3, question4))
        actionRepository.saveAll(Arrays.asList(action1, action2, action3, action4, action4, action5, action6))
        answerRepository.saveAll(Arrays.asList(answer1, answer2, answer3, answer4, answer5, answer6))

        action1.answer = answer1
        //action2.answer = answer1
        //action3.answer = answer2
        action4.answer = answer3
        action5.answer = answer5
        action6.answer = answer6

        actionRepository.saveAll(Arrays.asList(action1, action2, action3, action4, action4, action5, action6))

        answer1.action = Arrays.asList(action1, action2)

        answer2.action = Arrays.asList(action3)

        answer3.action = Arrays.asList(action4)

        answer5.action = Arrays.asList(action5)

        answer6.action = Arrays.asList(action6)

        answerRepository.saveAll(Arrays.asList(answer1, answer2, answer3, answer4, answer5, answer6))

        question1.answer = Arrays.asList(answer1, answer2)

        question2.answer = Arrays.asList(answer3, answer4)

        question3.answer = Arrays.asList(answer5, answer6)

        questionRepository.saveAll(Arrays.asList(question1, question2, question3, question4))
        actionRepository.saveAll(Arrays.asList(action1, action2, action3, action4, action4, action5, action6))
    }

}