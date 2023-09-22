package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;
import Insides.Plant.Plant;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_HORSE_ON_CELL;
import static Source.Island.islandModel;

public class Horse extends Herbivores {
    public Horse(int x, int y) {
        super("Horse", 400, 4, 60, 60, 6, 6, x, y);
    }

    public Horse() {
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_HORSE_ON_CELL);
                ArrayList<Horse> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Horse(i, j));
                }
                islandModel[i][j].put("Horse", list);
            }
        }
    }
}
