package com.brokerageapp.cs174;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static com.brokerageapp.cs174.LoginMain.mainframe;

public class RegisterPanel extends JPanel {

    JLabel title = new JLabel("Registration Info");
    JLabel nameLabel = new JLabel("Name: ");
    JLabel stateLabel = new JLabel("State: ");
    JLabel phoneLabel = new JLabel("Phone Number: ");
    JLabel emaillabel = new JLabel("Email: ");
    JLabel taxIDLabel = new JLabel("Tax ID: ");
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JLabel confirmpasswordLabel = new JLabel("Confirm Password: ");

    JTextArea name = new JTextArea();
    JComboBox statesBox;
    JTextArea phonenum = new JTextArea();
    JTextArea email = new JTextArea();
    JTextArea taxID = new JTextArea();
    JTextArea username = new JTextArea();
    JPasswordField password = new JPasswordField();
    JPasswordField confirmpassword = new JPasswordField();
    JButton register = new JButton("Register");

    JPanel contentForm = new JPanel();
    JButton backNavigation = new JButton("Go back to Login");

    Connection myDatabase;


    public RegisterPanel(Connection conn){
        // set columns according to what database can handle
        myDatabase = conn;
        name.setColumns(30);
        phonenum.setColumns(10);
        email.setColumns(30);
        taxID.setColumns(20);
        username.setColumns(20);
        password.setColumns(20);
        confirmpassword.setColumns(20);

        // Add the list to the state spinner with spinner model
        String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

        statesBox = new JComboBox(states);

        // Add the components to the form
        this.setLayout(new BorderLayout());
        addButtons();

        // Layout for Back button
        FlowLayout northLayout = new FlowLayout(FlowLayout.TRAILING);
        JPanel northPanel = new JPanel(northLayout);
        northPanel.add(backNavigation);

        // Action Listener for the button
        ActionListener registerUser = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Call showPopup method
                try {
                    registerCustomer();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(mainframe,
                                                    "The username [" + username.getText() + "] already exists",
                                                    "Username Taken Error",
                                                    JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        // Add listener for Login Button
        register.addActionListener(registerUser);


        // Add panels to actual Register Panel
        this.add(northPanel, BorderLayout.NORTH);
        this.add(contentForm, BorderLayout.CENTER);



    }

    public void registerCustomer() throws SQLException{
        String usernameReg = username.getText();
        String passwordReg = String.valueOf(password.getPassword());
        String paswordConfirmed = String.valueOf(confirmpassword.getPassword());
        String nameReg = name.getText();
        String stateReg = statesBox.getSelectedItem().toString();
        String phoneReg = phonenum.getText();
        String emailReg = email.getText();
        int taxIDReg = Integer.parseInt(taxID.getText());

        if(passwordReg.equals(paswordConfirmed)) {
            // username, password, name, state, phone_num, email, tax_id
            String sqlInsert = "INSERT INTO Customer(username, password, name, state, phone_num, email, tax_id)"
                    + "values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = myDatabase.prepareStatement(sqlInsert);
            preparedStatement.setString(1, usernameReg);
            preparedStatement.setString(2, passwordReg);
            preparedStatement.setString(3, nameReg);
            preparedStatement.setString(4, stateReg);
            preparedStatement.setString(5, phoneReg);
            preparedStatement.setString(6, emailReg);
            preparedStatement.setInt(7, taxIDReg);

            preparedStatement.execute();
            System.out.println("Inserted into table");
        }
        else {
            System.out.println("Passwords do not match" + " -Pasword = " + passwordReg + " -confirm = " + paswordConfirmed);
        }
    }

    public void addButtons(){
        contentForm.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3,3,3,3);

        gbc.gridx = 0;
        gbc.gridy = 0;                  // Row 0
        gbc.gridwidth = 2;
        contentForm.add(title, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;
        gbc.gridy = 1;                  // Row 1
        contentForm.add(nameLabel, gbc);

        gbc.gridx = 1;
        contentForm.add(name, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        contentForm.add(stateLabel, gbc);      // Row 2

        gbc.gridx = 1;
        contentForm.add(statesBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;                  // Row 3
        contentForm.add(phoneLabel, gbc);

        gbc.gridx = 1;
        contentForm.add(phonenum, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;                  // Row 4
        contentForm.add(emaillabel, gbc);

        gbc.gridx = 1;
        contentForm.add(email, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;                  // Row 5
        contentForm.add(taxIDLabel, gbc);

        gbc.gridx = 1;
        contentForm.add(taxID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;                  // Row 6
        contentForm.add(usernameLabel, gbc);

        gbc.gridx = 1;
        contentForm.add(username, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;                  // Row 7
        contentForm.add(passwordLabel, gbc);

        gbc.gridx = 1;
        contentForm.add(password, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;                  // Row 8
        contentForm.add(confirmpasswordLabel, gbc);

        gbc.gridx = 1;
        contentForm.add(confirmpassword, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 9;                  // Row 9
        gbc.gridwidth = 2;
        contentForm.add(register, gbc);
    }
}
