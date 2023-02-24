package weapons;

public class SuperWeapon {
    public String name;
    public int attack;
    public boolean isEquipped = false;

    public void equipped(boolean isIt){
        isEquipped = isIt;
    }
}
