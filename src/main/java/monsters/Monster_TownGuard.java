package monsters;

public class Monster_TownGuard extends SuperMonster{

    String[] sound = {"How you dare you filthy bastard?!",
            "For Rodentia!",
            "Die peasant!"};

    public Monster_TownGuard() {
        this.name = "Town Guard";
        this.maxHP = 300;
        this.hp = maxHP;
        this.power = 10;
        this.isAlive = true;
    }
}
