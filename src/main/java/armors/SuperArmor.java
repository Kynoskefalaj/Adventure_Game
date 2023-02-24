package armors;

public class SuperArmor {
    String name;
    int armor;
    boolean isEquipped = false;

    public void equipped(boolean isIt){
        isEquipped = isIt;
    }
}
