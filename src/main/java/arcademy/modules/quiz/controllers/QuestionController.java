package arcademy.modules.quiz.controllers;

import arcademy.modules.quiz.models.Question;
import arcademy.modules.quiz.models.Quiz;
import arcademy.modules.quiz.services.QuestionService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @CrossOrigin
    @ApiResponse(content = @Content(schema = @Schema(anyOf = Question.class)))
    @GetMapping(value = "/quizzes/{id}/{questionPointer}")
    public ResponseEntity<?> getQuestion(@PathVariable long id, @RequestParam String secret, @PathVariable int questionPointer) {
        try {
            questionService.getQuestion(id, secret, questionPointer);
            Question question = questionService.getQuestion(id, secret, questionPointer);
            return ResponseEntity.ok(question);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @CrossOrigin
    @ApiResponse(content = @Content(schema = @Schema(anyOf = Question.class)))
    @PostMapping(value = "/quizzes/{id}/")
    public ResponseEntity<?> addQuestion(@PathVariable long id,
                                         @RequestParam String secret,
                                         @RequestBody Question question) {
        try {
            Question q = questionService.addQuestion(id, secret, question);
            return ResponseEntity.ok(q);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @CrossOrigin
    @ApiResponse(content = @Content(schema = @Schema(anyOf = Question.class)))
    @PutMapping(value = "/quizzes/{id}/{questionPointer}")
    public ResponseEntity<?> editQuestion(@PathVariable long id,
                                          @RequestParam String secret,
                                          @PathVariable int questionPointer,
                                          @RequestBody Question question) {
        try {
            Question q = questionService.updateQuestion(id, secret, questionPointer, question);
            return ResponseEntity.ok(q);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @CrossOrigin
    @ApiResponse(content = @Content(schema = @Schema(anyOf = Question.class)))
    @DeleteMapping(value = "/quizzes/{id}/{questionPointer}")
    public ResponseEntity<?> deleteQuestion(@PathVariable long id,
                                          @RequestParam String secret,
                                          @PathVariable int questionPointer) {
        try {
            questionService.deleteQuestion(id, secret, questionPointer);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
