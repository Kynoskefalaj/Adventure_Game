package root;

import monsters.SuperMonster;

public class Combat {

    UI ui;
    SuperMonster monster;
    Player player;
    int playerHP;
    int playerHit, monsterHit;

    // Constructor
    public Combat(UI ui, Player player, SuperMonster monster){
        this.ui = ui;
        this.player = player;
        this.monster = monster;
        playerHP = this.player.hp;
    }

    public String monsterSound(){
        int soundIndex = new java.util.Random().nextInt(monster.sounds.length);
        return monster.sounds[soundIndex];
    }

    public int playerHit(){
        playerHit = critMultiplier() *
                (player.strength + new java.util.Random().nextInt(player.power + 1));
        monster.hp -= playerHit;
        return playerHit;
    }

    public int monsterHit(){
        monsterHit = Math.abs(player.protection - new java.util.Random().nextInt(monster.power + 1));
        playerHP -= monsterHit;
        //actualizes player HP
        player.hp = playerHP;

        ui.hudUpdate();
        return monsterHit;
    }

    public int critMultiplier(){
        //crit will be committed when critRolledValue take 10th number
        // (it is 9 when we count from 0)
        int critRolledValue = Math.abs(new java.util.Random().nextInt(10));
        if (critRolledValue == 9){
            ui.mainTextArea.setText("Critical hit!\n" +
                    "You've dealt " + playerHit + "damage.");
            return 3;
        }
        else
            return 1;
    }

    public void death() {

        ui.mainTextArea.setText("You are dead.\n\nGAME OVER!");
//        ui.mainTextArea.setHorizontalAlignment(JTextArea.CENTER)

        ui.choice_1.setVisible(false);
        ui.choice_2.setVisible(false);
        ui.choice_3.setVisible(false);
        ui.choice_4.setVisible(false);
    }

    public void aliveCheck(){
        if (playerHP < 0)
            death();
    }

    public void monsterAliveCheck(){
        if (monster.hp < 0)
            death();
    }

}
