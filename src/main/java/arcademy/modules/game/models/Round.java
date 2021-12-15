package arcademy.modules.game.models;

import arcademy.modules.authentication.models.User;
import arcademy.modules.quiz.models.Question;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private User answerer;

    @OneToOne
    private Question question;

    private Time startTime;

    private Time endTime;

    private int points;
}
