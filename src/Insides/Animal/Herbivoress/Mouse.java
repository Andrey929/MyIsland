package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.*;
import static Source.Island.islandModel;

public class Mouse extends Herbivores {
    public Mouse(int x, int y) {
        super("Mouse", 0.05f, 1, 0.01f, 0.01f, 0.001f, 0.001f, x, y);
    }

    public Mouse() {
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_MOUSE_ON_CELL);
                ArrayList<Mouse> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Mouse(i, j));
                }
                islandModel[i][j].put("Mouse", list);
            }
        }
    }
}
