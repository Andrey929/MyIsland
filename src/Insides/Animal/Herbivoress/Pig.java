package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_PIG_ON_CELL;
import static Source.Island.islandModel;

public class Pig extends Herbivores {
    public Pig( int x, int y) {
        super("Pig", 400, 2, 50, 50, 5, 5, x, y);
    }

    public Pig() {
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_PIG_ON_CELL);
                ArrayList<Pig> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Pig(i, j));
                }
                islandModel[i][j].put("Pig", list);
            }
        }
    }
}
