package commands;

import util.CollectionManager;

import java.io.*;

/**
 *  Command 'Save'. Saves collection in file.
 */

public class SaveCommand extends Command {
    private final CollectionManager collectionManager;
    private String fileName;

    public SaveCommand(String fileName, CollectionManager collectionManager){
        super("save", "save collection in file");
        this.collectionManager = collectionManager;
        this.fileName = fileName;
    }


    @Override
    public void execute(String[] args) {
        collectionManager.writeCSV(fileName);
        System.out.println("Collection saved in " + fileName);
    }
}
