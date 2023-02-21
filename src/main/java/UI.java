import javax.swing.*;
import java.awt.*;

public class UI {

    Game g;
    JFrame mainWindow;
    Container con;
    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel;
    JLabel titleLabel;
    JButton startButton, choice_1, choice_2, choice_3, choice_4;
    JTextArea mainTextArea;

    // creates new font for title with size - 90
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font headerFont = new Font("Times New Roman", Font.PLAIN, 60);

    private final int screenSizeX = 1000;
    private final int screenSizeY = 650;


    public UI(Game game){ //constructor
        g = game;
        mainWindow();
        titleScreen();
    }

    public void mainWindow(){
        mainWindow = new JFrame(); //creating new instance of JFrame
        mainWindow.setSize(screenSizeX, screenSizeY);
        mainWindow.getContentPane().setBackground(Color.BLACK);
        mainWindow.setVisible(true);
        mainWindow.setLayout(null); //disables default layout because I want to customize game layout
        con = mainWindow.getContentPane();
    }

    public void titleScreen(){
        int titlePanelWidth = 600;
        int titlePanelHeight = 150;
        int titlePanelStartX = (screenSizeX - titlePanelWidth) / 2;
        int titlePanelStartY = ((screenSizeY - titlePanelHeight) / 2 - 70);

        titlePanel = new JPanel();
        titlePanel.setBounds(titlePanelStartX, titlePanelStartY,
                titlePanelWidth, titlePanelHeight);
        titlePanel.setBackground(Color.black);

        // creates label with title name
        titleLabel = makeLabel(titleLabel, "ADVENTURE", titleFont, titlePanel);

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
        // when you click startButton it recognizes that click and calls g.handler
        makeButton(startButton, "START", startButtonPanel, "start");

        con.add(titlePanel); //adds title panel to display
        con.add(startButtonPanel); //adds start button panel to display
    }

    public void gameScreen(){
        //add main text Panel and main text area on it
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
        mainTextPanel.add(mainTextArea);

        //next choice button panel is to set up
        int choiceButtonPanelWidth = 600;
        int choiceButtonPaneHeight = 150;
        int choiceButtonPanePanelX = (screenSizeX - choiceButtonPanelWidth) / 2;
        int choiceButtonPanePanelY = screenSizeY - choiceButtonPaneHeight - 50;

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(choiceButtonPanePanelX, choiceButtonPanePanelY,
                choiceButtonPanelWidth, choiceButtonPaneHeight);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1)); // set grid layout on
        // that panel to 4 rows and 1 column that method takes object
        // from Class GridLayout as a parameter

        //now every single (4) choice button is added
        makeButton(choice_1,"Choice 1", choiceButtonPanel,"c1");
        makeButton(choice_2,"Choice 2", choiceButtonPanel,"c2");
        makeButton(choice_3,"Choice 3", choiceButtonPanel,"c3");
        makeButton(choice_4,"Choice 4", choiceButtonPanel,"c4");

        mainTextPanel.add(mainTextArea);
        con.add(mainTextPanel);
        con.add(choiceButtonPanel);
    }

    public JButton makeButton(JButton button, String name, JPanel panel, String action){
        button = new JButton(name);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setFont(normalFont);
        panel.add(button);
        button.addActionListener(g.handler);
        button.setActionCommand(action);
        return button;
    }

    public JLabel makeLabel(JLabel label, String name,Font font, JPanel panel){
        label = new JLabel(name);
        label.setForeground(Color.white);
        label.setFont(font);
        panel.add(label);
        return label;
    }
}
