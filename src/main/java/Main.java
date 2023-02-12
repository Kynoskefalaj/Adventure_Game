import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    JFrame mainWindow;
    Container con;
    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleLabel, hpLabel, hpAmountLabel, weaponLabel, equippedWeaponLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN,90); // creates new font for title with size - 90
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton, choice_1, choice_2, choice_3, choice_4;
    JTextArea mainTextArea;

    int playerHP;
    String equippedWeapon;
    String actualLocation;
    boolean rope;
    boolean key;
    boolean leatherArmor;
    boolean gem;
    int playerCoins;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {

        new Main();//constructor call
    }

    public Main(){ //constructor

        mainWindow = new JFrame(); //creating new instance of JFrame
        mainWindow.setSize(800,600);
        mainWindow.getContentPane().setBackground(Color.BLACK);
        mainWindow.setVisible(true);
        mainWindow.setLayout(null); //disables default layout because I want to customize game layout
        con = mainWindow.getContentPane();

        // creates panel where will be title
        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,600,150);
        titlePanel.setBackground(Color.black);

        // creates label with title name
        titleLabel = new JLabel("ADVENTURE");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        // creates panel for start button
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200,100);
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

    public void createGameScreen(){

        titlePanel.setVisible(false); // firstly we have to hide everything from title screen
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);

        mainTextArea = new JTextArea("This is main text area");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(100,350,600,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1)); // set grid layout on that panel to 4 rows and 1 column


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


        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));


        hpLabel = new JLabel("HP: ");
        hpLabel.setForeground(Color.white);
        hpLabel.setFont(normalFont);
        playerPanel.add(hpLabel);

        hpAmountLabel = new JLabel();
        hpAmountLabel.setForeground(Color.white);
        hpAmountLabel.setFont(normalFont);
        playerPanel.add(hpAmountLabel);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(normalFont);
        playerPanel.add(weaponLabel);

        equippedWeaponLabel = new JLabel();
        equippedWeaponLabel.setForeground(Color.white);
        equippedWeaponLabel.setFont(normalFont);
        playerPanel.add(equippedWeaponLabel);


        mainTextPanel.add(mainTextArea);
        con.add(playerPanel);
        con.add(mainTextPanel);
        con.add(choiceButtonPanel);

        playerSetup();
        crossroads();
    }

    public void playerSetup(){
        playerHP = 15;
        playerCoins = 0;
        equippedWeapon = "Knife";
        equippedWeaponLabel.setText(equippedWeapon);
        hpAmountLabel.setText("" + playerHP);
        rope = false;
        key = false;
        leatherArmor = false;
        gem = false;

    }

    public class TitleScreenHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {

            createGameScreen(); // calls method createGameScreen
        }
    }

    public class ChoiceHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();


            switch (actualLocation){
                case "crossroads":
                    switch (yourChoice){
                        case "c1": talkGuard(); break;
                        case "c2": meadow(); break;
                        case "c3": break;
                        case "c4": break;
                    } break;

                case "talkGuard":
                    switch (yourChoice){
                        case "c1":
                            if (isPlayerAlive()){
                                attackGuard();
                            } else {
                                death();
                            }
                        case "c2": break;
                        case "c3": break;
                        case "c4": crossroads(); break;
                    } break;

                case "attackGuard":
                    switch (yourChoice){
                        case "c1":
                            if (isPlayerAlive()){
                                attackGuard();
                            } else {
                                death();
                            }
                        case "c2": break;
                        case "c3": break;
                        case "c4": crossroads(); break;
                    } break;

                case "meadow":
                    switch (yourChoice){
                        case "c1": theCave(); break;
                        case "c2": river(); break;
                        case "c3": giantTree(); break;
                        case "c4": crossroads(); break;
                    } break;

                case "river":
                    switch (yourChoice){
                        case "c1": theCave(); break;
                        case "c2": river(); break;
                        case "c3": giantTree(); break;
                        case "c4": crossroads(); break;
                    } break;

                case "theCave":
                    switch (yourChoice){
                        case "c1": goblin(); break;
                        case "c2": break;
                        case "c3": giantTree(); break;
                        case "c4": crossroads(); break;
                    } break;
            }

        }
    }

    public void crossroads(){
        actualLocation = "crossroads";

        mainTextArea.setText("After many days of long, exhausting journey \nyou finally went out of " +
                "the woods and noticed \nsmall town down the hill. \n\nEntry is guarded by armed man.");

        choice_1.setText("Go to the entrance gate");
        choice_2.setText("Go back to the woods");
        choice_3.setText("Wait in the shadow, till the sun will go down");
        choice_4.setText("Check if there is any other entrance");
    }

    public void talkGuard() {
        actualLocation = "talkGuard";

        mainTextArea.setText("Hello stranger! I have never seen your face, " +
                "\nso I cannot let you in to our town. \n\nWhere are you from?");

        choice_1.setText("Attack The Guard");
        choice_2.setText("I'm from the Dark Woods");
        choice_3.setText("I'm new blacksmith's apprentice");
        choice_4.setText("Return to the crossroads");
    }

    public void attackGuard(){
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

    public void meadow(){
        actualLocation = "meadow";

        mainTextArea.setText("You are in the woods that you came from.");

        choice_1.setText("Go to the cave");
        choice_2.setText("Go to the river");
        choice_3.setText("Go to the giant tree");
        choice_4.setText("Go to the crossroads");
    }

    public void river(){
        actualLocation = "river";
        int restoredHP = new java.util.Random().nextInt(4);
        playerHP += restoredHP;
        if(playerHP>15){ //set max HP to 15
            playerHP = 15;
        }
        hpAmountLabel.setText("" + playerHP);

        mainTextArea.setText("You came to the river bank and drink water by your hands.\n" +
                "Your health is restored by " + restoredHP+ ".");

        choice_1.setText("Go to the cave");
        choice_2.setText("Drink more");
        choice_3.setText("Go to the giant tree");
        choice_4.setText("Go to the crossroads");
    }

    public void theCave(){
        actualLocation = "theCave";

        mainTextArea.setText("When you came closer to the cave you can smell that something inside horribly stinks.");

        choice_1.setText("Go in");
        choice_2.setText("Go to the river");
        choice_3.setText("Go to the giant tree");
        choice_4.setText("Go to meadow");
    }

    public void goblin(){
        actualLocation = "goblin";

        mainTextArea.setText("You encountered horrifying, mad Goblin!");

        choice_1.setText("Try to comfort him");
        choice_2.setText("Attack");
        choice_3.setText("Run");
        choice_4.setText("Climb on giant rock");
    }

    public void giantRock(){
        actualLocation = "giantRock";

        mainTextArea.setText("You are lucky, that stupid goblin is unable to reach you there.\n" +
                "You've found also a rope.");
        rope = true;

        choice_1.setText("Try to comfort him");
        choice_2.setText("Leap off");
        if (equippedWeapon == "shortBow"){
            choice_3.setText("Attack");
        }
        else
            choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public void giantTree(){
        actualLocation = "giantTree";

        mainTextArea.setText("That Tree is really huge. When you look up you \n" +
                "see a treehouse hidden high in branches. You cannot reach it without rope.");

        choice_1.setText("Go to the cave");
        choice_2.setText("Go to the river");
        choice_3.setText("Go to meadow");

        if (rope == true){
            choice_4.setVisible(true);
            choice_4.setText("Climb up");
        }
        else
            choice_4.setVisible(false);
    }

    public void treeHouse(){
        actualLocation = "treeHouse";

        mainTextArea.setText("After a while of exhausting climbing you've finally reached a treeHouse." +
                "The view from here is amazing. You see a windmill a few miles away. You see a sheet of paper on the desk. \" Dear Sam,\n" +
                "I know that I was supposed to wait for you in our hut and don't go anywhere to your comeback.\n" +
                "But my wound is going over and over to be worse. I think I can't wait longer. I'm going to visit my" +
                "uncle in windmill north from here and take some medicines from him. A bow is under bed\" Inside you've found a short bow! You noticed also a  ");

        choice_1.setText("Try to comfort him");
        choice_2.setText("Attack");
        choice_3.setText("Run");
        choice_4.setText("Climb on giant rock");
    }

    public void theLetter(){
        actualLocation = "theLetter";

        mainTextArea.setText("\" Dear Sam,\n" +
                "I know that I was supposed to wait for you in our hut and don't go anywhere to your comeback.\n" +
                "But my wound is going over and over to be worse. I think I can't wait longer. I'm going to visit my" +
                "uncle in windmill north from here and take some medicines from him. A bow is under bed");

        choice_1.setText("Look under the bed");
        choice_2.setText("<");

        choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public void theChest(){
        actualLocation = "theChest";

        mainTextArea.setText("The chest is locked. You can't open it without a proper key.");
        choice_1.setText("<");
        if (key == true) {
            choice_2.setVisible(true);
            choice_2.setText("Open");
        } else
            choice_2.setVisible(false);
        choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public void theWindmill(){
        actualLocation = "theWindmill";

        mainTextArea.setText("You see something here is wrong. The doors leading to the mill are open.");
        choice_1.setText("Go in");
        choice_2.setText("Go to the cave");
        choice_3.setText("Go to the giant tree");
        choice_4.setText("Go to the meadow");
    }

    public void insideTheWindmill(){
        actualLocation = "insideTheWindmill";

        mainTextArea.setText("The view inside is horrible. Everything is in total mess. You found ripped off " +
                "upper part of human corpse. Everything is in blood, but you clearly noticed there " +
                "is a track of blood leading outside by rear exit. ");
        choice_1.setText("Check the corpse");
        choice_2.setText("Check the track of blood");
        choice_3.setText("Go outside");
        choice_4.setVisible(false);
    }

    public void theCorpse() {
        actualLocation = "theCorpse";

        mainTextArea.setText("You've found a key.");
        choice_1.setText("<");
        choice_2.setVisible(false);
        choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public void theCemetery() {
        actualLocation = "theCemetery";

        mainTextArea.setText("Track of blood led you to creepy cemetery. " +
                "There is a small shrine with priest statue. Behind the statue is tomb with marble doors." +
                "You've noticed that one grave is dug up.");
        choice_1.setText("Go to the tomb");
        choice_2.setText("Check the grave");
        choice_3.setText("Check the statue");
        choice_4.setText("Go to the mill");
    }

    public void theGrave() {
        actualLocation = "theGrave";

        mainTextArea.setText("Here lies Edwyn Bones.");
        choice_1.setText("<");
        choice_2.setVisible(false);
        choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public void theShrine() {
        actualLocation = "theShrine";

        mainTextArea.setText("When you came closer to the shrine you see clearly that" +
                "a priest represented by statue reach out his hand. His hand is the hand is arranged as " +
                "if it is holding something. Something is missing here.");
        choice_1.setText("<");
        if (gem = true){
            choice_2.setVisible(true);
            choice_2.setText("Put a jewel in that hand");
        } else
            choice_2.setVisible(false);

        choice_3.setVisible(false);
        choice_4.setVisible(false);
    }

    public void tombUnlock() {
        actualLocation = "tombUnlock";

        mainTextArea.setText("Eureka! When you put the gem inside priest's hand," +
                "the doors leading to the Tomb opened.");
        choice_1.setText("Enter the tomb");
        choice_3.setText("Go to windmill");
        choice_4.setText("Go to the cave");
    }

    public void ghoul() {
        actualLocation = "ghoul";

        mainTextArea.setText("You 've encountered a Ghoul!");
        choice_1.setText("Attack");
        choice_2.setText("Run");
        choice_3.setVisible(false);
        choice_4.setVisible(false);
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
        if (playerHP > 0){
            return true;
        } else
            return false;
    }




}