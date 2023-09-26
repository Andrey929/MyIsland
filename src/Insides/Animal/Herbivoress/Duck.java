package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_DUCK_ON_CELL;
import static Source.Island.islandModel;

public class Duck extends Herbivores {
    public Duck(int x, int y) {
        super("Duck", 1, 4, 0.15f, 0.15f, 0.015f, 0.015f, x, y);
    }

    public Duck() {
        super("Duck");
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_DUCK_ON_CELL);
                ArrayList<Duck> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Duck(i, j));
                }
                islandModel[i][j].put("Duck", list);
            }
        }
    }
}
