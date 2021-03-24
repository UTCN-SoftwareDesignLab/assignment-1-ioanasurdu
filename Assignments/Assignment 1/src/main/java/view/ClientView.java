package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class ClientView extends JFrame {
    private JPanel panel;
    private JTextField tfId;
    private JTextField tfName;
    private JTextField tfICN;
    private JTextField tfPCN;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnView;

    public ClientView() throws HeadlessException {
        setSize(300, 300);
        setTitle("CLIENT");
        setLocation(500,300);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        initializeFields();
        panel.add(tfId);
        panel.add(tfName);
        panel.add(tfICN);
        panel.add(tfPCN);
        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnView);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeFields() {
        tfId = new JTextField("id");
        tfName = new JTextField("name");
        tfICN = new JTextField("id card number");
        tfPCN = new JTextField("personal card number");
        btnAdd = new JButton("Add Client");
        btnUpdate = new JButton("Update Client");
        btnView = new JButton("View Client");
    }

    public String getId() { return  tfId.getText(); }
    public String getName() {
        return tfName.getText();
    }
    public String getICN() { return tfICN.getText(); }
    public String getPCN() { return tfPCN.getText(); }

    public void setAddButtonListener(ActionListener addButtonListener) {
        btnAdd.addActionListener(addButtonListener);
    }

    public void setUpdateButtonListener(ActionListener updateButtonListener) {
        btnUpdate.addActionListener(updateButtonListener);
    }

    public void setViewButtonListener(ActionListener viewButtonListener) {
        btnView.addActionListener(viewButtonListener);
    }

}
