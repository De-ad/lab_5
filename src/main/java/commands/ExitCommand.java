package commands;

/**
 *  Command 'Exit'. Ends programme (without saving in file).
 */

public class ExitCommand extends Command {

    public ExitCommand(){
        super("exit", "end programme (without saving in file)");
    }

    @Override
    public void execute(String[] args) {
        System.exit(0);
    }
}
