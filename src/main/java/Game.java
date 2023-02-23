import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    UniversalHandler handler = new UniversalHandler();
    Player player = new Player();
    UI ui = new UI(this, player);
    VisibilityManager vm = new VisibilityManager(ui);


    public static void main(String[] args) {
        new Game();
    }

    public Game(){ //constructor
    }

    public class UniversalHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start": vm.titleToGame(); ui.gameScreen(); break;
                case "c1": break;
                case "c2": break;
                case "c3": break;
                case "c4": break;
                case "stats": ui.createStatsScreen(); break;
                case "statsReturn": ui.returnToGame(); break;
            }
        }
    }
}
