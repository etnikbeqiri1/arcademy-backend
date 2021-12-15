package arcademy.modules.quiz.repositories;

import arcademy.modules.quiz.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import arcademy.modules.quiz.models.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long>
{
	public List<Quiz> findByQuizCode(String quizCode);

	public Optional<Quiz> findByIdAndSecret(long id, String secret);
}
