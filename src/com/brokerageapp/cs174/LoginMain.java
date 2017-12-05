package com.brokerageapp.cs174;

import javax.swing.*;
import java.awt.*;

public class LoginMain {


    private JPanel loginpanel;
    private JPanel centercontent;
    private JLabel applogo;
    private JTextField usernamefield;
    private JPasswordField passwordField;
    private JButton button1;
    private JCheckBox starsRusManagerCheckBox;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        loginpanel = new JPanel();

    }


    public static void main(String[] args){
        JFrame mainframe = new JFrame("Brokerage Application");
        mainframe.setContentPane(new LoginMain().loginpanel);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.pack();
        mainframe.setLocationRelativeTo(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth() / 3;
        int height = (int) screenSize.getHeight() /3;

        mainframe.setMinimumSize(new Dimension(width, height));


        mainframe.setVisible(true);
    }

}
