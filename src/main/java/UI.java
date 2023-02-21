import javax.swing.*;
import java.awt.*;

public class UI {

    Game g;
    JFrame mainWindow;
    Container con;
    JPanel titlePanel, startButtonPanel;
    JLabel titleLabel;
    JButton startButton;

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
        startButton.addActionListener(g.handler); // when you click startButton
        // it recognizes that click and calls g.handler
        startButton.setActionCommand("start");

        titlePanel.add(titleLabel); // adds title label on title panel
        startButtonPanel.add(startButton); //adds start button on button panel

        con.add(titlePanel); //adds title panel to display
        con.add(startButtonPanel); //adds start button panel to display
    }

}
