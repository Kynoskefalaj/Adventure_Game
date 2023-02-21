import javax.swing.*;
import java.awt.*;

public class UI {

    public static void main(String[] args) {
        new UI();
    }

    JFrame mainWindow;
    Container con;

    private final int screenSizeX = 1000;
    private final int screenSizeY = 650;

    public UI(){ //constructor

        mainWindow = new JFrame(); //creating new instance of JFrame
        mainWindow.setSize(screenSizeX, screenSizeY);
        mainWindow.getContentPane().setBackground(Color.BLACK);
        mainWindow.setVisible(true);
        mainWindow.setLayout(null); //disables default layout because I want to customize game layout
        con = mainWindow.getContentPane();
    }

}
