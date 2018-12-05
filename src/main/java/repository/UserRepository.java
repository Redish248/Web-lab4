package repository;

import entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByNickAndPassword(String nick, String password);

}
