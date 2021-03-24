package controller;

import model.User;
import service.user.UserService;
import view.UsersView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UsersController {
    private final UsersView usersView;
    private final UserService userService;

    public UsersController(UsersView usersView, UserService userService) {
        this.usersView = usersView;
        this.userService = userService;
        usersView.setLoadButtonListener(new LoadButtonListener());
    }

    private class LoadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<User> viewNotification = userService.viewUsers();

            if (viewNotification == null) {
                JOptionPane.showMessageDialog(usersView.getContentPane(), "Employees loading failed!");
            }
        }
    }

    public void setVisible() {
        usersView.setVisible(true);
    }

}
