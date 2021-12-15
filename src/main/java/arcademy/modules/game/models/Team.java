package arcademy.modules.game.models;

import arcademy.modules.authentication.models.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<User> users;
}
