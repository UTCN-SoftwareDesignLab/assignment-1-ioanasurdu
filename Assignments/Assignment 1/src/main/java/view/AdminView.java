package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class AdminView extends JFrame {
    private JPanel panel;
    private JTextField tfId;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JButton btnCreate;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnView;
    private JButton btnGenerate;

    public AdminView() throws HeadlessException {
        setSize(500, 500);
        setTitle("ADMINISTRATOR");
        setLocationRelativeTo(null);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        initializeFields();
        panel.add(tfId);
        panel.add(tfUsername);
        panel.add(tfPassword);
        panel.add(btnCreate);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnView);
        panel.add(btnView);
        panel.add(btnGenerate);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeFields() {
        tfId = new JTextField("id");
        tfUsername = new JTextField("username");
        tfPassword = new JTextField("password");
        btnCreate = new JButton("Create Employee");
        btnUpdate = new JButton("Update Employee");
        btnDelete = new JButton("Delete Employee");
        btnView = new JButton("View Employees");
        btnGenerate = new JButton("Generate Report");
    }

    public String getId() { return tfId.getText(); }
    public String getUsername() { return tfUsername.getText(); }
    public String getPassword() { return tfPassword.getText(); }

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

    public void setGenerateButtonListener(ActionListener generateButtonListener) {
        btnGenerate.addActionListener(generateButtonListener);
    }


}
