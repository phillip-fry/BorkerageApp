package com.brokerageapp.cs174;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class TraderInterface extends JPanel{

    JPanel menuPanel;
    JScrollPane contentContainer;

    // Content Panels
    MarketManagerPanel marketAcctPanel;
    JPanel stockAcctPanel;
    JPanel investPanel;

    // Navigation buttons
    MenuButton popUpButton;
    JPopupMenu accntPopUp;
    JMenuItem navMAM;
    JMenuItem navSAM;
    MenuButton navInvest;
    MenuButton settings;



    public TraderInterface(Connection mainDB, Connection otherMoviesDB){
        // Set the main layout
        BorderLayout mainpanel = new BorderLayout();
        this.setLayout(mainpanel);

        // add navigation menu
        initializeMenu();
        this.add(menuPanel,BorderLayout.NORTH);

        // add market account menu as default
        initializeMarketPanel();
        this.add(marketAcctPanel, BorderLayout.CENTER);

        this.setVisible(true);

        // initialize other manager panels for future use
        initializeStockPanel();
        initializeInvestingPanel();

    }

    /**
     * Initializes the custom menu bar at the top of the application
     */
    public void initializeMenu(){
        //Background Color
        Color menubackground = Color.decode("#ccccb3");

        // Layouts
        BorderLayout menuLayout = new BorderLayout();
        FlowLayout navflow = new FlowLayout(FlowLayout.LEADING, 20, 10);
        FlowLayout settingflow = new FlowLayout(FlowLayout.TRAILING);

        // Internal Panels
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();

        // Assign Layouts to panels
        menuPanel = new JPanel(menuLayout);
        westPanel.setLayout(navflow);
        eastPanel.setLayout(settingflow);

        popUpButton = new MenuButton("Manage Accounts");
        accntPopUp = new JPopupMenu("Manage Accounts");
        navMAM = new JMenuItem("Market Account Manager");
        navSAM = new JMenuItem("Stock Account Manager");
        navInvest = new MenuButton("Invest");
        settings = new MenuButton("Settings");

        // Action Listener for the menu items
        ActionListener navListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Call navListener
                System.out.println("Navigation Item [" + actionEvent.getActionCommand() + "] was selected");
                changeDisplay(actionEvent.getActionCommand());
            }
        };

        // Add Action Listener to JMenuItems and Invest Button
        navMAM.addActionListener(navListener);
        navSAM.addActionListener(navListener);
        navInvest.addActionListener(navListener);

        // Add JMenuItems to JPopupMenu
        accntPopUp.add(navMAM);
        accntPopUp.add(navSAM);


        // Action Listener for the button
        ActionListener popupMenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Call showPopup method
                showPopup(actionEvent);
            }
        };

        // Add Action Listener to JButton
        popUpButton.addActionListener(popupMenuListener);


        // Add Navigation Buttons to Menu
        westPanel.add(popUpButton);
        westPanel.add(navInvest);
        eastPanel.add(settings);
        menuPanel.add(westPanel, BorderLayout.WEST);
        menuPanel.add(eastPanel, BorderLayout.EAST);

        // Set Background to appropriate panels
        westPanel.setBackground(menubackground);
        eastPanel.setBackground(menubackground);
        menuPanel.setBackground(menubackground);

        menuPanel.setVisible(true);
    }

    private void showPopup(ActionEvent actionEvent){
        // Get event source
        Component comp = (Component)actionEvent.getSource();

        // Get location of the point
        Point p = comp.getLocationOnScreen();

        // Show the JPopupMenu
        accntPopUp.show(this,0,0);

        // Now set location of JPopupMenu relative to screen
        accntPopUp.setLocation(p.x, p.y + comp.getHeight());
    }

    private void changeDisplay(String actionCommand){
        switch (actionCommand){
            case "Market Account Manager" :
                System.out.println("Changing to Market Account Display");
                //TODO: initialize market account display
                break;
            case "Stock Account Manager" :
                System.out.println("Changing to Stock Account Display");
                //TODO: initialize  stock account display
                break;
            case "Invest" :
                System.out.println("Changing to Investment Display");
                //TODO: initialize investment display
                break;
            default :
                System.out.println("Unknown display");

        }
    }

    /**
     * Initializes the display of the Market Account Manager functionality
     */
    public void initializeMarketPanel(){
        marketAcctPanel = new MarketManagerPanel();
    }

    /**
     * Initializes the display of the Stock Account Manager functionality
     */
    public void initializeStockPanel(){

    }

    /**
     * Initializes the display of the Investment functionality allowing the user to search for
     * new stocks to invest in
     */
    public void initializeInvestingPanel(){

    }


    public class MenuButton extends JButton{
        public MenuButton(String name){
            this.setContentAreaFilled(false);
            this.setName(name);
            this.setText(name);
            Border emptyBorder = BorderFactory.createEmptyBorder();
            this.setBorder(emptyBorder);
            this.setFocusPainted(false);
            this.setFocusable(false);
        }
    }
}
