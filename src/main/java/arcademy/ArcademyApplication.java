package arcademy;

import arcademy.modules.quiz.models.Question;
import arcademy.modules.quiz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import arcademy.modules.quiz.repositories.QuizRepository;

@SpringBootApplication
public class ArcademyApplication implements CommandLineRunner
{

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private QuestionRepository questionRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(ArcademyApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception
	{

	}
}
