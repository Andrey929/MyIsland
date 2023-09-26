package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_BUFFALO_ON_CELL;
import static Source.Island.islandModel;

public class Buffalo extends Herbivores {
    public Buffalo(int x, int y) {
        super("Buffalo", 700, 3, 100, 100, 10, 10, x, y);
    }

    public Buffalo() {
        super("Buffalo");
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_BUFFALO_ON_CELL);
                ArrayList<Buffalo> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Buffalo(i, j));
                }
                islandModel[i][j].put("Buffalo", list);
            }
        }
    }
}
