package com.quiz.quizService.services;

import com.quiz.quizService.dto.QuizDto;
import com.quiz.quizService.entities.Quiz;

import java.util.List;

public interface QuizService {
    QuizDto getQuiz(Integer quizId);
    QuizDto addQuiz(QuizDto quiz);
    List<QuizDto> getAllQuiz();
    void deleteQuiz(Integer quizId);
}
