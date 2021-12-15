package arcademy.modules.quiz.services;

import arcademy.modules.quiz.models.Question;
import arcademy.modules.quiz.models.Quiz;
import arcademy.modules.quiz.repositories.QuestionRepository;
import arcademy.modules.quiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizService quizService;

    public Question getQuestion(long quizId, String secret, int pointer) throws Exception {
        Quiz quiz = quizService.getQuiz(quizId, secret);
        if ((pointer + 1) >= quiz.getQuestions().size()) {
            throw new Exception("There is no question with that id");
        }
        if (pointer < 0) {
            throw new Exception("There is no question with that id");
        }
        return quiz.getQuestions().get(pointer);
    }

    public Question updateQuestion(long quizId, String secret, int pointer, Question question) throws Exception {
        Quiz quiz = quizService.getQuiz(quizId, secret);

        if ((pointer + 1) > quiz.getQuestions().size()) {
            throw new Exception("There is no question with that id");
        }
        if (pointer < 0) {
            throw new Exception("There is no question with that id");
        }

        Question question1 = quiz.getQuestions().get(pointer);

        question.setId(question1.getId());

        return questionRepository.save(question);
    }

    public void deleteQuestion(long quizId, String secret, int pointer) throws Exception {
        Quiz quiz = quizService.getQuiz(quizId, secret);

        if ((pointer + 1) > quiz.getQuestions().size()) {
            throw new Exception("There is no question with that id");
        }
        if (pointer < 0) {
            throw new Exception("There is no question with that id");
        }

        quiz.getQuestions().remove(pointer);
        quizRepository.save(quiz);
    }

    public Question addQuestion(long quizId, String secret, Question question) throws Exception {
        Quiz quiz = quizService.getQuiz(quizId, secret);

        quiz.getQuestions().add(question);

        Quiz quiz1 = quizRepository.save(quiz);
        return quiz1.getQuestions().get(quiz1.getQuestions().size() - 1);
    }
}
