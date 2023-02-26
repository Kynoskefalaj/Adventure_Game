package root;

import armors.Armor_WornJacket;
import armors.SuperArmor;
import weapons.SuperWeapon;
import weapons.Weapon_Knife;

public class Player {
    public boolean rope, key, leatherArmor, gem, ghoulTrophy;
    public int hp, power, protection, spirit, strength, stamina, coins;
    public SuperWeapon weapon;
    public SuperArmor armor;

    public Player(){
        stamina = 10;
        hp = stamina * 10;
        coins = 0;
        spirit = 7;
        strength = 4;



        weapon = new Weapon_Knife(true);
//        weapon.equipped(true);

        armor = new Armor_WornJacket();
        armor.equipped(true);

        update();

        rope = false;
        key = false;
        leatherArmor = false;
        gem = false;
        ghoulTrophy = false;
    }

    public void update(){
        protection = armor.armor;
        power = weapon.attack;

    }


}
