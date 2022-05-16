package commands;

import java.util.Objects;

/**
 * Abstract class Command for every Concrete Command.
 */

public abstract class Command {

    private String description;
    private String name;

    public Command(String name, String description){
        this.name=name;
        this.description=description;
    }
    public abstract void execute(String args[]);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description){
        this.description=description;
        };

    public String getDescription(){
        return description;
        };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(description, command.description) && Objects.equals(name, command.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name);
    }

    @Override
    public String
    toString() {
        return "Command{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
