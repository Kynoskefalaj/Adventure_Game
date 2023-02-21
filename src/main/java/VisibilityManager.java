public class VisibilityManager {
    UI ui;

    public VisibilityManager(UI userInterface){
        ui = userInterface;
    }

    public void titleToGame(){
        ui.titlePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
    }
}