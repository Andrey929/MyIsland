package Insides.Animal.Predators;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.Rabbit;
import Insides.Animal.Predator;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.*;
import static Source.Island.islandModel;

public class Fox extends Predator {
    public Fox(int x, int y) {
        super("Fox", 8, 2,
                2, 2, 0.2f, 0.2f, x, y);
    }

    public Fox() {
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_FOX_ON_CELL);
                ArrayList<Fox> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Fox(i, j));
                }
                islandModel[i][j].put("Fox", list);
            }
        }

    }

    @Override
    public double chanceOnEat(Animal animal) {
        if (animal instanceof Rabbit){
            return 70;
        }else return 0;
    }
}
