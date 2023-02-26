package monsters;

public class Monster_TownGuard extends SuperMonster{

    String[] sounds = {"How you dare you filthy bastard?!",
            "For Rodentia!",
            "Die peasant!"};

    public Monster_TownGuard() {
        this.name = "Town Guard";
        this.maxHP = 1000;
        this.hp = maxHP;
        this.power = 35;
        this.isAlive = true;
    }
}
