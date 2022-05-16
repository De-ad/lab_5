package commands;

import util.CollectionManager;

/**
 *  Command 'Reorder'. Sorts collection in order reversed to current.
 */

public class ReorderCommand extends Command {
    private final CollectionManager collectionManager;


    public ReorderCommand(CollectionManager collectionManager){
        super("reorder", "sort collection in order reversed to current");
        this.collectionManager = collectionManager;

    }

    @Override
    public void execute(String[] args) {
        collectionManager.order();
        collectionManager.reorder();
    }
}
