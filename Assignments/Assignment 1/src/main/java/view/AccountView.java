package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AccountView extends JFrame {
    private JPanel panel;
    private JTextField tfClientId;
    private JTextField tfCardNo;
    private JTextField tfType;
    private JTextField tfAmount;
    private JTextField tfAcc1;
    private JTextField tfAcc2;
    private JTextField tfSum;
    private JTextField tfAcc;
    private JTextField tfBill;

    private JLabel lbFrom;
    private JLabel lbTo;
    private JLabel lbAmount;
    private JLabel lbBill;

    private JButton btnCreate;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnView;
    private JButton btnTransfer;
    private JButton btnBill;

    public AccountView() throws HeadlessException {
        setSize(300, 500);
        setTitle("ACCOUNT");
        setLocation(1100,300);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new BoxLayout(getContentPane(), Y_AXIS));

        initializeFields();
        panel.add(tfClientId);
        panel.add(tfCardNo);
        panel.add(tfType);
        panel.add(tfAmount);
        panel.add(btnCreate);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnView);
        panel.add(lbFrom);
        panel.add(tfAcc1);
        panel.add(lbTo);
        panel.add(tfAcc2);
        panel.add(lbAmount);
        panel.add(tfSum);
        panel.add(btnTransfer);
        panel.add(lbBill);
        panel.add(tfAcc);
        panel.add(tfBill);
        panel.add(btnBill);

        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeFields() {
        tfClientId = new JTextField("client id");
        tfCardNo = new JTextField("card number");
        tfType = new JTextField("acount_type");
        tfAmount = new JTextField("amount");
        tfAcc1 = new JTextField("id");
        tfAcc2 = new JTextField("id");
        tfSum = new JTextField("amount");
        tfBill = new JTextField("amount");
        tfAcc = new JTextField("account id");
        lbFrom = new JLabel("Transfer from:");
        lbTo = new JLabel("To:");
        lbAmount = new JLabel("Amount:");
        lbBill = new JLabel("Process bill:");
        btnCreate = new JButton("Create Account");
        btnUpdate = new JButton("Update Account");
        btnDelete = new JButton("Delete Account");
        btnView = new JButton("View Account");
        btnTransfer = new JButton("Transfer");
        btnBill = new JButton("Pay Bill");
    }

    public String getClientId() { return tfClientId.getText(); }
    public String getCardNumber() { return tfCardNo.getText(); }
    public String getAType() {
        return tfType.getText();
    }
    public String getAmount() { return tfAmount.getText(); }
    public String getAcc1() { return tfAcc1.getText(); }
    public String getAcc2() { return tfAcc2.getText(); }
    public String getSum() { return tfSum.getText(); }
    public String getAcc() { return tfAcc.getText(); }
    public String getBill() { return tfBill.getText(); }

    public void setCreateButtonListener(ActionListener createButtonListener) {
        btnCreate.addActionListener(createButtonListener);
    }

    public void setUpdateButtonListener(ActionListener updateButtonListener) {
        btnUpdate.addActionListener(updateButtonListener);
    }

    public void setDeleteButtonListener(ActionListener deleteButtonListener) {
        btnDelete.addActionListener(deleteButtonListener);
    }

    public void setViewButtonListener(ActionListener viewButtonListener) {
        btnView.addActionListener(viewButtonListener);
    }

    public void setTransferButtonListener(ActionListener transferButtonListener) {
        btnTransfer.addActionListener(transferButtonListener);
    }

    public void setProcessBillButtonListener(ActionListener processBillButtonListener) {
        btnBill.addActionListener(processBillButtonListener);
    }
}
