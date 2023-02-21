import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    UniversalHandler handler = new UniversalHandler();
    UI ui = new UI(this);
    VisibilityManager vm = new VisibilityManager(ui);

    public static void main(String[] args) {
        new Game();
    }

    public Game(){ //constructor
        VisibilityManager vm = new VisibilityManager(ui);
    }

    public class UniversalHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start": vm.titleToGame();
                case "c1":;
                case "c2":;
                case "c3":;
                case "c4":;
            }
        }
    }
}
