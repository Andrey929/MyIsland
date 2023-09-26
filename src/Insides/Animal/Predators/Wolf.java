package Insides.Animal.Predators;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.*;
import Insides.Animal.Predator;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_WOLF_ON_CELL;
import static Source.Island.islandModel;

public class Wolf extends Predator {
    ArrayList<Animal> whoCanEat = new ArrayList<>();

    {
        whoCanEat.add(new Horse());
        whoCanEat.add(new Deer());
        whoCanEat.add(new Rabbit());
        whoCanEat.add(new Mouse());
        whoCanEat.add(new Duck());
        whoCanEat.add(new Goat());
        whoCanEat.add(new Sheep());
        whoCanEat.add(new Pig());
        whoCanEat.add(new Buffalo());
    }

    public static void ex(Wolf wolf) {
        System.out.println(wolf.getX());
    }

    public Wolf(int x, int y) {
        super("Wolf", 50, 3, 7, 8, 1, 1, x, y);
        setWhoCanEats(whoCanEat);
    }

    public Wolf() {
        super("Wolf");
        setWhoCanEats(whoCanEat);
    }

    @Override
    public double chanceOnEat(Animal animal) {
        if (animal instanceof Rabbit) {
            return 60;
        } else if (animal instanceof Horse) {
            return 10;
        } else if (animal instanceof Deer) {
            return 15;
        } else if (animal instanceof Mouse) {
            return 80;
        } else if (animal instanceof Goat) {
            return 60;
        } else if (animal instanceof Sheep) {
            return 70;
        } else if (animal instanceof Pig) {
            return 15;
        } else if (animal instanceof Buffalo) {
            return 10;
        } else if (animal instanceof Duck) {
            return 40;
        } else return 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_WOLF_ON_CELL);
                ArrayList<Wolf> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Wolf(i, j));
                }
                islandModel[i][j].put("Wolf", list);
            }
        }
    }


}
