package Insides.Animal.Herbivoress;

import Insides.Animal.Herbivores;
import Insides.Plant.Plant;
import Source.Island;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Herbivores{
    public Rabbit(){}

    public Rabbit( int x, int y) {
        super(2, 2, 0.45f,0.45f,x,y);
    }

    @Override
    public void eatPlant(Plant plant) {

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
