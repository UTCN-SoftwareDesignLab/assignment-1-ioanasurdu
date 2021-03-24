package repository.user;

import model.User;
import model.validation.Notification;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    Notification<User> findByUsernameAndPassword(String username, String password);

    void removeAll();

    boolean save(User user);

    boolean createUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(User user);

}
