package arcademy.modules.quiz.controllers;

import arcademy.modules.authentication.models.User;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import arcademy.modules.quiz.models.Quiz;
import arcademy.modules.quiz.services.QuizService;

import java.util.Map;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @CrossOrigin
    @ApiResponse(content = @Content(schema = @Schema(anyOf = Quiz.class)))
    @GetMapping(value = "/quizzes/{id}")
    public ResponseEntity<?> getQuiz(@PathVariable long id, @RequestParam String secret) {
        try {
            Quiz quiz = quizService.getQuiz(id, secret);

            return ResponseEntity.ok(quiz);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

    }

    @CrossOrigin
    @ApiResponse(content = @Content(schema = @Schema(anyOf = Quiz.class)))
    @PostMapping(value = "/quizzes")
    public ResponseEntity<?> createQuiz() {
        try {
            Quiz quiz = quizService.createQuiz();
            return ResponseEntity.ok(quiz);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @CrossOrigin
    @ApiResponse(content = @Content(schema = @Schema(anyOf = Quiz.class)))
    @PutMapping(value = "/quizzes/{id}/name")
    public ResponseEntity<?> setName(@PathVariable long id, @RequestParam String secret, @RequestParam String name) {
        try {
            quizService.updateName(id, secret, name);
            Quiz quiz = quizService.getQuiz(id, secret);
            return ResponseEntity.ok(quiz);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
