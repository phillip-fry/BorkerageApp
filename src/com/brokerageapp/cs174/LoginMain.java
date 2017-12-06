package com.brokerageapp.cs174;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginMain {


    private JPanel loginpanel;
    private JPanel centercontent;
    private JLabel applogo;
    private JTextField usernamefield;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JCheckBox starsRusManagerCheckBox;
    private JTextField createAccnt;

    public static JFrame mainframe;
    public static Connection connection = null;
    public static TraderInterface traderInterface;
    public static RegisterPanel registerPanel;

    public LoginMain() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Clicked");
                mainframe.remove(loginpanel);
                traderInterface = new TraderInterface(connection, connection);
                mainframe.setContentPane(traderInterface);
                traderInterface.setVisible(true);
                mainframe.validate();
                mainframe.repaint();
            }
        });

        createAccnt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                mainframe.remove(loginpanel);
                registerPanel = new RegisterPanel(connection);
                mainframe.setContentPane(registerPanel);
                registerPanel.setVisible(true);
                mainframe.validate();
                mainframe.repaint();

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        loginpanel = new JPanel();


    }


    public static void main(String[] args){
        mainframe = new JFrame("Brokerage Application");
        mainframe.setContentPane(new LoginMain().loginpanel);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.pack();
        mainframe.setLocationRelativeTo(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth() / 3;
        int height = (int) screenSize.getHeight() /3;

        mainframe.setMinimumSize(new Dimension(width, height));


        mainframe.setVisible(true);

        connection = null;

        try{
            connection = ConnectionConfiguration.getConnection();
            if(connection != null){
                System.out.println("connection established");
                createCustomerTable();
            } else {
                System.out.println("connection is still null");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }

    }


    public static void createCustomerTable() throws SQLException{
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "Customer"
                + "  (username        VARCHAR(20),"
                + "   password        VARCHAR(20),"
                + "   name            VARCHAR(30),"
                + "   state           VARCHAR(2),"
                + "   phone_num       VARCHAR(10),"
                + "   email           VARCHAR(30),"
                + "   tax_id          INTEGER,"
                + "   PRIMARY KEY (username) )";

        Statement stmt = connection.createStatement();
        stmt.execute(sqlCreate);
    }

    public static void createMarketAccountsTable() throws SQLException{
        String sqlCreate = "CREATE TABLE IF NOT EXISTS "+ "Market_Accounts "
                + "(maid    INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + " uname   "
    }

    public static void createOwnsTable() throws SQLException{
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + "Owns"
                + " (   uname       VARCHAR(20),"
                + "     maid        ";
    }

}
