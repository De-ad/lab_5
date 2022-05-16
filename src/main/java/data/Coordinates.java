package data;

import com.opencsv.bean.CsvBindByPosition;
import util.IO;
import java.util.Objects;

/**
 * Coordinates data class
 */

public class Coordinates {
    @CsvBindByPosition(position = 2)
    private Integer x; //Поле не может быть null
    @CsvBindByPosition(position = 3)
    private long y;

    private Coordinates(Integer x, long y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(){

    }

    public static Coordinates setCoordinates(){
        Integer x = setX();
        long y = setY();
        return new Coordinates(x, y);
    }


    public static Integer setX() {
        try {
            System.out.println("Enter coordinate X: ");
            return Integer.parseInt(IO.getInput());
        }
        catch (NumberFormatException e){
            System.out.println("Coordinate value should be an Integer");
            return setX();
        }
    }

    public static long setY() {
        try {
            System.out.println("Enter coordinate Y: ");
            return Long.parseLong(IO.getInput());
        }
        catch (NumberFormatException e){
            System.out.println("Coordinate value should be a long");
            return setY();
        }
    }

    public Integer getX(){
        return x;
    }

    public long getY(){
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return y == that.y && Objects.equals(x, that.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
