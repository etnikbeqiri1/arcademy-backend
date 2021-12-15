package arcademy.modules.quiz.services;

import arcademy.modules.quiz.models.Question;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arcademy.modules.quiz.models.Quiz;
import arcademy.modules.quiz.repositories.QuizRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz getQuiz(final long id, final String secret) throws Exception {
        Quiz quiz = quizRepository.findByIdAndSecret(id, secret).orElseThrow(() -> new Exception("Quiz not found"));
        return quiz;
    }

    public void updateName(long id, final String secret, String name) throws Exception {
        Quiz quiz = getQuiz(id, secret);
        quiz.setName(name);
        quizRepository.save(quiz);
    }

    public boolean isValidQuizCode(String code) {
        return quizRepository.findByQuizCode(code).size() == 0;
    }

    public Quiz createQuiz() {
        Quiz quiz = new Quiz();
        quiz.setSecret(UUID.randomUUID().toString());

        String generatedCode;
        do {
            generatedCode = RandomStringUtils.randomAlphabetic(6).toUpperCase(Locale.ROOT);
        } while (!isValidQuizCode(generatedCode));

        quiz.setQuizCode(generatedCode);
        return quizRepository.save(quiz);
    }




}
