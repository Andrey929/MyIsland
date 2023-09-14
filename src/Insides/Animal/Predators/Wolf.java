package Insides.Animal.Predators;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.Rabbit;
import Insides.Animal.Predator;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_WOLF_ON_CELL;
import static Source.Island.islandModel;

public class Wolf extends Predator {
    public static void ex(Wolf wolf){
        System.out.println(wolf.getX());
    }
    public Wolf(int x, int y) {
        super("Wolf",50, 3, 8, 8, x, y);
    }
    public Wolf(){};

    @Override
    public double chanceOnEat(Animal animal){
        if (animal instanceof Rabbit) {
            return 60;
        }else return 0;
    }

    @Override
    public void moveTo(Animal animal) {

    }

    @Override
    protected void move(Animal animal, int x2, int y2) {

    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_WOLF_ON_CELL);
                ArrayList<Wolf> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Wolf(i, j));
                }
                islandModel[i][j].put("Wolf", list);
            }
        }
    }


}
