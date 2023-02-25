package root;

import story.Story;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    UniversalHandler handler = new UniversalHandler();
    Player player = new Player();
    UI ui = new UI(this, player);
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, player, vm);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;


    public static void main(String[] args) {
        new Game();
    }

    public Game(){ }//constructor}

    public class UniversalHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start": vm.titleToGame();
                    ui.gameScreen();
                    story.crossroads(); break;
                case "c1": story.choosePosition(nextPosition1); break;
                case "c2": story.choosePosition(nextPosition2); break;
                case "c3": story.choosePosition(nextPosition3); break;
                case "c4": story.choosePosition(nextPosition4); break;
                case "stats": ui.createStatsScreen(); break;
                case "statsReturn": ui.returnToGame(); break;
            }
        }
    }
}
