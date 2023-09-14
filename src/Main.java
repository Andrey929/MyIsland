import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.Rabbit;
import Insides.Animal.Predators.Wolf;
import Insides.Plant.Plant;
import Source.Island;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Source.Island.islandModel;

public class Main {
    public static void main(String[] args) {
        Island.CreateIsland();
        Wolf wolf = new Wolf(2, 1);
        Rabbit rabbit = new Rabbit(1, 1);
        wolf.setSaturation(1);
        System.out.println(islandModel[1][1].get("Rabbit").size());
        wolf.eatAnimal((Animal)islandModel[1][1].get("Rabbit").get(0));
        System.out.println(wolf.getSaturation());
        System.out.println(islandModel[1][1].get("Rabbit").size());




    }
}