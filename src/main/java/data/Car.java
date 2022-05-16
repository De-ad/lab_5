package data;

import com.opencsv.bean.CsvBindByPosition;
import util.IO;
import java.util.Locale;
import java.util.Objects;

/**
 * Car data class
 */

public class Car {
    @CsvBindByPosition(position = 10)
    private Boolean cool; //Поле может быть null

    public Car(Boolean cool){
        this.cool = cool;
    }

    public Car(){
    }

    public static Car setCar(){
        boolean cool = setCool();
        return new Car(cool);
    }
    public static Boolean setCool() {
        try{
            System.out.println("Cool car. True?");
            String input = IO.getInput().toLowerCase(Locale.ROOT);
            if (input.equals("false") || input.equals("true")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Should be boolean");
            return setCool();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return setCool();
    }

    public Boolean getCool() {
        return cool;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cool=" + cool +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(cool, car.cool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cool);
    }
}
