package com.quiz.quizService.dto;

import com.quiz.quizService.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDto {
    private Integer id;
    private String title;
    private List<Question> questions;
}
