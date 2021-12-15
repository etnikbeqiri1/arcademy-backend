package arcademy.modules.game.models;

import arcademy.modules.authentication.models.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private User user;

    @OneToOne
    private Team teamA;

    @OneToOne
    private Team teamB;

    private GameStatus status;

    @OneToMany
    private List<Round> rounds;
}
