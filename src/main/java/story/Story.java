package story;

import armors.Armor_LeatherArmor;
import monsters.Monster_Ghoul;
import monsters.Monster_Goblin;
import monsters.Monster_TownGuard;
import root.*;
import weapons.Weapon_RustySword;
import weapons.Weapon_ShortBow;

import java.util.Objects;

public class Story{
    Game g;
    UI ui;
    Utils ut;
    Player player;
    VisibilityManager vm;
    Combat combat;

    //Monsters resp
    Monster_TownGuard townGuard = new Monster_TownGuard();
    Monster_Goblin goblin = new Monster_Goblin();
    Monster_Ghoul ghoul = new Monster_Ghoul();

    boolean tombAvailable;

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
            case "giantTree": giantTree(); break;
            case "goblin": goblin(); break;
            case "goblinAttack": goblinAttack(); combat.aliveCheck(); break;
            case "playerAttacksGoblin": playerAttacksGoblin();
                if (combat.monsterAliveCheck()) break;
                else goblinDown(); break;
            case "goblinDown": goblinDown(); break;
            case "giantRock": giantRock(); break;
            case "treeHouse": treeHouse(); break;
            case "theLetter": theLetter(); break;
            case "bed": bed(); break;
            case "theChest": theChest(); break;
            case "chestOpen": chestOpen(); break;
            case "theWindmill": theWindmill(); break;
            case "insideTheWindmill": insideTheWindmill(); break;
            case "theCorpse": theCorpse(); break;
            case "theCemetery": theCemetery(); break;
            case "theGrave": theGrave(); break;
            case "theShrine": theShrine(); break;
            case "prayer": prayer(); break;
            case "tomb": tomb(); break;
            case "tombUnlock": tombUnlock(); break;
            case "tomb1": if (ghoul.isAlive) tomb1();
                else tombCompleted(); break;
            case "tomb2": tomb2(); break;
            case "tomb3": tomb3(); break;
            case "tomb4": tomb4(); break;
            case "ghoul": ghoul(); break;
            case "ghoulAttack": ghoulAttack(); combat.aliveCheck(); break;
            case "playerAttacksGhoul": playerAttacksGhoul();
                if (combat.monsterAliveCheck()) break;
                else ghoulDown(); break;
            case "healthPotion": healthPotion(); break;
            case "ghoulDecapitation": ghoulDecapitation(); break;
            case "tombCompleted": tombCompleted(); break;
            case "enterToTown": enterToTown(); break;
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
                "I have Ghoul's head","enterToTown");
        ui.choice_4.setVisible(player.ghoulTrophy);
    }

    public void attackGuard() {
        vm.buttonVisibility(4);

        Combat combat = new Combat(ui, player, townGuard);
        int hit = combat.monsterHit();

        ut.setText(combat.monsterSound() + "\n\nThe guard dodges your attack and hit " +
                "you back in the head causing " + hit + " damage.");
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
        if (player.hp != player.stamina * 10) {
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
                "Attack", "goblinAttack",
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

    public void giantRock() {
        vm.buttonVisibility(2);

        ui.mainTextArea.setText("You are lucky, that stupid goblin is unable \nto " +
                "reach you there.\n\n" +
                "You've also found a rope.");
        player.rope = true;

        ut.setChoices("Leap off", "goblinAttack",
                "Attack", "goblinDown");
        if (Objects.equals(player.weapon.name, "Short Bow")) {
            ui.choice_2.setText("Attack");
        } else
            ui.choice_2.setVisible(false);
    }

    public void giantTree() {
        vm.buttonVisibility(3);

        ui.mainTextArea.setText("That Tree is really huge. When you look up you \n" +
                "see a treehouse hidden high in branches. \n\n" +
                "You cannot reach it without a rope.");

        ut.setChoices("Go to the cave", "theCave",
                "Go to the river", "river",
                "Go to the meadow", "meadow",
                "Climb up", "treeHouse");

        //very clever simplified if statement
        ui.choice_4.setVisible(player.rope);
    }

    public void treeHouse() {
        vm.buttonVisibility(4);

        ui.mainTextArea.setText("After a while you reached a tree house.\n" +
                "It is long way down.\n" +
                "The view from here is amazing. \nYou see a windmill a few miles away.\n\n" +
                " In this tiny house is nothing but the desk, bed and chest ");

        ut.setChoices("Look at the desk", "theLetter",
                "Open the chest", "theChest",
                "Go down", "giantTree",
                "Go to the windmill", "theWindmill");
    }

    public void theLetter() {
        vm.buttonVisibility(2);

        ui.mainTextArea.setText(" Dear Sam,\n" +
                "I know that I was supposed to wait for you " +
                "and don't go anywhere until you come back.\n" +
                "But my wound is going over and over to be worse. I think " +
                "I can't wait longer. I'm going to visit my \n" +
                "uncle in windmill north from here and take some medicines " +
                "from him. A bow is under bed");


        ut.setChoices("Look under the bed", "bed",
                "<", "treeHouse");
    }

    public void bed() {
        vm.buttonVisibility(1);

        ui.mainTextArea.setText("You have found a Short Bow!");
        player.weapon = new Weapon_ShortBow(true);
        player.update();

        ut.setChoices("<", "theLetter");
    }

    public void theChest() {
        vm.buttonVisibility(1);

        ui.mainTextArea.setText("The chest is locked. You can't open it without \n" +
                "a proper key.");

        ut.setChoices("<", "treeHouse",
                "Open", "chestOpen");

        //visibility of button 2 is dependent on player key
        ui.choice_2.setVisible(player.key);
    }

    public void chestOpen() {
        vm.buttonVisibility(1);
        player.armor = new Armor_LeatherArmor();
        player.update();
        ui.hudUpdate();

        ui.mainTextArea.setText("You've opened the chest with a key from windmill!\n" +
                "You have got nice and robust leather armor.");

        ut.setChoices("<", "treeHouse");
    }

    public void theWindmill() {
        vm.buttonVisibility(4);

       ui.mainTextArea.setText("After few hours you reached Windmill.\n" +
                "You see something here is wrong. \n\n" +
                "The doors leading to the mill are open...");

       ut.setChoices("Go in", "insideTheWindmill",
               "Go back to the cave", "the cave",
               "Return to the giant tree", "giantTree",
               "Return to the meadow", "meadow");
    }

    public void insideTheWindmill() {
        vm.buttonVisibility(3);

       ui.mainTextArea.setText("The view inside is horrible. Everything is in total mess.\n" +
                " You found ripped off upper part of human corpse. \n" +
                "Everything is in blood, but you clearly noticed there \n" +
                "is a track of blood leading outside by rear exit. ");

       ut.setChoices("Check the corpse", "theCorpse",
               "Go after the track of blood", "theCemetery",
               "Go back outside", "theWindmill");
    }

    public void theCorpse() {
        vm.buttonVisibility(1);
        player.key = true;

        player.healthPotions = 7;

        ui.mainTextArea.setText("It is total abomination..." +
                "\n ... but you've found a key.\n\n" +
                "And also " + player.healthPotions + " health potions.");

        ut.setChoices("<", "theWindmill");
    }

    public void theCemetery() {
        vm.buttonVisibility(4);

        ui.mainTextArea.setText("Track of blood led you to creepy cemetery deep in the woods.\n\n " +
                "There is a small shrine with priest statue. \n" +
                "Behind the statue is tomb with marble doors." +
                "It is getting late...\n\n" +
                "You've noticed that one grave is dug up.");

        ut.setChoices("Go to the tomb", "tomb",
                "Check the grave", "theGrave",
                "Check the statue", "theShrine",
                "Return to the mill", "theWindmill");
    }

    public void theGrave() {
        vm.buttonVisibility(1);

        ui.mainTextArea.setText("Here lies Edwyn Bones.\n\nRIP");

        ut.setChoices("<", "theCemetery");
    }

    public void theShrine() {
        vm.buttonVisibility(2);

        ui.mainTextArea.setText("When you came closer to the shrine you see clearly that" +
                "a priest represented by statue reach out his hand. His hand is the hand is arranged as " +
                "if it is holding something. Something is missing here.");

        ut.setChoices("<", "theCemetery",
                "Pray", "prayer",
                "Put a jewel in that hand", "tombUnlock");
        ui.choice_3.setVisible(player.gem);
    }

    public void prayer() {
        vm.buttonVisibility(1);

        player.stamina = 20;
        ui.mainTextArea.setText("Your prayer has been heard.\n" +
                "Your stamina increases to " + player.stamina + " and Health Points as well!!!");

        player.hp = player.stamina * 10;
        player.update();
        ui.hudUpdate();

        ut.setChoices("<", "theShrine");
    }

    public void tomb() {
        vm.buttonVisibility(3);

        ut.setChoices("Check the grave", "theGrave",
                "Check the shrine", "theShrine",
                "Return to the windmill", "theWindmill",
                "Enter", "tomb1");
        if (tombAvailable) {
            ui.mainTextArea.setText("The doors opened with heavy noise.\n" +
                    "You feel that something inside is dragging you there...");
            ui.choice_4.setVisible(true);

        } else {
           ui.mainTextArea.setText("The doors won't budge.");
        }
    }

    public void tombUnlock() {
       vm.buttonVisibility(2);
        tombAvailable = true;

        ui.mainTextArea.setText("Eureka! When you put the gem inside priest's hand," +
                "the doors leading to the Tomb opened.");

        ut.setChoices("Enter the tomb", "tomb",
                "Go to the windmill", "theWindmill");
    }

    public void tomb1() {
        vm.buttonVisibility(2);


       ui.mainTextArea.setText("You stepped inside cold, dark tomb.\n" +
                "You realised that you can't hear any noise from \ndown there.\n" +
                "Maybe it is a good sign?\n\nRight?");

       ut.setChoices("Go deeper", "tomb2",
               "Return to cemetery", "theCemetery");
    }

    public void tomb2() {
        vm.buttonVisibility(2);

        ui.mainTextArea.setText("It is getting darker and darker.");

        ut.setChoices("Go deeper", "tomb3",
                "Return to cemetery", "theCemetery");
    }

    public void tomb3() {
        vm.buttonVisibility(2);

       ui.mainTextArea.setText("Your eyes vision is slowly adapting \n" +
                "to that extreme darkness.");

        ut.setChoices("Go deeper", "tomb4",
                "Return to cemetery", "theCemetery");
    }

    public void tomb4() {
        vm.buttonVisibility(2);

        ui.mainTextArea.setText("On the end of dark corridor you noticed kind of...\n" +
                " move... \n\n" +
                "You see pale skin in the shadow.");

        ut.setChoices("Check", "ghoul",
                "Return to cemetery", "theCemetery");
    }

    public void ghoul() {
        vm.buttonVisibility(2);

        combat = new Combat(ui, player, ghoul);
        ui.mainTextArea.setText("AAAAAAAaaaaaaaaaaaaarrrrghhhhhhhhhhh!!!\n\n" +
                "You 've encountered a Ghoul!");

        ut.setChoices("Attack", "ghoulAttack",
                "Run", "theCemetery");
    }

    public void ghoulAttack() {
        vm.buttonVisibility(3);

        int hit = combat.monsterHit();

        player.update();
        ui.hudUpdate();

        ui.mainTextArea.setText(combat.monsterSound() + "\n\nGhoul attacks you !!!\n\n" +
                "You've lost " + hit + "health points.");

        ut.setChoices("Attack", "playerAttacksGhoul",
                "Use health potion", "Run");
    }

    public void playerAttacksGhoul() {
        vm.buttonVisibility(3);
        int hit = combat.playerHit();

        ui.mainTextArea.setText("Ghoul HP: " + combat.monster.hp + "\n" +
                "You attacked a Ghoul with your "
                + player.weapon.name + "\n\n" +
                "You've dealt " + hit + " damage to it.");

        ut.setChoices("Attack", "ghoulAttack",
                "Use health potion", "Run");
    }

    public void healthPotion() {
        vm.buttonVisibility(2);

        int healedHP = player.spirit * 3 + Math.abs(new java.util.Random().nextInt(player.spirit * 3));

        player.hp += healedHP;
        if(player.hp > player.stamina * 10){
            player.hp = player.stamina * 10;
        }
        player.update();
        player.healthPotions -= 1;


       ui.mainTextArea.setText("You are using one of your health potions.\n\n" +
                "You've healed " + healedHP + "health points.\n" +
                "You have " + (player.healthPotions - 1) + " health potions left.");

       ut.setChoices("Attack", "ghoulAttack",
                "Use health potion", "Run");
    }

    public void ghoulDown() {
        vm.buttonVisibility(3);

        ghoul.isAlive = false;

        ui.mainTextArea.setText("You did it!\n" +
                "People from town will be grateful for that!\n\n" +
                "You've looted 15 gold coins!");

        player.coins += 15;


        ut.setChoices("Cut off it's head", "ghoulDecapitation",
                "Use health potion", "healthPotion",
                "Exit", "tomb");
    }

    public void ghoulDecapitation() {
        vm.buttonVisibility(1);
        player.ghoulTrophy = true;

        ui.mainTextArea.setText("You cut off head of that monster.\n" +
                "Ghoul Trophy added to your inventory.");

        ut.setChoices("Exit", "theCemetery");
    }

    public void tombCompleted() {
        vm.buttonVisibility(1);

        ui.mainTextArea.setText("You've eliminated the threat down there\n" +
                "There is nothing else to do.");

        ut.setChoices("Exit", "theCemetery");
    }


}
