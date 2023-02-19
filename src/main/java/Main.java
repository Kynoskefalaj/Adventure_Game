import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Main {

    JFrame mainWindow;
    Container con;
    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel,
            playerInterfacePanel, hudPanel, playerStatisticsHeaderPanel,
            playerStatsPanel, statisticsReturnButtonPanel;
    JLabel titleLabel, hpLabel, hpAmountLabel, weaponLabel, equippedWeaponLabel,
            equippedArmorLabel, armorLabel, playerStatsLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90); // creates new font for title with size - 90
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font headerFont = new Font("Times New Roman", Font.PLAIN, 60);
    JButton startButton, choice_1, choice_2, choice_3, choice_4, statisticsButton,
            inventoryButton, journalButton, settingsButton, statisticsReturnButton;
    JTextArea mainTextArea;
    JTable playerStatisticsTable;

    int screenSizeX = 1000;
    int screenSizeY = 650;

    int playerHP, playerPower, playerArmor, playerSpirit, playerStrength;
    int goblinHP, goblinPower;
    String equippedWeapon, equippedArmor;
    String actualLocation;
    boolean rope, key, leatherArmor, gem, goblinAlive, ghoulAlive, ghoulTrophy;
    boolean tombAvailable = false;
    int playerCoins;
    int healthPotions;
    int ghoulHP, ghoulPower;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    StatisticsButtonHandler statsHandler = new StatisticsButtonHandler();
    ReturnHandler returnHandler = new ReturnHandler();


    public static void main(String[] args) {

        new Main();//constructor call
    }

    public Main() { //class constructor

        mainWindow = new JFrame(); //creating new instance of JFrame
        mainWindow.setSize(screenSizeX, screenSizeY);
        mainWindow.getContentPane().setBackground(Color.BLACK);
        mainWindow.setVisible(true);
        mainWindow.setLayout(null); //disables default layout because I want to customize game layout
        con = mainWindow.getContentPane();

        // creates panel where will be title
        int titlePanelWidth = 600;
        int titlePanelHeight = 150;
        int titlePanelStartX = (screenSizeX - titlePanelWidth) / 2;
        int titlePanelStartY = ((screenSizeY - titlePanelHeight) / 2 - 70);


        titlePanel = new JPanel();
        titlePanel.setBounds(titlePanelStartX, titlePanelStartY, titlePanelWidth, titlePanelHeight);
        titlePanel.setBackground(Color.black);

        // creates label with title name
        titleLabel = new JLabel("ADVENTURE");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        // creates panel for start button
        int startButtonPanelWidth = 200;
        int startButtonPanelHeight = 100;
        int startButtonPanelStartX = (screenSizeX - startButtonPanelWidth) / 2;
        int startButtonPanelStartY = (screenSizeY - startButtonPanelHeight) / 2 + 70;


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(startButtonPanelStartX, startButtonPanelStartY,
                startButtonPanelWidth, startButtonPanelHeight);
        startButtonPanel.setBackground(Color.black);

        // creates start button
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(tsHandler); // when you click startButton it recognizes that click and calls tsHandler


        titlePanel.add(titleLabel); // adds title label on title panel
        startButtonPanel.add(startButton); //adds start button on button panel

        con.add(titlePanel); //adds title panel to display
        con.add(startButtonPanel); //adds start button panel to display
    }

    public void createGameScreen() {

        titlePanel.setVisible(false); // firstly we have to hide everything from title screen
        startButtonPanel.setVisible(false);

        //next we add main text Panel and main text area on it
        int mainTextPanelWidth = 800;
        int mainTextPanelHeight = 300;
        int startMainTextPanelX = (screenSizeX - mainTextPanelWidth) / 2;
        int startMainTextPanelY = 100 + 30;

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(startMainTextPanelX, startMainTextPanelY, mainTextPanelWidth,
                mainTextPanelHeight);
        mainTextPanel.setBackground(Color.black);

        mainTextArea = new JTextArea("This is main text area");
        mainTextArea.setBounds(startMainTextPanelX, startMainTextPanelY, mainTextPanelWidth,
                mainTextPanelHeight);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);


        //next choice button panel is to set up
        int choiceButtonPanelWidth = 600;
        int choiceButtonPaneHeight = 150;
        int choiceButtonPanePanelX = (screenSizeX - choiceButtonPanelWidth) / 2;
        int choiceButtonPanePanelY = screenSizeY - choiceButtonPaneHeight - 50;

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(choiceButtonPanePanelX, choiceButtonPanePanelY, choiceButtonPanelWidth,
                choiceButtonPaneHeight);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1)); // set grid layout on
        // that panel to 4 rows and 1 column that method takes object
        // from Class GridLayout as a parameter

        //now every single (4) choice button is added
        choice_1 = new JButton("Choice 1");
        choice_1.setBackground(Color.BLACK);
        choice_1.setForeground(Color.white);
        choice_1.setFont(normalFont);
        choiceButtonPanel.add(choice_1);
        choice_1.addActionListener(choiceHandler);
        choice_1.setActionCommand("c1");

        choice_2 = new JButton("Choice 2");
        choice_2.setBackground(Color.BLACK);
        choice_2.setForeground(Color.white);
        choice_2.setFont(normalFont);
        choiceButtonPanel.add(choice_2);
        choice_2.addActionListener(choiceHandler);
        choice_2.setActionCommand("c2");

        choice_3 = new JButton("Choice 3");
        choice_3.setBackground(Color.BLACK);
        choice_3.setForeground(Color.white);
        choice_3.setFont(normalFont);
        choiceButtonPanel.add(choice_3);
        choice_3.addActionListener(choiceHandler);
        choice_3.setActionCommand("c3");

        choice_4 = new JButton("Choice 4");
        choice_4.setBackground(Color.BLACK);
        choice_4.setForeground(Color.white);
        choice_4.setFont(normalFont);
        choiceButtonPanel.add(choice_4);
        choice_4.addActionListener(choiceHandler);
        choice_4.setActionCommand("c4");

        //next we add player interface panel in the right upper corner
        int playerInterfacePanelWidth = 300;
        int playerInterfacePanelHeight = 100;
        int playerHudAndInterfaceOffset = 100;
        int playerInterfacePanelStartX = screenSizeX - playerInterfacePanelWidth - playerHudAndInterfaceOffset;
        int playerInterfacePanelStartY = 15;

        playerInterfacePanel = new JPanel();
        playerInterfacePanel.setBounds(playerInterfacePanelStartX, playerInterfacePanelStartY,
                playerInterfacePanelWidth, playerInterfacePanelHeight);
        playerInterfacePanel.setBackground(Color.black);
        playerInterfacePanel.setLayout(new GridLayout(4, 1));

        //next we add hud panel in the left upper corner
        int hudPanelWidth = playerInterfacePanelWidth;
        int hudPanelHeight = playerInterfacePanelHeight;
        int hudPanelStartX = playerHudAndInterfaceOffset;
        int hudPanelStartY = playerInterfacePanelStartY;

        hudPanel = new JPanel();
        hudPanel.setBounds(hudPanelStartX, hudPanelStartY, hudPanelWidth, hudPanelHeight);
        hudPanel.setBackground(Color.black);
        hudPanel.setLayout(new GridLayout(3, 2));

        //next objects added to interface panel and hud panel
        hpLabel = new JLabel("HP: ");
        hpLabel.setForeground(Color.white);
        hpLabel.setFont(normalFont);
        hudPanel.add(hpLabel);

        hpAmountLabel = new JLabel();
        hpAmountLabel.setForeground(Color.white);
        hpAmountLabel.setFont(normalFont);
        hudPanel.add(hpAmountLabel);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(normalFont);
        hudPanel.add(weaponLabel);

        equippedWeaponLabel = new JLabel();
        equippedWeaponLabel.setForeground(Color.white);
        equippedWeaponLabel.setFont(normalFont);
        hudPanel.add(equippedWeaponLabel);

        armorLabel = new JLabel("Armor: ");
        armorLabel.setForeground(Color.white);
        armorLabel.setFont(normalFont);
        hudPanel.add(armorLabel);

        equippedArmorLabel = new JLabel();
        equippedArmorLabel.setForeground(Color.white);
        equippedArmorLabel.setFont(normalFont);
        hudPanel.add(equippedArmorLabel);

        statisticsButton = new JButton("Statistics");
        statisticsButton.setBackground(Color.BLACK);
        statisticsButton.setForeground(Color.white);
        statisticsButton.setFont(normalFont);
        playerInterfacePanel.add(statisticsButton);
        statisticsButton.addActionListener(statsHandler);
//        choice_4.setActionCommand("c4");

        inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(Color.BLACK);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(normalFont);
        playerInterfacePanel.add(inventoryButton);
//        choice_4.addActionListener(choiceHandler);
//        choice_4.setActionCommand("c4");

        journalButton = new JButton("Journal");
        journalButton.setBackground(Color.BLACK);
        journalButton.setForeground(Color.white);
        journalButton.setFont(normalFont);
        playerInterfacePanel.add(journalButton);
//        choice_4.addActionListener(choiceHandler);
//        choice_4.setActionCommand("c4");

        settingsButton = new JButton("Settings");
        settingsButton.setBackground(Color.BLACK);
        settingsButton.setForeground(Color.white);
        settingsButton.setFont(normalFont);
        playerInterfacePanel.add(settingsButton);
//        choice_4.addActionListener(choiceHandler);
//        choice_4.setActionCommand("c4");


        mainTextPanel.add(mainTextArea);
        con.add(playerInterfacePanel);
        con.add(hudPanel);
        con.add(mainTextPanel);
        con.add(choiceButtonPanel);

        playerSetup();
        monstersSetup();
        crossroads();
    }

    public void createStatsScreen() {
        //unsetting every object on the screen
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        playerInterfacePanel.setVisible(false);
        hudPanel.setVisible(false);

        //setting up table with statistics
        String[] columnNames = {"", "", "", ""};

        Object[][] statistics = {
                {"Health", playerHP, "Armor", playerArmor},
                {"Power", playerPower, "Strength", "4"},
                {"Intelligence", "6", "Wisdom", "3"},
                {"Agility", "6", "Stamina", "5"},
                {"Spirit", playerSpirit, "Perception", "4"}
        };

        playerStatisticsTable = new JTable(statistics, columnNames);
        playerStatisticsTable.setBackground(Color.black);
        playerStatisticsTable.setForeground(Color.white);
        playerStatisticsTable.setFont(normalFont);
        playerStatisticsTable.setRowHeight(70);
        playerStatisticsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        playerStatisticsTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        playerStatisticsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        playerStatisticsTable.setShowGrid(false);
        playerStatisticsTable.setEnabled(false);


//        playerStatisticsTable.setPreferredScrollableViewportSize(new Dimension(600,250));

        //add header "statistics"
        int headerWidth = 400;
        int headerHeight = 80;
        int headerStartX = (screenSizeX - headerWidth) / 2;
        int headerStartY = 20;

        playerStatisticsHeaderPanel = new JPanel();
        playerStatisticsHeaderPanel.setBounds(headerStartX, headerStartY,
                headerWidth, headerHeight);
        playerStatisticsHeaderPanel.setBackground(Color.black);

        playerStatsLabel = new JLabel("Statistics");
        playerStatsLabel.setForeground(Color.white);
        playerStatsLabel.setFont(headerFont);

        playerStatisticsHeaderPanel.add(playerStatsLabel);

        //add statistics panel
        int playerStatsPanelWidth = 600;
        int playerStatsPanelHeight = 350;
        int playerStatsPanelStartX = (screenSizeX - playerStatsPanelWidth) / 2 + 20;
        int playerStatsPanelStartY = (screenSizeY - playerStatsPanelHeight) / 2 - 30;

        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(playerStatsPanelStartX, playerStatsPanelStartY,
                playerStatsPanelWidth, playerStatsPanelHeight);
        playerStatsPanel.setBackground(Color.black);
//        playerStatsPanel.setLayout(new GridLayout(4, 4));

        playerStatsPanel.add(playerStatisticsTable);


        //add return button panel
        int returnButtonPanelWidth = 200;
        int returnButtonPanelHeight = 50;
        int returnButtonPanelStartX = (screenSizeX - returnButtonPanelWidth) / 2;
        int returnButtonPaneStartY = screenSizeY - returnButtonPanelHeight - 85;

        statisticsReturnButtonPanel = new JPanel();
        statisticsReturnButtonPanel.setBounds(returnButtonPanelStartX, returnButtonPaneStartY,
                returnButtonPanelWidth, returnButtonPanelHeight);
        statisticsReturnButtonPanel.setBackground(Color.black);

        statisticsReturnButton = new JButton("Return");
        statisticsReturnButton.setBackground(Color.BLACK);
        statisticsReturnButton.setForeground(Color.white);
        statisticsReturnButton.setFont(normalFont);
        statisticsReturnButton.setFocusPainted(false);
        statisticsReturnButton.addActionListener(returnHandler); // when you click startButton it recognizes that click and calls tsHandler
        statisticsReturnButtonPanel.add(statisticsReturnButton);

        //assign objects to main container (screen)
        con.add(playerStatisticsHeaderPanel);
        con.add(playerStatsPanel);
        con.add(statisticsReturnButtonPanel);
    }

    public void returnToGame(){
        statisticsReturnButtonPanel.setVisible(false);
        playerStatsPanel.setVisible(false);
        playerStatisticsHeaderPanel.setVisible(false);

        mainTextPanel.setVisible(true);
        choiceButtonPanel.setVisible(true);
        playerInterfacePanel.setVisible(true);
        hudPanel.setVisible(true);
    }

    public void playerSetup() {
        playerHP = 15;
        playerCoins = 0;
        playerSpirit = 4;
        playerStrength = 4;
        equippedWeapon = "Knife";
        equippedArmor = "Worn Jacket";

        switch (equippedWeapon) {
            case "Knife" -> playerPower = 3;
            case "Rusty Sword" -> playerPower = 7;
        }

        playerArmor = 2;

        equippedWeaponLabel.setText(equippedWeapon);
        hpAmountLabel.setText("" + playerHP);
        equippedArmorLabel.setText(equippedArmor);

        rope = false;
        key = false;
        leatherArmor = false;
        gem = false;
        ghoulTrophy = false;


    }

    public void monstersSetup() {
        goblinHP = 20;
        goblinPower = 10;
        goblinAlive = true;

        ghoulHP = 250;
        ghoulPower = 10;
    }

    public class TitleScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            createGameScreen(); // calls method createGameScreen
        }
    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (actualLocation) {
                case "crossroads":
                    switch (yourChoice) {
                        case "c1":
                            talkGuard();
                            break;
                        case "c2":
                            meadow();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "talkGuard":
                    switch (yourChoice) {
                        case "c1":
                            attackGuard();
                            if (isPlayerAlive()) {
                                break;
                            } else {
                                death();
                            }
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            crossroads();
                            break;
                    }
                    break;

                case "attackGuard":
                    switch (yourChoice) {
                        case "c1":
                            attackGuard();
                            if (isPlayerAlive()) {
                                break;
                            } else {
                                death();
                            }
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            crossroads();
                            break;
                    }
                    break;

                case "meadow":
                    switch (yourChoice) {
                        case "c1":
                            theCave();
                            break;
                        case "c2":
                            river();
                            break;
                        case "c3":
                            giantTree();
                            break;
                        case "c4":
                            crossroads();
                            break;
                    }
                    break;

                case "river":
                    switch (yourChoice) {
                        case "c1":
                            swimming();
                            break;
                        case "c2":
                            river();
                            break;
                        case "c3":
                            giantTree();
                            break;
                        case "c4":
                            crossroads();
                            break;
                    }
                    break;

                case "swimming":
                    switch (yourChoice) {
                        case "c1":
                            theCave();
                            break;
                        case "c2":
                            river();
                            break;
                        case "c3":
                            giantTree();
                            break;
                        case "c4":
                            crossroads();
                            break;
                    }
                    break;

                case "theCave":
                    switch (yourChoice) {
                        case "c1":
                            if (goblinAlive) {
                                goblin();
                            } else {
                                goblinDown();
                            }
                            break;
                        case "c2":
                            river();
                            break;
                        case "c3":
                            giantTree();
                            break;
                        case "c4":
                            crossroads();
                            break;
                    }
                    break;

                case "goblin":
                    switch (yourChoice) {
                        case "c1":
                            goblinAttack();
                            if (isPlayerAlive()) {
                                break;
                            } else {
                                death();
                            }
                            break;
                        case "c2":
                            playerAttacksGoblin();
                            if (goblinHP < 0) {
                                goblinDown();
                                break;
                            }
                            break;
                        case "c3":
                            theCave();
                            break;
                        case "c4":
                            giantRock();
                            break;
                    }
                    break;

                case "goblinAttack":
                    switch (yourChoice) {
                        case "c1":
                            goblinAttack();
                            if (isPlayerAlive()) {
                                break;
                            } else {
                                death();
                            }
                            break;
                        case "c2":
                            playerAttacksGoblin();
                            if (isGoblinAlive()) {
                                break;
                            } else {
                                goblinDown();
                            }
                            break;
                        case "c3":
                            theCave();
                            break;
                        case "c4":
                            giantRock();
                            break;
                    }
                    break;

                case "playerAttacksGoblin":
                    switch (yourChoice) {
                        case "c1":
                            goblinAttack();
                            if (isPlayerAlive()) {
                                break;
                            } else {
                                death();
                                break;
                            }
                        case "c2":
                            goblinAttack();
                            if (isPlayerAlive()) {
                                break;
                            } else {
                                death();
                            }
                            break;
                        case "c3":
                            theCave();
                            break;
                        case "c4":
                            giantRock();
                            break;
                    }
                    break;

                case "giantRock":
                    switch (yourChoice) {
                        case "c1":
                            goblin();
                            break;
                        case "c2":
                            goblinDown();
                            mainTextArea.setText("You shoot that filthy creature " +
                                    "right between the eyes!" +
                                    "\n Goblin is down.\n\n" +
                                    "You obtained large shiny gem!");
                            break;
                    }
                    break;

                case "goblinDown":
                    switch (yourChoice) {
                        case "c1":
                            giantTree();
                            break;
                        case "c2":
                            river();
                            break;
                        case "c3":
                            theCave();
                            break;
                        case "c4":
                            giantRock();
                            break;
                    }
                    break;

                case "giantTree":
                    switch (yourChoice) {
                        case "c1":
                            theCave();
                            break;
                        case "c2":
                            river();
                            break;
                        case "c3":
                            crossroads();
                            break;
                        case "c4":
                            treeHouse();
                            break;
                    }
                    break;

                case "treeHouse":
                    switch (yourChoice) {
                        case "c1":
                            theLetter();
                            break;
                        case "c2":
                            theChest();
                            break;
                        case "c3":
                            giantTree();
                            break;
                        case "c4":
                            theWindmill();
                            break;
                    }
                    break;

                case "theLetter":
                    switch (yourChoice) {
                        case "c1":
                            bed();
                            break;
                        case "c2":
                            treeHouse();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "theChest":
                    switch (yourChoice) {
                        case "c1":
                            treeHouse();
                            break;
                        case "c2":
                            chestOpen();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "chestOpen":
                    switch (yourChoice) {
                        case "c1":
                            theLetter();
                            break;
                        case "c2":
                            treeHouse();
                            break;
                    }
                    break;

                case "theWindmill":
                    switch (yourChoice) {
                        case "c1":
                            insideTheWindmill();
                            break;
                        case "c2":
                            theCave();
                            break;
                        case "c3":
                            giantTree();
                            break;
                        case "c4":
                            meadow();
                            break;
                    }
                    break;

                case "insideTheWindmill":
                    switch (yourChoice) {
                        case "c1":
                            theCorpse();
                            break;
                        case "c2":
                            theCemetery();
                            break;
                        case "c3":
                            theWindmill();
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "theCorpse":
                    switch (yourChoice) {
                        case "c1":
                            insideTheWindmill();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "theCemetery":
                    switch (yourChoice) {
                        case "c1":
                            tomb();
                            break;
                        case "c2":
                            theGrave();
                            break;
                        case "c3":
                            theShrine();
                            break;
                        case "c4":
                            theWindmill();
                            break;
                    }
                    break;

                case "theShrine":
                    switch (yourChoice) {
                        case "c1":
                            theCemetery();
                            break;
                        case "c2":
                            tombUnlock();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "tombUnlock":
                    switch (yourChoice) {
                        case "c1":
                            tomb();
                            break;
                        case "c2":
                            theWindmill();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "theGrave":
                    switch (yourChoice) {
                        case "c1":
                            theCemetery();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "tomb":
                    switch (yourChoice) {
                        case "c1":
                            theGrave();
                            break;
                        case "c2":
                            theShrine();
                            break;
                        case "c3":
                            theWindmill();
                            break;
                        case "c4":
                            if(ghoulAlive) {
                                tomb1();
                            }
                            else
                                tombCompleted();
                            break;
                    }
                    break;

                case "tombCompleted":
                    if(Objects.equals(yourChoice, "c1")){
                        theCemetery();
                    }
                    break;

                case "tomb1":
                    switch (yourChoice) {
                        case "c1":
                            tomb2();
                            break;
                        case "c2":
                            theCemetery();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "tomb2":
                    switch (yourChoice) {
                        case "c1":
                            tomb3();
                            break;
                        case "c2":
                            theCemetery();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "tomb3":
                    switch (yourChoice) {
                        case "c1":
                            tomb4();
                            break;
                        case "c2":
                            theCemetery();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "tomb4":
                    switch (yourChoice) {
                        case "c1":
                            ghoul();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "ghoul":
                    switch (yourChoice) {
                        case "c1":
                            playerAttacksGhoul();
                            break;
                        case "c2":
                            tomb();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "playerAttacksGhoul":
                    switch (yourChoice) {
                        case "c1":
                            ghoulAttack();
                            if (isPlayerAlive()){
                                break;
                            }
                            else
                                death();
                                break;
                        case "c2":
                            healthPotion();
                            break;
                        case "c3":
                            tomb();
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "ghoulAttack":
                    switch (yourChoice) {
                        case "c1":
                            playerAttacksGhoul();
                            if (isGhoulAlive()){
                                break;
                            }
                            else
                                ghoulDown();
                            break;
                        case "c2":
                            healthPotion();
                            break;
                        case "c3":
                            tomb();
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "healthPotion":
                    switch (yourChoice) {
                        case "c1":
                            ghoulAttack();
                            if(isPlayerAlive()){
                                break;
                            }
                            else
                                death();
                            break;
                        case "c2":
                            healthPotion();
                            break;
                        case "c3":
                            tomb();
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "ghoulDown":
                    switch (yourChoice) {
                        case "c1":
                            ghoulDecapitation();
                            break;
                        case "c2":
                            healthPotion();
                            break;
                        case "c3":
                            tomb();
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "ghoulDecapitation":
                    if(Objects.equals(yourChoice, "c1")){
                        tomb();
                    }
                    break;
            }
        }
    }

    public class StatisticsButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            createStatsScreen();
        }
    }

    public class ReturnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            returnToGame();
        }
    }

    public void crossroads() {
        buttonVisibility(4);
        actualLocation = "crossroads";

        mainTextArea.setText("After many days of long, exhausting journey \nyou finally went out of " +
                "the woods and noticed \nsmall town down the hill. \n\nEntry is guarded by armed man.");

        choice_1.setText("Go to the entrance gate");
        choice_2.setText("Go back to the woods");
        choice_3.setText("Wait in the shadow, till the sun will go down");
        choice_4.setText("Check if there is any other entrance");
    }

    public void talkGuard() {
        buttonVisibility(4);
        actualLocation = "talkGuard";

        mainTextArea.setText("Hello stranger! I have never seen your face, " +
                "\nso I cannot let you in to our town. \n\nWhere are you from?");

        choice_1.setText("Attack The Guard");
        choice_2.setText("I'm from the Dark Woods");
        choice_3.setText("I'm new blacksmith's apprentice");
        choice_4.setText("Return to the crossroads");
    }

    public void attackGuard() {
        buttonVisibility(4);
        actualLocation = "attackGuard";
        int guardHit = new java.util.Random().nextInt(4);

        mainTextArea.setText("The guard dodges your attack and hit " +
                "you back in the head causing " + guardHit + " damage.");
        playerHP -= guardHit;
        hpAmountLabel.setText("" + playerHP);


        choice_1.setText("Attack The Guard");
        choice_2.setText("I'm from the Dark Woods");
        choice_3.setText("I'm new blacksmith's apprentice");
        choice_4.setText("Return to the woods");
    }

    public void meadow() {
        buttonVisibility(4);
        actualLocation = "meadow";

        mainTextArea.setText("You are in the woods that you came from.");

        choice_1.setText("Go to the cave");
        choice_2.setText("Go to the river");
        choice_3.setText("Go to the giant tree");
        choice_4.setText("Go to the crossroads");
    }

    public void river() {
        buttonVisibility(4);
        actualLocation = "river";
        int restoredHP = new java.util.Random().nextInt(4);
        playerHP += restoredHP;
        if (playerHP > 15) { //set max HP to 15
            playerHP = 15;
        }
        playerUpdate();

        mainTextArea.setText("You came to the river bank and drink water by your hands.\n" +
                "Your health is restored by " + restoredHP + ".");

        choice_1.setText("Hop in to the water");
        choice_2.setText("Drink more");
        choice_3.setText("Go to the giant tree");
        choice_4.setText("Go to the crossroads");
    }

    public void swimming() {
        buttonVisibility(4);
        actualLocation = "swimming";
        equippedWeapon = "Rusty Sword";
        playerUpdate();

        mainTextArea.setText("While swimming you found something shiny in the water.\n" +
                "You decided to dive down to get that. \n" +
                "You have found Rusty Sword!");

        choice_1.setText("Go to the cave");
        choice_2.setText("Go to the river bank");
        choice_3.setText("Go to the giant tree");
        choice_4.setText("Go to meadow");
    }

    public void theCave() {
        buttonVisibility(4);
        actualLocation = "theCave";

        mainTextArea.setText("When you came closer to the cave you can smell \n" +
                "that something inside horribly stinks.");

        choice_1.setText("Go in");
        choice_2.setText("Go to the river");
        choice_3.setText("Go to the giant tree");
        choice_4.setText("Go to meadow");
    }

    public void goblin() {
        buttonVisibility(4);
        if (goblinAlive) {
            actualLocation = "goblin";

            mainTextArea.setText("You encountered horrifying, mad Goblin!");

            choice_1.setText("Try to comfort him");
            choice_2.setText("Attack");
            choice_3.setText("Run");
            choice_4.setText("Climb on giant rock");
        } else {
            goblinDown();
        }
    }

    public void goblinAttack() {
        buttonVisibility(4);
        actualLocation = "goblin";
        int goblinHit = Math.abs(playerArmor - new java.util.Random().nextInt(goblinPower));
        playerHP -= goblinHit;

        playerUpdate();

        mainTextArea.setText("Goblin health: " + goblinHP +
                "\n\nGoblin attacks you with loud shout! \n" +
                "You lost " + goblinHit + " health points!");

        choice_1.setText("Try to comfort him");
        choice_2.setText("Attack");
        choice_3.setText("Run");
        choice_4.setText("Climb on giant rock");
    }

    public void playerAttacksGoblin() {
        buttonVisibility(4);
        actualLocation = "playerAttacksGoblin";
        int playerHit = new java.util.Random().nextInt(playerPower);
        goblinHP -= playerHit;

        mainTextArea.setText("Goblin health: " + goblinHP +
                "\n\nYou attack your opponent with " + equippedWeapon + "\n" +
                "Goblin lost " + playerHit + " health points!");

        choice_1.setText("Try to comfort him");
        choice_2.setText("Attack");
        choice_3.setText("Run");
        choice_4.setText("Climb on giant rock");

    }

    public void goblinDown() {
        buttonVisibility(4);
        actualLocation = "goblinDown";
        gem = true;
        goblinAlive = false;

        mainTextArea.setText("You beat this filthy creature! " + "" +
                "\n You obtained large shiny gem!");

        choice_1.setText("Go to giant tree");
        choice_2.setText("Go to the river bank");
        choice_3.setText("Go out to the cave");
        choice_4.setText("Climb on giant rock");
    }

    public void giantRock() {
        buttonVisibility(2);
        actualLocation = "giantRock";

        mainTextArea.setText("You are lucky, that stupid goblin is unable \nto" +
                "reach you there.\n\n" +
                "You've also found a rope.");
        rope = true;

        choice_1.setText("Leap off");
        if (equippedWeapon == "Short Bow") {
            choice_2.setText("Attack");
        } else
            choice_2.setVisible(false);
        choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public void giantTree() {
        buttonVisibility(3);
        actualLocation = "giantTree";

        mainTextArea.setText("That Tree is really huge. When you look up you \n" +
                "see a treehouse hidden high in branches. \n\n" +
                "You cannot reach it without a rope.");

        choice_1.setText("Go to the cave");
        choice_2.setText("Go to the river");
        choice_3.setText("Go to meadow");

        if (rope == true) {
            choice_4.setVisible(true);
            choice_4.setText("Climb up");
        } else
            choice_4.setVisible(false);
    }

    public void treeHouse() {
        buttonVisibility(4);
        actualLocation = "treeHouse";

        mainTextArea.setText("After a while you reached a tree house.\n" +
                "It is long way down.\n" +
                "The view from here is amazing. \nYou see a windmill a few miles away.\n\n" +
                " In this tiny house is nothing but the desk, bed and chest ");

        choice_1.setText("Look at the desk");
        choice_2.setText("Open the chest");
        choice_3.setText("Go down");
        choice_4.setText("Go to the windmill");
    }

    public void theLetter() {
        buttonVisibility(2);
        actualLocation = "theLetter";

        mainTextArea.setText(" Dear Sam,\n" +
                "I know that I was supposed to wait for you " +
                "and don't go anywhere until you come back.\n" +
                "But my wound is going over and over to be worse. I think " +
                "I can't wait longer. I'm going to visit my \n" +
                "uncle in windmill north from here and take some medicines " +
                "from him. A bow is under bed");

        choice_1.setText("Look under the bed");
        choice_2.setText("<");
    }

    public void bed() {
        buttonVisibility(2);
        actualLocation = "theLetter";

        mainTextArea.setText("You have found a Short Bow!");
        equippedWeapon = "Short Bow";
        playerUpdate();

        choice_1.setText("Look under the bed");
        choice_2.setText("<");
    }

    public void theChest() {
        buttonVisibility(1);
        actualLocation = "theChest";

        mainTextArea.setText("The chest is locked. You can't open it without \n" +
                "a proper key.");
        choice_1.setText("<");
        if (key == true) {
            choice_2.setVisible(true);
            choice_2.setText("Open");
        } else
            choice_2.setVisible(false);
        choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public void chestOpen() {
        buttonVisibility(2);
        actualLocation = "chestOpen";
        leatherArmor = true;
        playerUpdate();

        mainTextArea.setText("You've opened the chest with a key from windmill!\n" +
                "You have got nice and robust leather armor.");
        choice_1.setText("Look at the Letter");
        choice_2.setText("<");

    }

    public void theWindmill() {
        buttonVisibility(4);
        actualLocation = "theWindmill";

        mainTextArea.setText("After few hours you reached Windmill.\n" +
                "You see something here is wrong. \n\n" +
                "The doors leading to the mill are open...");

        choice_1.setText("Go in");
        choice_2.setText("Go back to the cave");
        choice_3.setText("Return to the giant tree");
        choice_4.setText("Return the meadow");
    }

    public void insideTheWindmill() {
        buttonVisibility(3);
        actualLocation = "insideTheWindmill";

        mainTextArea.setText("The view inside is horrible. Everything is in total mess.\n" +
                " You found ripped off upper part of human corpse. \n" +
                "Everything is in blood, but you clearly noticed there \n" +
                "is a track of blood leading outside by rear exit. ");

        choice_1.setText("Check the corpse");
        choice_2.setText("Go after the track of blood");
        choice_3.setText("Go back outside");
    }

    public void theCorpse() {
        buttonVisibility(1);
        actualLocation = "theCorpse";
        key = true;

        mainTextArea.setText("It is total abomination..." +
                "\n ... but you've found a key.\n\n" +
                "And also 2 health potions.");

        healthPotions = 2;

        choice_1.setText("<");
    }

    public void theCemetery() {
        buttonVisibility(4);
        actualLocation = "theCemetery";

        mainTextArea.setText("Track of blood led you to creepy cemetery deep in the woods.\n\n " +
                "There is a small shrine with priest statue. \n" +
                "Behind the statue is tomb with marble doors." +
                "It is getting late...\n\n" +
                "You've noticed that one grave is dug up.");

        choice_1.setText("Go to the tomb");
        choice_2.setText("Check the grave");
        choice_3.setText("Check the statue");
        choice_4.setText("Return to the mill");
    }

    public void theGrave() {
        buttonVisibility(1);
        actualLocation = "theGrave";

        mainTextArea.setText("Here lies Edwyn Bones.\n\nRIP");
        choice_1.setText("<");
        choice_2.setVisible(false);
        choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public void theShrine() {
        buttonVisibility(1);
        actualLocation = "theShrine";

        mainTextArea.setText("When you came closer to the shrine you see clearly that" +
                "a priest represented by statue reach out his hand. His hand is the hand is arranged as " +
                "if it is holding something. Something is missing here.");
        choice_1.setText("<");
        if (gem) {
            choice_2.setVisible(true);
            choice_2.setText("Put a jewel in that hand");
        } else
            choice_2.setVisible(false);


    }

    public void tomb() {
        buttonVisibility(3);
        actualLocation = "tomb";
        if (tombAvailable) {
            mainTextArea.setText("The doors opened with heavy noise.\n" +
                    "You feel that something inside is dragging you there...");
            choice_4.setVisible(true);
            choice_4.setText("Enter");
            choice_1.setText("Check the grave");
            choice_2.setText("Check the shrine");
            choice_3.setText("Return the windmill");
        } else {
            mainTextArea.setText("The doors won't budge.");

            choice_1.setText("Check the grave");
            choice_2.setText("Check the shrine");
            choice_3.setText("Return the windmill");
        }
    }

    public void tombUnlock() {
        buttonVisibility(2);
        actualLocation = "tombUnlock";
        tombAvailable = true;

        mainTextArea.setText("Eureka! When you put the gem inside priest's hand," +
                "the doors leading to the Tomb opened.");
        choice_1.setText("Enter the tomb");
        choice_2.setText("Go to windmill");
    }

    public void tomb1() {
        buttonVisibility(2);
        actualLocation = "tomb1";

        mainTextArea.setText("You stepped inside cold, dark tomb.\n" +
                "You realised that you can't hear any noise from \ndown there.\n" +
                "Maybe it is a good sign?\n\nRight?");

        choice_1.setText("Go deeper");
        choice_2.setText("Return to cemetery");
    }

    public void tomb2() {
        buttonVisibility(2);
        actualLocation = "tomb2";

        mainTextArea.setText("It is getting darker and darker.");

        choice_1.setText("Go deeper");
        choice_2.setText("Return to cemetery");
    }

    public void tomb3() {
        buttonVisibility(2);
        actualLocation = "tomb3";

        mainTextArea.setText("Your eyes vision is slowly adapting \n" +
                "to that extreme darkness.");

        choice_1.setText("Go deeper");
        choice_2.setText("Return to cemetery");
    }

    public void tomb4() {
        buttonVisibility(2);
        actualLocation = "tomb4";

        mainTextArea.setText("On the end of dark corridor you noticed kind of...\n" +
                " move... \n\n" +
                "You see pale skin in the shadow.");

        choice_1.setText("Go check");
        choice_2.setText("Return to cemetery");
    }

    public void ghoul() {
        buttonVisibility(2);
        actualLocation = "ghoul";

        mainTextArea.setText("AAAAAAAaaaaaaaaaaaaarrrrghhhhhhhhhhh!!!\n\n" +
                "You 've encountered a Ghoul!");

        choice_1.setText("Attack");
        choice_2.setText("Run");
    }

    public void ghoulAttack() {
        buttonVisibility(3);
        actualLocation = "ghoulAttack";
        int ghoulHit = Math.abs(playerArmor - new java.util.Random().nextInt(ghoulPower));
        playerHP -= ghoulHit;

        playerUpdate();

        mainTextArea.setText("Ghoul attacks you !!!\n\n" +
                "You've lost " + ghoulHit + "health points.");

        choice_1.setText("Attack");
        choice_2.setText("Use health potion");
        choice_3.setText("Run");
    }

    public void playerAttacksGhoul() {
        buttonVisibility(3);
        actualLocation = "playerAttacksGhoul";
        int playerHit = Math.abs(new java.util.Random().nextInt(playerPower));

        mainTextArea.setText("You attacked ghoul with your " + equippedWeapon + "\n\n" +
                "You've dealt " + playerHit + "damage to it.");

        choice_1.setText("Attack");
        choice_2.setText("Use health potion");
        choice_3.setText("Run");
    }

    public void healthPotion() {
        buttonVisibility(2);
        actualLocation = "healthPotion";
        int healedHP = 8 + Math.abs(new java.util.Random().nextInt(playerSpirit));

        mainTextArea.setText("You are using one of your health potions.\n\n" +
                "You've healed " + healedHP + "health points.\n" +
                "You have " + healthPotions + " health potions left.");

        choice_1.setText("Attack");
        choice_2.setText("Use health potion");
        choice_3.setText("Run");
    }

    public void ghoulDown() {
        buttonVisibility(3);
        actualLocation = "ghoulDown";

        mainTextArea.setText("You did it!\n" +
                "People from town will be grateful for that!\n\n" +
                "You've looted 15 gold coins!");

        playerCoins += 15;

        choice_1.setText("Cut off it's head");
        choice_2.setText("Use health potion");
        choice_3.setText("Exit");
    }

    public void ghoulDecapitation() {
        buttonVisibility(1);
        actualLocation = "ghoulDecapitation";
        ghoulTrophy = true;
        ghoulAlive = false;

        mainTextArea.setText("You cut off head of that monster.\n" +
                "Ghoul Trophy added to your inventory.");

        choice_1.setText("Exit");
    }

    public void tombCompleted() {
        buttonVisibility(1);
        actualLocation = "tombCompleted";

        mainTextArea.setText("You've eliminated the threat down there\n" +
                "There is nothing else to do.");

        choice_1.setText("Exit");
    }


    public void death() {
        actualLocation = "death";

        mainTextArea.setText("You are dead.\n\nGAME OVER!");
        choice_1.setVisible(false);
        choice_2.setVisible(false);
        choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public boolean isPlayerAlive() {
        if (playerHP > 0) {
            return true;
        } else
            return false;
    }

    public boolean isGoblinAlive() {
        if (goblinHP > 0) {
            return true;
        } else
            return false;
    }

    public boolean isGhoulAlive() {
        if (ghoulHP > 0) {
            return true;
        } else
            return false;
    }

    public void buttonVisibility(int i) {
        switch (i) {
            case 1:
                choice_1.setVisible(true);
                choice_2.setVisible(false);
                choice_3.setVisible(false);
                choice_4.setVisible(false);
                break;
            case 2:
                choice_1.setVisible(true);
                choice_2.setVisible(true);
                choice_3.setVisible(false);
                choice_4.setVisible(false);
                break;
            case 3:
                choice_1.setVisible(true);
                choice_2.setVisible(true);
                choice_3.setVisible(true);
                choice_4.setVisible(false);
                break;
            case 4:
                choice_1.setVisible(true);
                choice_2.setVisible(true);
                choice_3.setVisible(true);
                choice_4.setVisible(true);
                break;
        }
    }

    public void playerUpdate() {
        switch (equippedWeapon) {
            case "Knife" -> playerPower = 3;
            case "Rusty Sword" -> playerPower = 5;
            case "Short Bow" -> playerPower = 9;
        }
        if (leatherArmor) {
            playerArmor = 7;
        } else {
            playerArmor = 2;
        }
        hpAmountLabel.setText("" + playerHP);
        equippedWeaponLabel.setText(("" + equippedWeapon));
    }

    public void waitThreeSeconds() throws InterruptedException {
        Thread.sleep(3000);
    }
}

