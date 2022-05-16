package commands;


import data.WeaponType;
import util.CollectionManager;

/**
 *  Command 'Remove All By Weapon'. Deletes from collection all elements which value
 *  of the field 'weaponType' equals written.
 */

public class RemoveAllByWeaponCommand extends Command {
    private final CollectionManager collectionManager;


    public RemoveAllByWeaponCommand(CollectionManager collectionManager){
        super("remove_all_by_weapon_type weaponType", "delete from collection all elements which value " +
                "of the field weaponType equals written");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
            WeaponType weaponType = WeaponType.input();
            collectionManager.removeAllByWeapon(weaponType);
    }
}
