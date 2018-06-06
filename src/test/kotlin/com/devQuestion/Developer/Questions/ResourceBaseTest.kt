package com.devQuestion.Developer.Questions

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration

/**
 * Created by JoaoPedroCardoso on 06/06/18
 */

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [(DeveloperQuestionsApplicationTests::class)])
abstract class ResourceBaseTest {

}