import Insides.Animal.Herbivoress.Horse;
import Insides.Plant.Plant;
import Source.Island;

import static Source.Island.islandModel;

public class Main {
    public static void main(String[] args) {
        Island.CreateIsland();
        Horse horse = new Horse(1,1);
        horse.setSaturation(15);
        System.out.println(horse.getSaturation());
        horse.eatPlant(new Plant(1,1));
        System.out.println(horse.getSaturation());
    }
}