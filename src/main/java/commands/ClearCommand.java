package commands;

import util.CollectionManager;

/**
 *  Command 'Clear'. Clears collection.
 */

public class ClearCommand extends Command {
    private final CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager){
        super("clear", "clear collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.clear();
    }
}
