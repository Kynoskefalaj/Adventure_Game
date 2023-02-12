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
        equippedWeapon = "Knife";
        equippedWeaponLabel.setText(equippedWeapon);
        hpAmountLabel.setText("" + playerHP);
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
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                case "townGate":
                    switch (yourChoice){
                        case "c1": break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": crossroads(); break;
                    }
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

    public void talkGuard(){
        actualLocation = "townGate";

        mainTextArea.setText("Hello stranger! I have never seen your face, \nso I cannot let you in to our town. \n\nWhere are you from?");

        choice_1.setText("Attack The Guard");
        choice_2.setText("I'm from the Dark Woods");
        choice_3.setText("I'm new blacksmith's apprentice");
        choice_4.setText("Return to the woods");
    }

    public void meadow(){
        actualLocation = "meadow";

        mainTextArea.setText("You are in the woods that you came from.\n?");

        choice_1.setText("Go to the cave");
        choice_2.setText("Go to the river");
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

        mainTextArea.setText("You are lucky, that stupid goblin is unable to reach you there.");

        choice_1.setText("Try to comfort him");
        choice_2.setText("Leap off");
        if (equippedWeapon == "shortBow"){
            choice_3.setText("Attack");
        }
        choice_4.setVisible(false);
    }




}