package story;

import monsters.Monster_Ghoul;
import monsters.Monster_Goblin;
import monsters.Monster_TownGuard;
import root.*;
import weapons.Weapon_RustySword;

public class Story{
    Game g;
    UI ui;
    root.Utils ut;
    Player player;
    VisibilityManager vm;
    Combat combat;

    //Monsters resp
    Monster_TownGuard townGuard = new Monster_TownGuard();
    Monster_Goblin goblin = new Monster_Goblin();
    Monster_Ghoul ghoul = new Monster_Ghoul();

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
            case "attackGuard": attackGuard(); break;
            case "meadow": meadow(); break;
            case "river": river(); break;
            case "swimming": swimming(); break;
            case "theCave": theCave(); break;
            case "giantTree": break;
            case "goblin": goblin(); break;
            case "goblinAttack": goblinAttack(); break;
            case "playerAttacksGoblin": playerAttacksGoblin();break;
            case "giantRock": break;
            case "goblinDown": break;

        }
    }

    public void crossroads() {
        vm.buttonVisibility(4);

        ut.setText("After many days of long, exhausting journey you finally went out \nof " +
                "the woods and noticed small town down the hill. \n\nEntry is guarded by " +
                "armed man.");

        ut.setChoices("Go to the entrance gate", "talkGuard",
                "Go back to the woods", "meadow",
                "Wait in the shadow, till the sun will go down", "",
                "Check if there is any other entrance", "");
    }


    public void talkGuard() {
        vm.buttonVisibility(3);

        ut.setText("Hello stranger! I have never seen your face, " +
        "\nso I cannot let you in to our town. \n\nWhere are you from?");

        ut.setChoices("Attack The Guard", "attackGuard",
                "I'm new blacksmith's apprentice", "",
                "Return to the crossroads", "crossroads",
                "","");
        if(player.ghoulTrophy){
            ui.choice_4.setVisible(true);
            ui.choice_4.setText("I have Ghoul's head.");
            nextPosition4 = "";
        }
    }

    public void attackGuard() {
        vm.buttonVisibility(4);

        Combat combat = new Combat(ui, player, townGuard);
        combat.monsterHit();

        ut.setText(combat.monsterSound() + "\n\nThe guard dodges your attack and hit " +
                "you back in the head causing " + combat.monsterHit() + " damage.");
        combat.aliveCheck();

        ut.setChoices("Attack The Guard again", "attackGuard",
                "I'm form the Dark Woods", "",
                "I'm new blacksmith apprentice", "",
                "Return to meadow", "meadow");

    }

    public void enterToTown() {
        vm.buttonVisibility(0);

        ui.mainTextArea.setText("Oh, You've beaten that scary monster!\n" +
                "All Rodentia people are grateful!\n" +
                "\n Welcome to our town!\n\n" +
                "You've completed Adventure. Congratulations!");
    }

    public void meadow() {
        vm.buttonVisibility(4);
        ui.mainTextArea.setText("You are in the woods that you came from.");

        ut.setChoices("Go to the cave", "theCave",
                "Go to the river", "river",
                "Go to the giant tree", "giantTree",
                "Go to the crossroads", "crossroads");
    }

    public void river() {
        vm.buttonVisibility(4);
        int restoredHP = new java.util.Random().nextInt(40);
        player.hp += restoredHP;
        if (player.hp > player.stamina * 10) {
            player.hp = player.stamina * 10;
        }
        ui.hudUpdate();

        //In the future add class Healing
        if (player.hp != player.stamina) {
            ui.mainTextArea.setText("You came to the river bank and drink water by your hands.\n" +
                    "Your health is restored by " + restoredHP + ".");
        } else {
            ui.mainTextArea.setText("You came to the river bank and drink water by your hands.\n" +
                    "Your health is fully restored.");
        }

        ut.setChoices("Hop in to the water", "swimming",
                "Drink more", "river",
                "Go to the giant tree", "giantTree",
                "Go to the crossroads", "crossroads");
    }

    public void swimming() {
        vm.buttonVisibility(4);

        player.weapon = new Weapon_RustySword(true);
        player.update();
        ui.hudUpdate();

        ui.mainTextArea.setText("While swimming you found something shiny in the water.\n" +
                "You decided to dive down to get that. \n" +
                "You have found Rusty Sword!");

        ut.setChoices("Go to the cave", "theCave",
                "Go to the river bank", "river",
                "Go to the giant tree", "giantTree",
                "Go to the meadow", "meadow");
    }

    public void theCave() {
        vm.buttonVisibility(4);

        ui.mainTextArea.setText("When you came closer to the cave you can smell \n" +
                "that something inside horribly stinks.");

        ut.setChoices("Go in", "goblin",
                "Go to the river", "river",
                "Go to the giant tree", "giantTree",
                "Go to the meadow", "meadow");
    }

    public void goblin() {
        vm.buttonVisibility(4);
        if (goblin.isAlive) {
            ui.mainTextArea.setText("You encountered horrifying, mad Goblin!");

            //initializes combat mode (instance)
            combat = new Combat(ui, player, goblin);

            ut.setChoices("Try to comfort him", "goblinAttack",
                    "Attack", "playerAttacksGoblin",
                    "Run", "theCave",
                    "Climb on giant rock", "giantRock");
        } else {
            goblinDown();
        }
    }

    public void goblinDown() {
        vm.buttonVisibility(4);
        player.gem = true;
        goblin.isAlive = false;

        ui.mainTextArea.setText("You've beat this filthy creature! " +
                "\n\nYou obtained large shiny gem!");

        ut.setChoices("Go to giant tree", "giantTree",
                "Go to the river bank", "river",
                "Go out to the cave", "theCave",
                "Climb on giant rock", "giantRock");
    }

    public void playerAttacksGoblin() {
        vm.buttonVisibility(4);

        int hit = combat.playerHit();
        goblin.hp -= hit;

        ui.mainTextArea.setText("Goblin health: " + goblin.hp +
                "\n\nYou attack your opponent with " + player.weapon.name + "\n" +
                "Goblin lost " + hit + " health points!");

        ut.setChoices("Try to comfort him", "goblinAttack",
                "Attack", "playerAttacksGoblin",
                "Run", "theCave",
                "Climb on giant rock", "giantRock");
    }

    public void goblinAttack() {
        vm.buttonVisibility(4);
        int hit = combat.monsterHit();
        player.hp -= hit;
        player.update();
        ui.hudUpdate();

        ui.mainTextArea.setText(combat.monsterSound() + "\n\nGoblin health: " + goblin.hp +
                "\n\nGoblin attacks you with loud shout! \n" +
                "You lost " + hit + " health points!");

        ut.setChoices("Try to comfort him", "goblinAttack",
                "Attack", "playerAttacksGoblin",
                "Run", "theCave",
                "Climb on giant rock", "giantRock");
    }
}
