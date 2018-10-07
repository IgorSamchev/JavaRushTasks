package com.javarush.task.task30.task3008;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class ServerGUI extends Server {
    private static Font font = new Font("Arial", Font.BOLD, 20);
    private static JTextField jTextField;

    public static void main(String[] args) throws IOException {
        JFrame frame = initView();
        JPanel panel = new JPanel();
        frame.add(panel);
        JLabel jLabel = new JLabel("Insert port number: ");
        panel.add(jLabel);
        panel.add(createSelectPortField());
        panel.add(createStartButton(new JButton()));
        frame.pack();
    }

    static void setPortGui() {
        Server.port = (jTextField.getText());
        System.out.println(Server.port);
    }

    private static JTextField createSelectPortField() {

        jTextField = new JTextField("8787", 10);
        jTextField.setHorizontalAlignment(SwingConstants.LEFT);
        jTextField.setFont(font);

        return jTextField;

    }

    private static JButton createStartButton(JButton button) {
        button.setFont(font);
        button.addActionListener(e -> Server.serverStart());
        button.setText("Start Server");
        Dimension dimension = new Dimension(350, 100);
        button.setPreferredSize(dimension);

        return button;
    }

    private static JFrame initView() {
        JFrame frame = new JFrame("Server");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 400);
        return frame;
    }
}
