package commands;

import util.CollectionManager;

/**
 *  Command 'Info'. Shows in standard output info about collection (type, date of initialization,
 *  number of element, etc.
 */

public class InfoCommand extends Command {
    private final CollectionManager collectionManager;


    public InfoCommand(CollectionManager collectionManager){
        super("info", "show in standard output info about collection (type, date of initialization, " +
                "number of element, etc.");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args) {
        collectionManager.info();
    }
}
