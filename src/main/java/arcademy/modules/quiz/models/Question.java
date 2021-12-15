package arcademy.modules.quiz.models;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String question;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Option> options;

    private String explanation;

    private int timeToAnswer = 180;
}
