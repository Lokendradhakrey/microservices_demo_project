package com.quiz.quizService.repositories;

import com.quiz.quizService.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}
