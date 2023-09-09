import Insides.Animal.Herbivoress.Rabbit;
import Insides.Plant.Plant;
import Source.Island;

import java.util.Arrays;

import static Source.Island.islandModel;

public class Main {
    public static void main(String[] args) {
        Island.CreateIsland();
        Plant plant =(Plant) islandModel[1][1].get("Plant").get(1);
        Rabbit rabbit = (Rabbit) islandModel[1][1].get("Rabbit").get(1);
        rabbit.setSaturation(0.1f);
        System.out.println(plant.getWeight());
        rabbit.eatPlant(plant);
        System.out.println(rabbit.getSaturation());
        System.out.println(plant.getWeight());
    }
}