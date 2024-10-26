package com.quiz.questionService.services;

import com.quiz.questionService.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    QuestionDto getQuestion(Integer questionId);

    QuestionDto addQuestion(QuestionDto questionDto);

    List<QuestionDto> getAllQuestions();

    void deleteQuestion(Integer questionId);

    List<QuestionDto> getQuestionsByQuizId(Integer quizId);
}
