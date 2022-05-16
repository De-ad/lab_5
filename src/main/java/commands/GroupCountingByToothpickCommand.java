package commands;

import util.CollectionManager;

/**
 *  Command 'Group Counting By Toothpick'. Groups up elements of collection by value of field
 *  'hasToothPick', shows number of elements in each group.
 */

public class GroupCountingByToothpickCommand extends Command {
    private final CollectionManager collectionManager;


    public GroupCountingByToothpickCommand(CollectionManager collectionManager){
        super("group_counting_by_has_toothpick", "group up elements of collection by value of field " +
                "hasToothPick, show number of elements in each group");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println(collectionManager.groupCountingByToothpick());
    }
}
