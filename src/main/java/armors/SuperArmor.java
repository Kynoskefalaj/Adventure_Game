package armors;

public class SuperArmor {
    public String name;
    public int armor;
    public boolean isEquipped = false;

    public void equipped(boolean isIt){
        isEquipped = isIt;
    }
}
