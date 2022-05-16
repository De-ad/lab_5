import java.io.*;
import java.util.Arrays;
import util.CollectionManager;
import util.IO;
import util.Invoker;

public class Main {

    /**
     * Programme's entry point.
     *
     * @param args
     */

    public static void main(String[] args) {
        final String CONSOLE_PRINT = "> ";
        try {
            if (args.length == 0){
                System.out.println("Filename is empty");
                System.exit(1);
            }
            Invoker invoker = Invoker.getInstance(args[0], new CollectionManager());
            invoker.execute("load", args);

            while (true) {
                System.out.print(CONSOLE_PRINT);
                String[] input = IO.getInput().trim().split("\\s+");
                String command = input[0];
                String[] arguments = Arrays.copyOfRange(input, 1, input.length);
                invoker.execute(command, arguments);
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No file selected");
        }
    }
}

