package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;
import Insides.Plant.Plant;
import Source.Island;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Herbivores {
    public Rabbit() {
    }

    public Rabbit(int x, int y) {
        super(2, 2, 0.45f, 0.45f, x, y);
    }

    @Override
    public boolean eatPlant(Plant plant) {
        if (getSaturation() < getSaturation_required()) {
            if (plant.getWeight() >= getSaturation_required()) {
                plant.setWeight(plant.getWeight() - (getSaturation_required() - getSaturation()));
                setSaturation(getSaturation_required());
                return true;
            }else {
                return false;
            }
        }else {
            return true;
        }
    }

    @Override
    public void moveTo() {

    }

    @Override
    public void run() {
        for (int i = 0; i < Island.islandModel.length; i++) {
            for (int j = 0; j < Island.islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, 150);
                ArrayList<Rabbit> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Rabbit(i, j));
                }
                Island.islandModel[i][j].put("Rabbit", list);
            }
        }
    }
}
