package data;

import com.opencsv.bean.*;
import util.CollectionManager;
import util.IO;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

/**
 * class HumanBeing objects of which collection consist of
 */

public class HumanBeing {
    @CsvBindByPosition(position = 0)
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого
    // поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @CsvBindByPosition(position = 1)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @CsvRecurse
    private Coordinates coordinates; //Поле не может быть null
    @CsvBindByPosition(position = 4)
    @CsvDate("yyyy-MM-dd")
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля
    // должно генерироваться автоматически
    @CsvBindByPosition(position = 5)
    private boolean realHero;
    @CsvBindByPosition(position = 6)
    private boolean hasToothpick;
    @CsvBindByPosition(position = 7)
    private Integer impactSpeed; //Максимальное значение поля: 514, Поле не может быть null
    @CsvBindByPosition(position = 8)
    private WeaponType weaponType; //Поле не может быть null
    @CsvBindByPosition(position = 9)
    private Mood mood; //Поле не может быть null
    @CsvRecurse
    private Car car; //Поле не может быть null


    /**
     *
     * @param id - human being's id
     * @param name - human being's name
     * @param coordinates - human being's coordinates
     * @param realHero- is human being a real hero
     * @param hasToothpick - do human being has toothpick
     * @param impactSpeed - human being's impact speed
     * @param weaponType - human being's weapon type
     * @param mood - human being's mood
     * @param car - human being's car
     *
     */

    public HumanBeing(Long id, String name,Coordinates coordinates, boolean realHero,
                      boolean hasToothpick,Integer impactSpeed, WeaponType weaponType, Mood mood, Car car){
        this.id=id;
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate=LocalDate.now();
        this.realHero = realHero;
        this.hasToothpick =hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType= weaponType;
        this.mood=mood;
        this.car=car;
    }

    public HumanBeing(){

    }

    public static HumanBeing input(CollectionManager collectionManager) throws Exception {
         long id = collectionManager.getId();
         String name = setName();
         Coordinates coordinates = Coordinates.setCoordinates();
         boolean realHero = setRealHero();
         boolean hasToothpick = setHasToothpick();
         Integer impactSpeed = setImpactSpeed();
         WeaponType weaponType = WeaponType.input();
         Mood mood = Mood.input();
         Car car = Car.setCar();
         return new HumanBeing(id, name, coordinates, realHero, hasToothpick, impactSpeed, weaponType, mood, car);
    }
    public boolean validate(HumanBeing humanBeing) throws Exception{
        if (humanBeing.getImpactSpeed() < 0 || humanBeing.getImpactSpeed() > 514){
            throw new Exception("not right impact speed");
        }
        if (humanBeing.getName() == null || humanBeing.getName().trim().isEmpty()){
            throw new Exception("not right name");
        }
        if (humanBeing.getWeaponType()== null){
            throw new Exception("not right im tired");
        }
        return true;
    }

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }


    public static String setName(){
        System.out.println("Enter name: ");
        String name = IO.getInput();
        if (name == null || name.trim().isEmpty()){
            System.out.println("name can't be empty or null");
                return setName();
            }
        return name;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }


    public static Integer setImpactSpeed(){
        System.out.println("Enter impact speed (max value = 514): ");
        try {
            Integer impactSpeed = Integer.parseInt(IO.getInput());
            if (impactSpeed == null){
                throw new NullPointerException("Impact speed can't be null");
            }
            if (impactSpeed > 514 || impactSpeed < 0){
                throw new Exception("Impact speed should be between 0 and 514");
            }
            return impactSpeed;
        }
        catch (NumberFormatException e){
            System.out.println("Impact speed should be a number");
        }
        catch (NullPointerException e){
            System.out.println("shouldn't be null");
        }
        catch (Exception e){
            System.out.println("Wrong data");
        }
        return setImpactSpeed();
    }

    public Integer getImpactSpeed() {
        return impactSpeed;
    }

    public Mood getMood() {
        return mood;
    }

    public WeaponType getWeaponType() {
        System.out.println(weaponType);
        return weaponType;
    }

    public static boolean setRealHero() throws Exception {
        try{
            System.out.println("Real hero. True?");
            String input = IO.getInput().toLowerCase(Locale.ROOT);
            if (input.equals("false") || input.equals("true")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Should be boolean");
            return setRealHero();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return setRealHero();
    }

    public boolean isRealHero() {
        return realHero;
    }

    public static boolean setHasToothpick() throws Exception {
        try{
            System.out.println("Has toothpick. True?");
            String input = IO.getInput().toLowerCase(Locale.ROOT);
            if (input.equals("false") || input.equals("true")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Should be boolean");
            return setHasToothpick();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return setHasToothpick();
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "HumanBeing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", realHero=" + realHero +
                ", hasToothpick=" + hasToothpick +
                ", impactSpeed=" + impactSpeed +
                ", weaponType=" + weaponType +
                ", mood=" + mood +
                ", car=" + car +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanBeing that = (HumanBeing) o;
        return realHero == that.realHero && hasToothpick == that.hasToothpick && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(impactSpeed, that.impactSpeed) && weaponType == that.weaponType && mood == that.mood && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, weaponType, mood, car);
    }
}
