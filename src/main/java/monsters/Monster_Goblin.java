package monsters;
public class Monster_Goblin extends SuperMonster{

    String[] sound = {"Grgrgrgl!",
            "Me atacks!",
            "Mahuhaha!"};

    public Monster_Goblin(){
        this.name = "Goblin";
        this.maxHP = 300;
        this.hp = maxHP;
        this.power = 10;
        this.isAlive = true;
    }

}
