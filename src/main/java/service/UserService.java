package service;

import entity.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

public interface UserService {

    User getUserByUsernameAndPassword(String username, String password);
    void saveUser(User user);
    User getUserByUsername(String username);
}
