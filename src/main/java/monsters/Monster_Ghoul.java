package monsters;
public class Monster_Ghoul extends SuperMonster{

    String[] sounds = {"Coooorpse!",
            "Aaaaaaaaarrrrgggggggghhhhhhhh!",
            "Rak arak ragh!"};

    public Monster_Ghoul(){
        this.name = "Ghoul";
        this.maxHP = 700;
        this.hp = maxHP;
        this.power = 20;
        this.isAlive = true;
    }
}
