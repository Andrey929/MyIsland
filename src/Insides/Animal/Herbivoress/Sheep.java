package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_SHEEP_ON_CELL;
import static Source.Island.islandModel;

public class Sheep extends Herbivores {
    public Sheep(int x, int y) {
        super("Sheep", 70, 3, 15, 15, 1.5f, 1.5f, x, y);
    }

    public Sheep() {
        super("Sheep");
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_SHEEP_ON_CELL);
                ArrayList<Sheep> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Sheep(i, j));
                }
                islandModel[i][j].put("Sheep", list);
            }
        }
    }
}
