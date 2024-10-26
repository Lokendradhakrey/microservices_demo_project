package com.quiz.quizService.services.impl;

import com.quiz.quizService.dto.QuizDto;
import com.quiz.quizService.entities.Quiz;
import com.quiz.quizService.repositories.QuizRepo;
import com.quiz.quizService.services.QuestionClient;
import com.quiz.quizService.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepo quizRepo;
    private final ModelMapper modelMapper;
    private final QuestionClient questionClient;

    @Override
    public QuizDto getQuiz(Integer quizId) {
    Quiz quiz  = quizRepo.findById(quizId).get();
    QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
    quizDto.setQuestions(questionClient.getQuestionOfQuiz(quizId));
    return quizDto;
    }

    @Override
    public QuizDto addQuiz(QuizDto quizDto) {
       Quiz quiz = this.modelMapper.map(quizDto, Quiz.class);
       Quiz savedQuiz = quizRepo.save(quiz);
       return modelMapper.map(savedQuiz, QuizDto.class);
    }



    @Override
    public List<QuizDto> getAllQuiz() {
        List<Quiz> quizList = quizRepo.findAll();
        List<QuizDto> quizDtos =  quizList.stream().map(quiz -> this.modelMapper.map(quiz, QuizDto.class)).toList();
        quizDtos.stream().map(quizDto -> {
            quizDto.setQuestions(questionClient.getQuestionOfQuiz(quizDto.getId()));
            return quizDto;
        }).toList();
        return quizDtos;
    }

    @Override
    public void deleteQuiz(Integer quizId) {
       Quiz quiz = quizRepo.findById(quizId).get();
       quizRepo.delete(quiz);
    }
}
