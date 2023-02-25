package root;

public class VisibilityManager {
    UI ui;

    public VisibilityManager(UI userInterface){
        ui = userInterface;
    }

    public void titleToGame(){
        ui.titlePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
    }

    public void buttonVisibility(int i) {
        switch (i) {
            case 0:
                ui.choice_1.setVisible(false);
                ui.choice_2.setVisible(false);
                ui.choice_3.setVisible(false);
                ui.choice_4.setVisible(false);
                break;
            case 1:
                ui.choice_1.setVisible(true);
                ui.choice_2.setVisible(false);
                ui.choice_3.setVisible(false);
                ui.choice_4.setVisible(false);
                break;
            case 2:
                ui.choice_1.setVisible(true);
                ui.choice_2.setVisible(true);
                ui.choice_3.setVisible(false);
                ui.choice_4.setVisible(false);
                break;
            case 3:
                ui.choice_1.setVisible(true);
                ui.choice_2.setVisible(true);
                ui.choice_3.setVisible(true);
                ui.choice_4.setVisible(false);
                break;
            case 4:
                ui.choice_1.setVisible(true);
                ui.choice_2.setVisible(true);
                ui.choice_3.setVisible(true);
                ui.choice_4.setVisible(true);
                break;
        }
    }
}