package arcademy.modules.quiz.controllers;

import arcademy.modules.authentication.models.User;
import arcademy.modules.authentication.repositories.UserRepository;
import arcademy.modules.authentication.services.UserService;
import arcademy.modules.quiz.models.Question;
import arcademy.modules.quiz.models.Quiz;
import arcademy.modules.quiz.services.QuestionService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @ApiResponse(content = @Content(schema = @Schema(anyOf = User.class)))
    @GetMapping(value = "/user/initializeSession")
    public ResponseEntity<?> getQuestion() {
        try {
            User user = userService.createUser();
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @CrossOrigin
    @ApiResponse(content = @Content(schema = @Schema(anyOf = User.class)))
    @PostMapping(value = "/user/changeName")
    public ResponseEntity<?> changeName(@RequestBody Map<String,String> name, @RequestHeader("token") String token) {
        try {
            User user = userService.changeName(token, name.get("username"));
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
