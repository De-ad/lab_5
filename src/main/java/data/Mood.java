package data;

import util.IO;
import java.util.Locale;

/**
 * enum of moods
 */

public enum Mood {
    LONGING,
    GLOOM,
    APATHY,
    CALM;

    /**
     * Show enum
     * @return
     */

    public static String nameList() {
        StringBuilder nameList = new StringBuilder();
        for (Mood moods: values()) {
            nameList.append(moods.name()).append(", ");
        }
        return nameList.substring(0, nameList.length() - 2);
    }
    /**
     * Set mood from input
     * @return input
     */

    public static Mood input(){
        System.out.println("Mood types list: "+ Mood.nameList());
        System.out.println("Choose mood type: ");
        try{
            String inp = IO.getInput().trim().toUpperCase(Locale.ROOT);
            Mood mood= Mood.valueOf(inp);
            return mood;
        }
        catch (IllegalArgumentException e){
            System.out.println("No such element");
            return Mood.input();
        }
    }
}



