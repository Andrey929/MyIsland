package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_CATERPILLAR_ON_CELL;
import static Source.Island.islandModel;

public class Caterpillar extends Herbivores {
    public Caterpillar(int x, int y) {
        super("Caterpillar", 0.01f, 0, 0, 0, 0, 0, x, y);
    }

    public Caterpillar() {
        super("Caterpillar");
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_CATERPILLAR_ON_CELL);
                ArrayList<Caterpillar> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Caterpillar(i, j));
                }
                islandModel[i][j].put("Caterpillar", list);
            }
        }
    }
}
