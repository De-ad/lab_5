package util;

import commands.*;
import java.util.HashMap;


/**
 *  Invoker class as singleton
 */

public class Invoker {
    private static Invoker invoker;
    private final HashMap<String, Command> commandMap = new HashMap<>();

    private Invoker(){
    }

    private Invoker(String file, CollectionManager collectionManager){
        commandMap.put("help", new HelpCommand());
        commandMap.put("load", new LoadCommand(file, collectionManager));
        commandMap.put("info", new InfoCommand(collectionManager));
        commandMap.put("show", new ShowCommand(collectionManager));
        commandMap.put("add", new AddElementCommand(collectionManager));
        commandMap.put("update_id", new UpdateByIdCommand(collectionManager));
        commandMap.put("remove_by_id", new RemoveByIdCommand(collectionManager));
        commandMap.put("clear", new ClearCommand(collectionManager));
        commandMap.put("save", new SaveCommand(file, collectionManager));
        commandMap.put("execute_script", new ExecuteFileScriptCommand(file, collectionManager));
        commandMap.put("exit", new ExitCommand());
        commandMap.put("remove_at", new RemoveAtIndexCommand(collectionManager));
        commandMap.put("add_if_max", new AddIfMaxCommand(collectionManager));
        commandMap.put("reorder", new ReorderCommand(collectionManager));
        commandMap.put("remove_all_by_weapon_type", new RemoveAllByWeaponCommand(collectionManager));
        commandMap.put("average_of_impact_speed", new AverageOfImpactSpeedCommand(collectionManager));
        commandMap.put("group_counting_by_has_toothpick", new GroupCountingByToothpickCommand(collectionManager));
    }

    public static Invoker getInstance(String fileName, CollectionManager collectionManager){
        if (invoker == null) {
            return new Invoker(fileName, collectionManager);
        }
        return invoker;
    }

    public void execute(String commandName, String[] args) {
        commandName = commandName.toLowerCase();
        try {
            commandMap.get(commandName).execute(args);
        }
        catch (NullPointerException e){
            System.out.println("There's no such command as " + commandName);
        }
    }
}
