package monsters;
public class Monster_Goblin extends SuperMonster{

    public Monster_Goblin(){
        this.name = "Goblin";
        this.maxHP = 300;
        this.hp = maxHP;
        this.power = 10;
        this.isAlive = true;
        this.sounds[0] = "Grgrgrgl!";
        this.sounds[1] = "Me atacks!";
        this.sounds[2] = "Mahuhaha!";

    }

}
