package arcademy.modules.quiz.models;

import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Quiz
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String secret;

	@Column(unique=true)
	private String quizCode;

	@OneToMany(cascade = {CascadeType.ALL})
	private List<Question> questions = new ArrayList<>();

}