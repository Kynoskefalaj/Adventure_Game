package root;

public class Utils {
    UI ui;
    Game game;
    Utils(UI ui, Game game){
        this.ui = ui;
        this.game = game;
    }

    public void setChoices(String text1, String text2, String text3, String text4){
        ui.choice_1.setText(text1);
        ui.choice_2.setText(text2);
        ui.choice_3.setText(text3);
        ui.choice_4.setText(text4);
    }

    public String[] setPositions(String first, String second, String third, String fourth){
        game.nextPosition[0] = first;
        game.nextPosition[1] = second;
        game.nextPosition[2] = third;
        game.nextPosition[3] = fourth;
        return game.nextPosition;
    }

}
