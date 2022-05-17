package util;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import data.HumanBeing;
import data.HumanBeingComp;
import data.WeaponType;
import java.io.*;
import java.util.Collections;
import java.time.ZonedDateTime;
import java.util.Vector;
import java.util.List;

/**
 * Collection Manager class. Works as a Receiver
 */

public class CollectionManager {
    private InputStream input;
    private BufferedReader reader;
    ZonedDateTime initTime = ZonedDateTime.now();
    static Vector<HumanBeing> humanBeings;
    private static long CounterID = 1;
    HumanBeingComp comp = new HumanBeingComp();

    public CollectionManager(){
        CollectionManager.humanBeings = new Vector<>();
    }

    public static void parse(String fileName){
        try{
            List <HumanBeing> humanBeingsList = new CsvToBeanBuilder(new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName)
                    )))
                    .withType(HumanBeing.class)
                    .build()
                    .parse();
            for (HumanBeing humanBeing : humanBeingsList){
                humanBeing.validate(humanBeing);
            }
            CollectionManager.humanBeings = new Vector<>(humanBeingsList);
            System.out.println("Collection was parsed from file");
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        catch (Exception e){
            System.out.println("Wrong data in file");
            System.exit(1);
        }
    }

    public void writeCSV(String fileName){
        try {
            Writer writer = new FileWriter(fileName);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(CollectionManager.humanBeings);
            writer.close();
        }
        catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e){
            System.out.println("IO error");
        }
    }


    public long getId(){
        return CounterID++;
    }

    public static void addElement(HumanBeing humanBeing){
        humanBeings.add(humanBeing);
        System.out.println("Element was added");
    }

    public boolean addIfMax(HumanBeing newHumanBeing){
        for (HumanBeing humanBeing:humanBeings){
            if(humanBeing.getName().compareTo(newHumanBeing.getName()) < 0);
            System.out.println(humanBeing.getName().compareTo(newHumanBeing.getName()));
            return true;
        }
        return false;
    }

    public boolean checkID(long id){
        for (HumanBeing humanBeing: humanBeings){
            if (humanBeing.getId() == id){
                return true;
            }
        }
        return false;
    }
    public boolean updateIdCounter(){
        for(HumanBeing humanBeing : humanBeings){
            if (humanBeing.getId()>= CounterID){
                CounterID = humanBeing.getId() + 1;
            }
        }
        return true;
    }

    public int averageOfImpact(){
        int counter = 0;
        Integer sum = 0;
        for (HumanBeing humanBeing : humanBeings){
            counter++;
            sum += humanBeing.getImpactSpeed();
        }
        int average = (sum/counter);
        return average;
    }

    public void clear(){
        System.out.println("Collection was cleared");
        humanBeings.clear();
    }

    public String groupCountingByToothpick(){
        int true_count = 0;
        int false_count = 0;
        for (HumanBeing humanBeing : humanBeings){
            if (humanBeing.isHasToothpick()) {
                true_count++;
            }
            else {
                false_count++;
            }
        }
        return ("Have toothpick: " + true_count + ", don't have toothpick: " + false_count);
    }

    public void info(){
        System.out.println("info: ");
        System.out.println("type: " + humanBeings.getClass());
        System.out.println("initialization time: " + initTime);
        System.out.println("size: " + humanBeings.size());
    }

    public boolean removeAllByWeapon(WeaponType weaponType){
        for(HumanBeing humanBeing : humanBeings){
            if (humanBeing.getWeaponType() == weaponType){
                humanBeings.remove(humanBeing);
            }
        }
        return false;
    }

    public void removeAtIndex(int index){
        humanBeings.remove(humanBeings.get(index));
    }

    public boolean removeById(long id){
        for (HumanBeing humanBeing: humanBeings){
            if(humanBeing.getId() == id){
                humanBeings.remove(humanBeing);
                return true;
            }
        }
        return false;
    }

    public void order(){
        humanBeings.sort(comp);
    }

    public void reorder(){
        humanBeings.sort(comp);
        Collections.reverse(humanBeings);
    }

    public void show(){
        for(HumanBeing humanBeing : humanBeings){
            System.out.println(humanBeing);
        }
        if (humanBeings.isEmpty()){
            System.out.println("Collection is empty");
        }
    }

    public boolean updateById(long id, HumanBeing newHumanBeing){
        for(HumanBeing humanBeing : humanBeings){
            if(humanBeing.getId() == id){
                humanBeings.remove(humanBeing);
                newHumanBeing.setId(id);
                humanBeings.add(newHumanBeing);
                return true;
            }
        }
        return false;
    }
}
