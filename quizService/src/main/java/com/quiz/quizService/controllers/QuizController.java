package com.quiz.quizService.controllers;

import com.quiz.quizService.dto.QuizDto;
import com.quiz.quizService.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping("/{quizId}")
    public ResponseEntity<QuizDto> getQuiz(@PathVariable Integer quizId) {
        QuizDto quizDto = this.quizService.getQuiz(quizId);
        return ResponseEntity.ok(quizDto);
    }

    @PostMapping("/add-quiz")
    public ResponseEntity<QuizDto> addQuiz(@RequestBody QuizDto quizDto) {
        QuizDto quiz = this.quizService.addQuiz(quizDto);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }
    @GetMapping("/all-quiz")
    public ResponseEntity<List<QuizDto>> getAllQuiz() {
        List<QuizDto> quizDtos = this.quizService.getAllQuiz();
        return ResponseEntity.ok(quizDtos);
    }
    @DeleteMapping("/delete/{quizId}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Integer quizId) {
        this.quizService.deleteQuiz(quizId);
        return ResponseEntity.ok("Quiz deleted");
    }
}
