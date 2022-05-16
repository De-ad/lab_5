package commands;

import util.CollectionManager;

/**
 *  Command 'Remove At Index'. Removes element at written index of collection.
 */

public class RemoveAtIndexCommand extends Command {
    private final CollectionManager collectionManager;

    public RemoveAtIndexCommand(CollectionManager collectionManager){
        super("remove_at index", "remove element at written index of " +
                "collection");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args) {
        try {
            int index = Integer.parseInt(args[0]);
            collectionManager.removeAtIndex(index);
        }
        catch (NumberFormatException e){
            System.out.println("Input should be a number");
        }
    }
}
