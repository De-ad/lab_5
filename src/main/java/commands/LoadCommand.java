package commands;

import util.CollectionManager;


/**
 * Command 'LoadCommand'. Parses file with collection
 */
public class LoadCommand extends Command{
    private final CollectionManager collectionManager;
    private final String fileName;

    public LoadCommand(String fileName, CollectionManager collectionManager){
        super("load", "parse file with collection");
        this.collectionManager = collectionManager;
        this.fileName = fileName;
    }


    @Override
    public void execute(String[] args){
        try {
            CollectionManager.parse(fileName);
            collectionManager.updateIdCounter();
            return;
        }
        catch(Exception e){
            System.out.println("Wrong data in file");
            return;
        }

    }
}
