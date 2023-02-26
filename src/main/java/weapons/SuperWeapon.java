package weapons;

public class SuperWeapon {
    public String name;
    public int attack;
    public boolean isEquipped = false;

    public SuperWeapon(boolean isEquipped){
        this.isEquipped = isEquipped;
    }

    public void equipped(boolean isIt){
        isEquipped = isIt;
    }
}
