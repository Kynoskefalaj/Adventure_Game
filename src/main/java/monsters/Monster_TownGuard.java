package monsters;

public class Monster_TownGuard extends SuperMonster{

    public Monster_TownGuard() {
        this.name = "Town Guard";
        this.maxHP = 1000;
        this.hp = maxHP;
        this.power = 35;
        this.isAlive = true;
        this.sounds[0] = "How you dare you filthy bastard?!";
        this.sounds[1] = "For Rodentia!";
        this.sounds[2] = "Die peasant!";

    }
}
