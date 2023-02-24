package weapons;

public class SuperWeapon {
    String name;
    int attack;
    boolean isEquipped = false;

    public void equipped(boolean isIt){
        isEquipped = isIt;
    }
}
