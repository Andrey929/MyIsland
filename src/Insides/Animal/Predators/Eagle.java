package Insides.Animal.Predators;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.Rabbit;
import Insides.Animal.Predator;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_EAGLE_ON_CELL;
import static Source.Island.islandModel;

public class Eagle extends Predator {
    public Eagle(int x, int y) {
        super("Eagle", 6, 3, 1, 1, 0.1f, 0.1f, x, y);
    }

    public Eagle() {
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_EAGLE_ON_CELL);
                ArrayList<Eagle> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Eagle(i, j));
                }
                islandModel[i][j].put("Eagle", list);
            }
        }
    }

    @Override
    public double chanceOnEat(Animal animal) {
        if (animal instanceof Rabbit){
            return 90;
        }else if (animal instanceof Fox){
            return 10;
        }else {
            return 0;
        }
    }
}
