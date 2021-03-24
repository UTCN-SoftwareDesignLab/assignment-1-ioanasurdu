package controller;

import model.validation.Notification;
import service.account.AccountService;
import view.AccountView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AccountController {
    private final AccountView accountView;
    private final AccountService accountService;

    public AccountController(AccountView accountView, AccountService accountService) {
        this.accountView = accountView;
        this.accountService = accountService;

        accountView.setCreateButtonListener(new AccountController.CreateButtonListener());
        accountView.setUpdateButtonListener(new AccountController.UpdateButtonListener());
        accountView.setDeleteButtonListener(new AccountController.DeleteButtonListener());
        accountView.setViewButtonListener(new AccountController.ViewButtonListener());
        accountView.setTransferButtonListener(new AccountController.TransferButtonListener());
        accountView.setProcessBillButtonListener(new AccountController.ProcessBillButtonListener());
    }

    private class CreateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String clientId = accountView.getClientId();
            String cardNumber = accountView.getCardNumber();
            String type = accountView.getAType();
            String amount = accountView.getAmount();

            Notification<Boolean> registerNotification = accountService.createAccount(Long.parseLong(clientId), cardNumber, type, Float.parseFloat(amount));

            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(accountView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                JOptionPane.showMessageDialog(accountView.getContentPane(), "Created new account successfully!");
            }
        }
    }

    private class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String clientId = accountView.getClientId();
            String cardNumber = accountView.getCardNumber();
            String type = accountView.getAType();
            String amount = accountView.getAmount();

            Notification<Boolean> registerNotification = accountService.updateAccount(Long.parseLong(clientId), cardNumber, type, Float.parseFloat(amount));

            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(accountView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                JOptionPane.showMessageDialog(accountView.getContentPane(), "Updated account successfully!");
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String clientId = accountView.getClientId();
            String cardNumber = accountView.getCardNumber();
            String type = accountView.getAType();
            String amount = accountView.getAmount();

            Notification<Boolean> registerNotification = accountService.deleteAccount(cardNumber, type, Float.parseFloat(amount));

            if (registerNotification.hasErrors()) {
                JOptionPane.showMessageDialog(accountView.getContentPane(), registerNotification.getFormattedErrors());
            } else {
                JOptionPane.showMessageDialog(accountView.getContentPane(), "Deleted account successfully!");
            }
        }
    }

    private class ViewButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class TransferButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String acc1 = accountView.getAcc1();
            String acc2 = accountView.getAcc2();
            String sum = accountView.getSum();

            int notification = accountService.transfer(Long.parseLong(acc1), Long.parseLong(acc2), Float.parseFloat(sum));

            if (notification == 0) {
                JOptionPane.showMessageDialog(accountView.getContentPane(), "Transaction denied.");
            } else {
                JOptionPane.showMessageDialog(accountView.getContentPane(), "Transferred money successfully!");
            }
        }
    }

    private class ProcessBillButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String acc1 = accountView.getAcc();
            String bill = accountView.getBill();

            int notification = accountService.processBill(Long.parseLong(acc1), Float.parseFloat(bill));

            if (notification == 0) {
                JOptionPane.showMessageDialog(accountView.getContentPane(), "Payment denied.");
            } else {
                JOptionPane.showMessageDialog(accountView.getContentPane(), "Payment accepted!");
            }
        }
    }

    public void setVisible() {
        accountView.setVisible(true);
    }
}
