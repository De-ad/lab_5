package commands;

import util.CollectionManager;

/**
 *  Command 'Show'. Shows in standard output all elements of collection in string presentation.
 */

public class ShowCommand extends Command {
    private final CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager){
        super("show","show in standard output all elements of collection in string presentation");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.show();
    }
}
