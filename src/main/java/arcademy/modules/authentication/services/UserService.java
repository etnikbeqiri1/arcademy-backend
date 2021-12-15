package arcademy.modules.authentication.services;

import arcademy.modules.authentication.models.User;
import arcademy.modules.authentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser() {
        User user = new User();
        user.setToken(UUID.randomUUID().toString());
        user.setUsername("Unknown Player");
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    public User changeName(String token, String username) throws Exception {
        User user = userRepository.findByToken(token).orElseThrow(() -> new Exception("No user found"));
        user.setUsername(username);
        userRepository.save(user);
        return user;
    }
}
