package com.javarush.task.task18.MouseRunner;


import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class MouseRunner {


    public static void main(String[] args) {

        JFrame frame = new JFrame("MouseRunner");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);



        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };

        JTable jtable = new JTable(data,columnNames);

        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = jtable.getColumnModel().getColumn(i);
            if (i == 2) {
                column.setPreferredWidth(100); //third column is bigger
            } else {
                column.setPreferredWidth(50);
            }
        }

        Display display = new Display(3,2);
        display.run();
    }
}
