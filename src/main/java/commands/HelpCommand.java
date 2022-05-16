package commands;

/**
 * Command 'HelpCommand'. Shows info about available commands.
 */

public class HelpCommand extends Command {

    public HelpCommand(){
        super("help", "show info about available commands");
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Manual about available commands: ");
        System.out.println("help : вывести справку по доступным командам\n" +
        "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, " +
                        "количество элементов и т.д.)\n" +
        "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
        "add {element} : добавить новый элемент в коллекцию\n" +
        "update_id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
        "remove_by_id id : удалить элемент из коллекции по его id\n" +
        "clear : очистить коллекцию\n" +
        "save : сохранить коллекцию в файл\n" +
        "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды" +
                        " в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
        "exit : завершить программу (без сохранения в файл)\n" +
        "remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)\n" +
        "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает " +
                        "значение наибольшего элемента этой коллекции\n" +
        "reorder : отсортировать коллекцию в порядке, обратном нынешнему\n" +
        "remove_all_by_weapon_type weaponType : удалить из коллекции все элементы, значение поля" +
                        " weaponType которого эквивалентно заданному\n" +
        "average_of_impact_speed : вывести среднее значение поля impactSpeed для всех элементов коллекции\n" +
        "group_counting_by_has_toothpick : сгруппировать элементы коллекции по значению поля hasToothpick," +
                " вывести количество элементов в каждой группе)\n");
    }
}
