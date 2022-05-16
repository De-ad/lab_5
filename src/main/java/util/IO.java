package util;

import java.io.*;
import java.util.Scanner;

public class IO {
    private static inputMode mode = inputMode.CONSOLE;
    private static String fileName;

    /**
     * Gets input from user
     * @return string
     */

    public static String getInput() {
        if (mode == inputMode.CONSOLE) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                return scanner.nextLine();
            }
            scanner.close();
            System.out.println("program terminated");
            String args = "123";
            String[] args1 = new String[1];
            Invoker invoker = Invoker.getInstance(args, new CollectionManager());
            invoker.execute("exit", args1);
            return "";
        }
        else{
            try {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream((fileName))));
                Scanner scanner = new Scanner(new FileInputStream(fileName));
                while (scanner.hasNextLine()) {
                    return scanner.nextLine();
                }
                scanner.close();
                return "";
            } catch (IOException e) {
                System.out.println("IO error");
                return "";
            }
        }

    }


    public static void changeMod(String file){
        if (mode == inputMode.CONSOLE){
            mode = inputMode.FILE;
        }
        else{
            mode = inputMode.CONSOLE;
            fileName = file;
        }
    }

    enum inputMode{
        CONSOLE,
        FILE
    }


}
