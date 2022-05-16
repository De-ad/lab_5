package commands;

import util.CollectionManager;

/**
 *  Command 'Average Of Impact Speed'. Shows average value of impactSpeed field for all elements
 *  of this collection.
 */

public class AverageOfImpactSpeedCommand extends Command {
    private final CollectionManager collectionManager;

    public AverageOfImpactSpeedCommand(CollectionManager collectionManager){
        super("average_of_impact_speed", "show average value of impactSpeed field for all elements" +
                "of this collection");
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String[] args) {
        try {
            System.out.println("Average impact speed: " + collectionManager.averageOfImpact());
        }
        catch (ArithmeticException e){
            System.out.println("Collection is empty");
        }
    }
}
