package root;

import javax.swing.*;
import java.awt.*;

public class UI {

    public Game game;
    public Player player;
    public JFrame mainWindow;
    public Container con;
    public JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel,
            interfacePanel, hudPanel, statisticsHeaderPanel, statsPanel,
            statsReturnBtnPanel;
    public JLabel titleLabel, hpLabel, hpAmountLabel, weaponLabel, equippedWeaponLabel,
            armorLabel, equippedArmorLabel, statsLabel;
    public JButton startButton, choice_1, choice_2, choice_3, choice_4, statisticsButton,
            inventoryButton, journalButton, settingsButton, statisticsReturnButton;
    public JTextArea mainTextArea;
    public JTable statisticsTable;

    // creates new font for title with size - 90
    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public Font headerFont = new Font("Times New Roman", Font.PLAIN, 60);

    private final int screenSizeX = 1000;
    private final int screenSizeY = 650;


    public UI(Game g, Player p){ //constructor
        game = g;
        player = p;
        mainWindow();
        titleScreen();
    }

    protected void mainWindow(){
        mainWindow = new JFrame(); //creating new instance of JFrame
        mainWindow.setSize(screenSizeX, screenSizeY);
        mainWindow.getContentPane().setBackground(Color.BLACK);
        mainWindow.setVisible(true);
        mainWindow.setLayout(null); //disables default layout because I want to customize game layout
        con = mainWindow.getContentPane();
    }

    protected void titleScreen(){
        int titlePanelWidth = 600;
        int titlePanelHeight = 150;
        int titlePanelStartX = (screenSizeX - titlePanelWidth) / 2;
        int titlePanelStartY = ((screenSizeY - titlePanelHeight) / 2 - 70);


        titlePanel = makePanel(titlePanel, titlePanelStartX, titlePanelStartY,
                titlePanelWidth, titlePanelHeight);

        // creates label with title name
        titleLabel = makeLabel(titleLabel, "ADVENTURE", titleFont, titlePanel);

        // creates panel for start button
        int startButtonPanelWidth = 200;
        int startButtonPanelHeight = 100;
        int startButtonPanelStartX = (screenSizeX - startButtonPanelWidth) / 2;
        int startButtonPanelStartY = (screenSizeY - startButtonPanelHeight) / 2 + 70;

        startButtonPanel = makePanel(startButtonPanel, startButtonPanelStartX,
                startButtonPanelStartY, startButtonPanelWidth, startButtonPanelHeight);

        // creates start button
        // when you click startButton it recognizes that click and calls g.handler
        startButton = makeButton(startButton, "START", startButtonPanel, "start");
        startButton.setFocusPainted(false);

        con.add(titlePanel); //adds title panel to display
        con.add(startButtonPanel); //adds start button panel to display
    }

    protected void gameScreen(){
        //add main text Panel and main text area on it
        int mainTextPanelWidth = 800;
        int mainTextPanelHeight = 300;
        int startMainTextPanelX = (screenSizeX - mainTextPanelWidth) / 2;
        int startMainTextPanelY = 100 + 30;

        mainTextPanel = makePanel(mainTextPanel, startMainTextPanelX, startMainTextPanelY,
                mainTextPanelWidth, mainTextPanelHeight);

        mainTextArea = new JTextArea("This is main text area");
        mainTextArea.setBounds(startMainTextPanelX, startMainTextPanelY, mainTextPanelWidth,
                mainTextPanelHeight);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        //next choice button panel is to set up
        int choiceButtonPanelWidth = 600;
        int choiceButtonPaneHeight = 150;
        int choiceButtonPanePanelX = (screenSizeX - choiceButtonPanelWidth) / 2;
        int choiceButtonPanePanelY = screenSizeY - choiceButtonPaneHeight - 50;

        choiceButtonPanel = makePanel(choiceButtonPanel, choiceButtonPanePanelX,
                choiceButtonPanePanelY, choiceButtonPanelWidth, choiceButtonPaneHeight);
        choiceButtonPanel.setLayout(new GridLayout(4, 1)); // set grid layout on
        // that panel to 4 rows and 1 column that method takes object
        // from Class GridLayout as a parameter

        //now every single (4) choice button is added
        makeButton(choice_1,"Choice 1", choiceButtonPanel,"c1");
        makeButton(choice_2,"Choice 2", choiceButtonPanel,"c2");
        makeButton(choice_3,"Choice 3", choiceButtonPanel,"c3");
        makeButton(choice_4,"Choice 4", choiceButtonPanel,"c4");

        headsUpDisplay();

        mainTextPanel.add(mainTextArea);
        con.add(mainTextPanel);
        con.add(choiceButtonPanel);
    }

    protected void headsUpDisplay(){

        //next we add player interface panel in the right upper corner
        int interfacePanelWidth = 300;
        int interfacePanelHeight = 100;
        int hudAndInterfaceOffset = 100;
        int interfacePanelStartX = screenSizeX - interfacePanelWidth - hudAndInterfaceOffset;
        int interfacePanelStartY = 15;

        interfacePanel = makePanel(interfacePanel, interfacePanelStartX, interfacePanelStartY,
                interfacePanelWidth,interfacePanelHeight);
        interfacePanel.setLayout(new GridLayout(4, 1));


        //next we add hud panel in the left upper corner
        int hudPanelWidth = 500;
        int hudPanelHeight = interfacePanelHeight;
        int hudPanelStartX = hudAndInterfaceOffset;
        int hudPanelStartY = interfacePanelStartY;

        hudPanel = makePanel(hudPanel, hudPanelStartX, hudPanelStartY,
                hudPanelWidth, hudPanelHeight);
        hudPanel.setLayout(new GridLayout(3, 2));

        //next objects added to interface panel and hud panel
        hpLabel = makeLabel(hpLabel, "HP: ", normalFont, hudPanel);
        hpAmountLabel = makeLabel(hpAmountLabel, "", normalFont, hudPanel);
        weaponLabel = makeLabel(weaponLabel, "Weapon: ", normalFont, hudPanel);
        equippedWeaponLabel = makeLabel(equippedWeaponLabel, "", normalFont, hudPanel);
        armorLabel = makeLabel(armorLabel, "Armor: ", normalFont, hudPanel);
        equippedArmorLabel = makeLabel(equippedArmorLabel, "", normalFont, hudPanel);

        statisticsButton = makeButton(statisticsButton, "Statistics", interfacePanel, "stats");
        inventoryButton = makeButton(inventoryButton, "Inventory", interfacePanel, "inventory");
        journalButton = makeButton(journalButton, "Journal", interfacePanel, "journal");
        settingsButton = makeButton(settingsButton, "settings", interfacePanel, "settings");

        hudUpdate();

        con.add(hudPanel);
        con.add(interfacePanel);
    }

    public void createStatsScreen() {
        //unsetting every object on the screen
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        interfacePanel.setVisible(false);
        hudPanel.setVisible(false);

        //setting up table with statistics
        String[] columnNames = {"", "", "", ""};

        Object[][] statistics = {
                {"Stamina", player.stamina, "Armor", player.protection},
                {"Power", player.power, "Strength", player.strength},
                {"Intelligence", "6", "Wisdom", "3"},
                {"Agility", "6", "Cunning", "5"},
                {"Spirit", player.spirit, "Perception", "4"}
        };

        statisticsTable = new JTable(statistics, columnNames);
        statisticsTable.setBackground(Color.black);
        statisticsTable.setForeground(Color.white);
        statisticsTable.setFont(normalFont);
        statisticsTable.setRowHeight(70);
        statisticsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        statisticsTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        statisticsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        statisticsTable.setShowGrid(false);
        statisticsTable.setEnabled(false);

        //add header "statistics"
        int headerWidth = 400;
        int headerHeight = 80;
        int headerStartX = (screenSizeX - headerWidth) / 2;
        int headerStartY = 20;

        statisticsHeaderPanel = makePanel(statisticsHeaderPanel, headerStartX,
                headerStartY, headerWidth, headerHeight);
        statsLabel = makeLabel(statsLabel, "Statistics", normalFont, statisticsHeaderPanel);

        //add statistics panel
        int playerStatsPanelWidth = 600;
        int playerStatsPanelHeight = 350;
        int playerStatsPanelStartX = (screenSizeX - playerStatsPanelWidth) / 2 + 20;
        int playerStatsPanelStartY = (screenSizeY - playerStatsPanelHeight) / 2 - 30;

        statsPanel = makePanel(statsPanel, playerStatsPanelStartX, playerStatsPanelStartY,
                playerStatsPanelWidth, playerStatsPanelHeight);
        statsPanel.add(statisticsTable);

        //add return button panel
        int returnButtonPanelWidth = 200;
        int returnButtonPanelHeight = 50;
        int returnButtonPanelStartX = (screenSizeX - returnButtonPanelWidth) / 2;
        int returnButtonPaneStartY = screenSizeY - returnButtonPanelHeight - 85;

        statsReturnBtnPanel = makePanel(statsReturnBtnPanel, returnButtonPanelStartX,
                returnButtonPaneStartY, returnButtonPanelWidth, returnButtonPanelHeight);

        statisticsReturnButton = makeButton(statisticsReturnButton, "Return",
                statsReturnBtnPanel, "statsReturn");

        //assign objects to main container (screen)
        con.add(statisticsHeaderPanel);
        con.add(statsPanel);
        con.add(statsReturnBtnPanel);
    }

    public void returnToGame(){
        statsReturnBtnPanel.setVisible(false);
        statsPanel.setVisible(false);
        statisticsHeaderPanel.setVisible(false);

        mainTextPanel.setVisible(true);
        choiceButtonPanel.setVisible(true);
        interfacePanel.setVisible(true);
        hudPanel.setVisible(true);
    }

    //making static methods just to keep code DRY (Don't Repeat Yourself)
    static JPanel makePanel(JPanel panel, int x, int y, int width, int height){
        panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.black);
        return panel;
    }

    static JLabel makeLabel(JLabel label, String name,Font font, JPanel panel){
        label = new JLabel(name);
        label.setForeground(Color.white);
        label.setFont(font);
        panel.add(label);
        return label;
    }

    protected JButton makeButton(JButton button, String name, JPanel panel, String action){
        button = new JButton(name);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setFont(normalFont);
        panel.add(button);
        button.addActionListener(game.handler);
        button.setActionCommand(action);
        return button;
    }

    public void hudUpdate(){
        equippedWeaponLabel.setText(player.weapon.name);
        equippedArmorLabel.setText(player.armor.name);
        hpAmountLabel.setText("" + player.hp);
    }

}
