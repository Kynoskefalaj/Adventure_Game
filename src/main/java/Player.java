import armors.Armor_WornJacket;
import armors.SuperArmor;
import weapons.SuperWeapon;
import weapons.Weapon_Knife;

public class Player {
    public int hp, power, protection, spirit, strength, stamina, coins;
    public SuperWeapon weapon;
    public SuperArmor armor;

    public Player(){
        stamina = 100;
        hp = stamina;
        coins = 0;
        spirit = 7;
        strength = 4;

        weapon = new Weapon_Knife();
        weapon.equipped(true);

        armor = new Armor_WornJacket();
        armor.equipped(true);
    }

}
