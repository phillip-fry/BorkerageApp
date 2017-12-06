package com.brokerageapp.cs174;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MarketManagerPanel extends JPanel {

    JLabel balance;

    JTextArea transactionInfo;
    JLabel dollarSign;
    JTextField amount;
    JCheckBox deposit;
    JCheckBox withdraw;
    JButton makeTransaction;


    public MarketManagerPanel(){
        initializePanel();
    }

    private void initializePanel(){
        balance = new JLabel("Balance: $1000");
        Font balancefont = new Font("Courier New", Font.BOLD, 25);
        balance.setFont(balancefont);
        balance.setForeground(Color.GREEN);

        BorderLayout marketLayout = new BorderLayout();
        this.setLayout(marketLayout);

        this.add(balance, BorderLayout.NORTH);


        transactionInfo = new JTextArea("Make a Transaction: \n " +
                "Check the box for the type of transaction you would like to make");
        transactionInfo.setLineWrap(true);
        transactionInfo.setEditable(false);
        transactionInfo.setOpaque(false);
        dollarSign = new JLabel("Amount: $");
        amount = new JTextField();
        amount.setColumns(30);
        deposit = new JCheckBox("Deposit");
        withdraw = new JCheckBox("Withdraw");
        makeTransaction = new JButton("Confirm");

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        formPanel.add(transactionInfo, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;

        formPanel.add(deposit, gbc);

        gbc.gridx = 1;

        formPanel.add(withdraw, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        formPanel.add(dollarSign,gbc);

        gbc.gridx = 1;

        formPanel.add(amount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        formPanel.add(makeTransaction, gbc);

        this.add(formPanel, BorderLayout.CENTER);

        this.validate();
        this.setVisible(true);

    }

    private void updatePanel(){

    }
}
