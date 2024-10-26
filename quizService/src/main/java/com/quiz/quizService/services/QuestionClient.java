package com.quiz.quizService.services;

import com.quiz.quizService.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082", name = "question-client")
@FeignClient(name = "Question-Service")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question>  getQuestionOfQuiz(@PathVariable Integer quizId);
}
