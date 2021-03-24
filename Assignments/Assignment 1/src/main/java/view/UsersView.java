package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class UsersView extends JFrame {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnLoad;
    JScrollPane scroll;
    String[] columns = {"ID", "USERNAME", "PASSWORD"};

    public UsersView() throws HeadlessException {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("EMPLOYEES");
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        initializeFields();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(btnLoad);
        panel.add(table);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeFields() {
        model = new DefaultTableModel();
        table = new JTable();
        scroll = new JScrollPane(table);
        btnLoad = new JButton("Load Employees");
    }

    public void setLoadButtonListener(ActionListener loadButtonListener) {
        btnLoad.addActionListener(loadButtonListener);
    }

}
