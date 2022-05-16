package commands;

import util.CollectionManager;
import data.HumanBeing;

/**
 * Command 'Update By ID'. Updates value of element of the collection, which id is written.
 */

public class UpdateByIdCommand extends Command {
    private final CollectionManager collectionManager;

    public UpdateByIdCommand(CollectionManager collectionManager){
        super( "update id {element}", "update value of element of the collection, which id " +
                "is written");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args) {
        try{
            long id = Long.parseLong(args[0]);
            if(!collectionManager.checkID(id)){
                System.out.println("there's no element with such ID");
                return;
            }
            HumanBeing newHumanBeing = HumanBeing.input(collectionManager);
            if (collectionManager.updateById(id, newHumanBeing)){
                System.out.println("Element was successfully updated by ID");
            }
            else{
                System.out.println("there's no element with such ID");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("No ID entered");
        }
        catch (NumberFormatException e){
            System.out.println("ID should be a number");
        }
        catch (Exception e) {
            System.out.println("Critical error in user input");
        }
    }
}
