package Insides.Animal.Predators;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.Rabbit;
import Insides.Animal.Predator;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_BEAR_ON_CELL;
import static Source.Island.islandModel;

public class Bear extends Predator {
    public Bear(int x, int y) {
        super("Bear", 500, 2,
                80, 80, 8, 8, x, y);
    }

    public Bear() {
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_BEAR_ON_CELL);
                ArrayList<Bear> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Bear(i, j));
                }
                islandModel[i][j].put("Bear", list);
            }
        }
    }

    @Override
    public double chanceOnEat(Animal animal) {
        if (animal instanceof Snake){
            return 80;
        }else if (animal instanceof Rabbit){
            return 80;
        }else return 0;
    }
}
