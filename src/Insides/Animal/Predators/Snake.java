package Insides.Animal.Predators;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.Rabbit;
import Insides.Animal.Predator;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.*;
import static Source.Island.islandModel;

public class Snake extends Predator {
    public Snake() {
    }

    public Snake(int x, int y) {
        super("Snake", 15, 1, 3, 3, 0.3f, 0.3f, x, y);
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_SNAKE_ON_CELL);
                ArrayList<Snake> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Snake(i, j));
                }
                islandModel[i][j].put("Snake", list);
            }
        }
    }

    @Override
    public double chanceOnEat(Animal animal) {
        if (animal instanceof Rabbit) {
            return 20;
        } else return 0;

    }
}
