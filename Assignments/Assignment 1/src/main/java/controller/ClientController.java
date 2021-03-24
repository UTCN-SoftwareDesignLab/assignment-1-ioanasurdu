package controller;

import model.validation.Notification;
import service.client.ClientService;
import view.ClientView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientController {
    private final ClientView clientView;
    private final ClientService clientService;

    public ClientController(ClientView clientView, ClientService clientService) {
        this.clientView = clientView;
        this.clientService = clientService;

        clientView.setAddButtonListener(new ClientController.AddButtonListener());
        clientView.setUpdateButtonListener(new ClientController.UpdateButtonListener());
        clientView.setViewButtonListener(new ClientController.ViewButtonListener());

    }

    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = clientView.getName();
            String icn = clientView.getICN();
            String pcn = clientView.getPCN();

            Notification<Boolean> registerNotification = clientService.addClient(name, icn, pcn);

            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(clientView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                JOptionPane.showMessageDialog(clientView.getContentPane(), "Added new client successfully!");
            }
        }
    }

    private class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String id = clientView.getId();
            String name = clientView.getName();
            String icn = clientView.getICN();
            String pcn = clientView.getPCN();

            Notification<Boolean> registerNotification = clientService.updateClient(Long.parseLong(id), name, icn, pcn);

            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(clientView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                JOptionPane.showMessageDialog(clientView.getContentPane(), "Updated client successfully!");
            }
        }
    }

    private class ViewButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    public void setVisible() {
        clientView.setVisible(true);
    }
}
