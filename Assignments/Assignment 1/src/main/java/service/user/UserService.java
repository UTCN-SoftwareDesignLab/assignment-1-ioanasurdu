package service.user;

import model.User;
import model.validation.Notification;

import java.util.List;

public interface UserService {
    public Notification<Boolean> createUser(String username, String password);
    public Notification<Boolean> updateUser(Long id, String username, String password);
    public Notification<Boolean> deleteUser(String username, String password);
    public List<User> viewUsers();
}
