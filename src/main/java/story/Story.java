package story;

import root.Game;
import root.Player;
import root.UI;
import root.VisibilityManager;

public class Story{
    Game g;
    UI ui;
    root.Utils ut;
    Player player;
    VisibilityManager vm;

    public String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public Story(Game game, UI ui, Player player, VisibilityManager vm, root.Utils ut){
        this.g = game;
        this.ui = ui;
        this.player = player;
        this.vm = vm;
        this.ut = ut;
    }

    public void choosePosition(String nextPosition){

        switch(nextPosition){
            case "crossroads": crossroads(); break;
            case "talkGuard": talkGuard(); break;
        }
    }

    public void crossroads() {
        vm.buttonVisibility(4);

        ui.mainTextArea.setText("After many days of long, exhausting journey \nyou finally went out of " +
                "the woods and noticed \nsmall town down the hill. \n\nEntry is guarded by armed man.");

        nextPosition1 = "talkGuard";

        ut.setChoices("Go to the entrance gate", "Go back to the woods",
                "Wait in the shadow, till the sun will go down", "Check if there is any other entrance");

        ut.setPositions("talkGuard", "", "", "");

    }


    public void talkGuard() {
        vm.buttonVisibility(3);

        ui.mainTextArea.setText("Hello stranger! I have never seen your face, " +
                "\nso I cannot let you in to our town. \n\nWhere are you from?");

        ui.choice_1.setText("Attack The Guard");
        ui.choice_2.setText("I'm new blacksmith's apprentice");
        ui.choice_3.setText("Return to the crossroads");
        if(player.ghoulTrophy){
            ui.choice_4.setVisible(true);
            ui.choice_4.setText("I have Ghoul's head.");
        }

    }
}
