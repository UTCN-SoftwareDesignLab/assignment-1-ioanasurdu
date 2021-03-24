package controller;

import model.validation.Notification;
import service.user.UserService;
import view.AdminView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {
    private final AdminView adminView;
    private final UserService userService;
    private final UsersController usersController;

    public AdminController(AdminView adminView, UserService userService, UsersController usersController) {
        this.adminView = adminView;
        this.userService = userService;
        this.usersController = usersController;
        adminView.setCreateButtonListener(new CreateButtonListener());
        adminView.setUpdateButtonListener(new UpdateButtonListener());
        adminView.setDeleteButtonListener(new DeleteButtonListener());
        adminView.setViewButtonListener(new ViewButtonListener());
        adminView.setGenerateButtonListener(new GenerateButtonListener());

    }

    private class CreateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = adminView.getUsername();
            String password = adminView.getPassword();

            Notification<Boolean> registerNotification = userService.createUser(username, password);

            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(adminView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                JOptionPane.showMessageDialog(adminView.getContentPane(), "Created new employee successfully!");
            }
        }
    }

    private class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String id = adminView.getId();
            String username = adminView.getUsername();
            String password = adminView.getPassword();

            Notification<Boolean> registerNotification = userService.updateUser(Long.parseLong(id), username, password);

            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(adminView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                JOptionPane.showMessageDialog(adminView.getContentPane(), "Updated employee successfully!");
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = adminView.getUsername();
            String password = adminView.getPassword();

            Notification<Boolean> registerNotification = userService.deleteUser(username, password);

            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(adminView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                JOptionPane.showMessageDialog(adminView.getContentPane(), "Deleted employee successfully!");
            }
        }
    }

    private class ViewButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            usersController.setVisible();
        }
    }

    private class GenerateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    public void setVisible() {
        adminView.setVisible(true);
    }
}
