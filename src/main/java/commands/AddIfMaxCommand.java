package commands;

import util.CollectionManager;
import data.HumanBeing;

/**
 *  Command 'Add If Max'. Adds new element to collection, if its value exceeds value of the
 *  max element of this collection.
 */

public class AddIfMaxCommand extends Command {
    private final CollectionManager collectionManager;

    public AddIfMaxCommand(CollectionManager collectionManager){
        super("add_if_max {element}", "add new element to collection if its value exceeds value of the" +
                "max element of this collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        try {
            HumanBeing humanBeing = HumanBeing.input(collectionManager);
            if (collectionManager.addIfMax(humanBeing)){
                System.out.println("Element added");
                collectionManager.addElement(humanBeing);
            }
            else{
                System.out.println("there's max element with such name value or larger");
            }
        }
        catch(Exception e){
            System.out.println("Error with input");
        }
    }
}
