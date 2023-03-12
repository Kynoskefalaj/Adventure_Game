package root;

public class Utils {
    UI ui;
    Game game;

    Utils(UI ui, Game game){
        this.ui = ui;
        this.game = game;
    }

    public void setChoices(String text1, String next1){
        ui.choice_1.setText(text1); game.nextPosition[0] = next1;
    }

    public void setChoices(String text1, String next1,
                           String text2, String next2){
        ui.choice_1.setText(text1); game.nextPosition[0] = next1;
        ui.choice_2.setText(text2); game.nextPosition[1] = next2;
    }

    public void setChoices(String text1, String next1,
                           String text2, String next2,
                           String text3, String next3){
        ui.choice_1.setText(text1); game.nextPosition[0] = next1;
        ui.choice_2.setText(text2); game.nextPosition[1] = next2;
        ui.choice_3.setText(text3); game.nextPosition[2] = next3;
    }

    public void setChoices(String text1, String next1,
                           String text2, String next2,
                           String text3, String next3,
                           String text4, String next4){
        ui.choice_1.setText(text1); game.nextPosition[0] = next1;
        ui.choice_2.setText(text2); game.nextPosition[1] = next2;
        ui.choice_3.setText(text3); game.nextPosition[2] = next3;
        ui.choice_4.setText(text4); game.nextPosition[3] = next4;
    }

    public String[] setPositions(String first, String second, String third, String fourth){
        game.nextPosition[0] = first;
        game.nextPosition[1] = second;
        game.nextPosition[2] = third;
        game.nextPosition[3] = fourth;
        return game.nextPosition;
    }

    public void setText(String text){
        ui.mainTextArea.setText(text);
    }

}
