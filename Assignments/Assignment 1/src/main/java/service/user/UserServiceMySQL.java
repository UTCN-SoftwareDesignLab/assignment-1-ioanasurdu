package service.user;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.Role;
import model.User;
import model.builder.UserBuilder;
import model.validation.Notification;
import model.validation.UserValidator;
import repository.security.RightsRolesRepository;
import repository.user.UserRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

public class UserServiceMySQL implements UserService {
    private final UserRepository userRepository;
    private final RightsRolesRepository rightsRolesRepository;


    public UserServiceMySQL(UserRepository userRepository, RightsRolesRepository rightsRolesRepository) {
        this.userRepository = userRepository;
        this.rightsRolesRepository = rightsRolesRepository;
    }

    @Override
    public Notification<Boolean> createUser(String username, String password) {
        User user = new UserBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();

        UserValidator userValidator = new UserValidator(user);
        boolean userValid = userValidator.validate();
        Notification<Boolean> userRegisterNotification = new Notification<>();

        if (!userValid) {
            userValidator.getErrors().forEach(userRegisterNotification::addError);
            userRegisterNotification.setResult(Boolean.FALSE);
        } else {
            user.setPassword(encodePassword(password));
            userRegisterNotification.setResult(userRepository.createUser(user));
        }
        return userRegisterNotification;
    }

    @Override
    public Notification<Boolean> updateUser(Long id, String username, String password) {
        User user = new UserBuilder()
                .setId(id)
                .setUsername(username)
                .setPassword(password)
                .build();

        UserValidator userValidator = new UserValidator(user);
        boolean userValid = userValidator.validate();
        Notification<Boolean> userUpdateNotification = new Notification<>();

        if (!userValid) {
            userValidator.getErrors().forEach(userUpdateNotification::addError);
            userUpdateNotification.setResult(Boolean.FALSE);
        } else {
            user.setPassword(encodePassword(password));
            userUpdateNotification.setResult(userRepository.updateUser(user));
        }
        return userUpdateNotification;
    }

    @Override
    public Notification<Boolean> deleteUser(String username, String password) {
        User user = new UserBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();

        UserValidator userValidator = new UserValidator(user);
        boolean userValid = userValidator.validate();
        Notification<Boolean> userDeleteNotification = new Notification<>();

        if (!userValid) {
            userValidator.getErrors().forEach(userDeleteNotification::addError);
            userDeleteNotification.setResult(Boolean.FALSE);
        } else {
            user.setPassword(encodePassword(password));
            userDeleteNotification.setResult(userRepository.deleteUser(user));
        }
        return userDeleteNotification;
    }

    @Override
    public List<User> viewUsers() {
        return userRepository.findAll();
    }

    private String encodePassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
