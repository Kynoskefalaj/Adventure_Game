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

        ut.setText("After many days of long, exhausting journey you finally went out \nof " +
                "the woods and noticed small town down the hill. \n\nEntry is guarded by " +
                "armed man.");

        ut.setChoices("Go to the entrance gate", "talkGuard",
                "Go back to the woods", "",
                "Wait in the shadow, till the sun will go down", "",
                "Check if there is any other entrance", "");
    }


    public void talkGuard() {
        vm.buttonVisibility(3);

        ut.setText("Hello stranger! I have never seen your face, " +
        "\nso I cannot let you in to our town. \n\nWhere are you from?");

        ut.setChoices("Attack The Guard", "",
                "I'm new blacksmith's apprentice", "",
                "Return to the crossroads", "crossroads",
                "","");
        if(player.ghoulTrophy){
            ui.choice_4.setVisible(true);
            ui.choice_4.setText("I have Ghoul's head.");
            nextPosition4 = "";
        }
    }


    public void enterToTown() {
        vm.buttonVisibility(0);

        ui.mainTextArea.setText("Oh, You've beaten that scary monster!\n" +
                "All Rodentia people are grateful!\n" +
                "\n Welcome to our town!\n\n" +
                "You've completed Adventure. Congratulations!");
    }

    public void attackGuard() {
        vm.buttonVisibility(4);
        int guardHit = new java.util.Random().nextInt(4);

//        mainTextArea.setText("The guard dodges your attack and hit " +
//                "you back in the head causing " + guardHit + " damage.");
//        playerHP -= guardHit;
//        hpAmountLabel.setText("" + playerHP);
//
//
//        choice_1.setText("Attack The Guard");
//        choice_2.setText("I'm from the Dark Woods");
//        choice_3.setText("I'm new blacksmith's apprentice");
//        choice_4.setText("Return to the woods");
    }
}
