package com.quiz.questionService.services.impl;


import com.quiz.questionService.dto.QuestionDto;
import com.quiz.questionService.entities.Question;
import com.quiz.questionService.repositories.QuestionRepo;
import com.quiz.questionService.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;
    private final ModelMapper modelMapper;

    @Override
    public QuestionDto getQuestion(Integer QuestionId) {
        Question question = questionRepo.findById(QuestionId).get();
        return modelMapper.map(question, QuestionDto.class);
    }

    @Override
    public QuestionDto addQuestion(QuestionDto questionDto) {
        Question question = this.modelMapper.map(questionDto, Question.class);
        Question savedQuestion = questionRepo.save(question);
        return modelMapper.map(savedQuestion, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = questionRepo.findAll();
        return questions.stream().map(question -> this.modelMapper.map(question, QuestionDto.class)).toList();
    }

    @Override
    public void deleteQuestion(Integer questionId) {
        Question question = questionRepo.findById(questionId).get();
        questionRepo.delete(question);
    }

    @Override
    public List<QuestionDto> getQuestionsByQuizId(Integer quizId) {
        List<Question> questions = this.questionRepo.findByQuizId(quizId);
        return questions.stream().map(question -> this.modelMapper.map(question, QuestionDto.class)).toList();
    }
}
