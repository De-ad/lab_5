package commands;

import util.CollectionManager;

/**
 *  Command 'Remove By Id'. Removes element from collection by its 'ID' field.
 */

public class RemoveByIdCommand extends Command {
    private final CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager){
        super("remove_by_id id", "remove element from collection by its id");
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
            collectionManager.removeById(id);
            System.out.println("Element was successfully deleted by ID");
        }
        catch (NumberFormatException e){
            System.out.println("ID should be a number");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("ID not written");
        }
    }
}
