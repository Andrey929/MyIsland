package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_DEER_ON_CELL;
import static Insides.MyConst.MAX_COUNT_HORSE_ON_CELL;
import static Source.Island.islandModel;

public class Deer extends Herbivores {
    public Deer( int x, int y) {
        super("Deer", 300, 4, 50, 50, 5, 5, x, y);
    }

    public Deer() {
        super("Deer");
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_DEER_ON_CELL);
                ArrayList<Deer> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Deer(i, j));
                }
                islandModel[i][j].put("Deer", list);
            }
        }
    }
}
