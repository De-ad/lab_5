package data;

import util.IO;

import java.util.Locale;

/**
 * enum of weapon types
 */

public enum WeaponType {
    AXE,
    SHOTGUN,
    RIFLE,
    KNIFE,
    BAT;

    /**
     * Show enum
     * @return nameList
     */
    public static String nameList() {
        StringBuilder nameList = new StringBuilder();
        for (WeaponType weaponTypes: values()) {
            nameList.append(weaponTypes.name()).append(", ");
        }
        return nameList.substring(0, nameList.length() - 2);
    }

    /**
     * Set weapon type from input
     * @return input
     */
    public static WeaponType input(){
        System.out.println("Weapon types list: " + WeaponType.nameList());
        System.out.println("Choose weapon type: ");
        try{
            String inp = IO.getInput().trim().toUpperCase(Locale.ROOT);
            WeaponType weaponType = WeaponType.valueOf(inp);
            return weaponType;
        }
        catch (IllegalArgumentException e){
            System.out.println("No such element");
            return WeaponType.input();
        }
    }
}
