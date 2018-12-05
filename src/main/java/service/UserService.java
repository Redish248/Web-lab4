package service;

import entity.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

public interface UserService {

    User getUserByNickAndPassword(String nick, String password);

}
