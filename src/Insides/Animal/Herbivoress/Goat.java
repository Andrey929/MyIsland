package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_GOAT_ON_CELL;
import static Source.Island.islandModel;

public class Goat extends Herbivores {
    public Goat(int x, int y) {
        super("Goat", 60, 3, 10, 10, 1, 1, x, y);
    }

    public Goat() {
        super("Goat");
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_GOAT_ON_CELL);
                ArrayList<Goat> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Goat(i, j));
                }
                islandModel[i][j].put("Goat", list);
            }
        }
    }
}
