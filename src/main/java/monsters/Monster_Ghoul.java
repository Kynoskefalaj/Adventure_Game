package monsters;
public class Monster_Ghoul extends SuperMonster{

    public Monster_Ghoul(){
        this.name = "Ghoul";
        this.maxHP = 700;
        this.hp = maxHP;
        this.power = 20;
        this.isAlive = true;
        this.sounds[0] = "Coooorpse!";
        this.sounds[1] = "Aaaaaaaaarrrrgggggggghhhhhhhh!";
        this.sounds[2] = "Rak arak ragh!";
    }
}
