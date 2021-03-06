package commands;

import util.CollectionManager;
import data.HumanBeing;

/**
 *  Command 'Add Element'. Adds new element to collection.
 */

public class AddElementCommand extends Command {
    private final CollectionManager collectionManager;

    public AddElementCommand(CollectionManager collectionManager){
        super("add {element}", "add new element to collection");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String args[]){
        try{
        HumanBeing humanBeing = HumanBeing.input(collectionManager);
        collectionManager.addElement(humanBeing);
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Error in input");
        }
    }
}
