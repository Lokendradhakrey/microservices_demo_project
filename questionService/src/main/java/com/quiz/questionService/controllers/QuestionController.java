package com.quiz.questionService.controllers;



import com.quiz.questionService.dto.QuestionDto;
import com.quiz.questionService.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable Integer questionId) {
        QuestionDto questionDto = this.questionService.getQuestion(questionId);
        return ResponseEntity.ok(questionDto);
    }

    @PostMapping("/add-question")
    public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionDto questionDto) {
        QuestionDto question = this.questionService.addQuestion(questionDto);
        return new ResponseEntity<QuestionDto>(question, HttpStatus.CREATED);
    }
    @GetMapping("/all-question")
    public ResponseEntity<List<QuestionDto>> getAllQuestion() {
        List<QuestionDto> questionDtos = this.questionService.getAllQuestions();
        return ResponseEntity.ok(questionDtos);
    }
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<QuestionDto>> getAllQuestionByQuiz(@PathVariable Integer quizId) {
        List<QuestionDto> questionDtos = this.questionService.getQuestionsByQuizId(quizId);
        return ResponseEntity.ok(questionDtos);
    }
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Integer questionId) {
        this.questionService.deleteQuestion(questionId);
        return ResponseEntity.ok("Question deleted");
    }
}
