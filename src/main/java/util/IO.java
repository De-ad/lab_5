package util;

import java.io.*;
import java.util.Scanner;

public class IO {
    private static inputMode mode = inputMode.CONSOLE;
    private static Scanner consoleScanner = new Scanner(System.in);
    private static Scanner fileScanner;
    private static String fileName;

    /**
     * Gets input from user
     * @return string
     */

    public static String getInput() {
        if (mode == inputMode.CONSOLE) {
//            Scanner scanner = new Scanner(System.in);
            while(consoleScanner.hasNext()){
                return consoleScanner.nextLine();
            }

            consoleScanner.close();
            System.out.println("program terminated");
            System.exit(1);

//            String args = "123";
//            String[] args1 = new String[1];
//            Invoker invoker = Invoker.getInstance(args, new CollectionManager());
//            invoker.execute("exit", args1);
            return "";
        }
        else{
            try {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream((fileName))));
//                Scanner scanner = new Scanner(new FileInputStream(fileName));
                if (fileScanner.hasNextLine()) {
                    return fileScanner.nextLine();
                }
                changeMod("");
                return IO.getInput();
            } catch (Exception e) {
                System.out.println("IO error");
                changeMod("");
                return "";
            }
        }

    }


    public static void changeMod(String file) {
        if (mode == inputMode.CONSOLE){
            mode = inputMode.FILE;
            fileName = file;
            try {
                fileScanner = new Scanner(new FileInputStream(fileName));
            }
            catch (Exception ignored) {}
        }
        else{
            mode = inputMode.CONSOLE;
            fileName = "";
            fileScanner.close();
        }
    }

    enum inputMode{
        CONSOLE,
        FILE
    }


}
