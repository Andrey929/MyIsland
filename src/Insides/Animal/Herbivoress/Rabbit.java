package Insides.Animal.Herbivoress;

import Insides.Animal.Animal;
import Insides.Animal.Herbivores;
import Insides.MyIslandCycle;
import Insides.Plant.Plant;
import Source.Island;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_RABBIT_ON_CELL;
import static Source.Island.islandModel;

public class Rabbit extends Herbivores implements MyIslandCycle {
    public Rabbit() {
    }

    public Rabbit(int x, int y) {
        super("Rabbit",2, 2, 0.45f, 0.45f,0.05f,0.05f, x, y);
    }





    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_RABBIT_ON_CELL);
                ArrayList<Rabbit> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Rabbit(i, j));
                }
                islandModel[i][j].put("Rabbit", list);
            }
        }
    }
}
