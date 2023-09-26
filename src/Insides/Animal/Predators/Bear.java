package Insides.Animal.Predators;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.*;
import Insides.Animal.Predator;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_BEAR_ON_CELL;
import static Source.Island.islandModel;

public class Bear extends Predator {
    ArrayList<Animal> whoCanEat = new ArrayList<>();
    {
        whoCanEat.add(new Snake());
        whoCanEat.add(new Horse());
        whoCanEat.add(new Deer());
        whoCanEat.add(new Rabbit());
        whoCanEat.add(new Mouse());
        whoCanEat.add(new Goat());
        whoCanEat.add(new Sheep());
        whoCanEat.add(new Pig());
        whoCanEat.add(new Buffalo());
        whoCanEat.add(new Duck());


    }
    public Bear(int x, int y) {
        super("Bear", 500, 2,
                80, 80, 8, 8, x, y);
        setWhoCanEats(whoCanEat);
    }

    public Bear() {
        super("Bear");
        setWhoCanEats(whoCanEat);
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_BEAR_ON_CELL);
                ArrayList<Bear> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Bear(i, j));
                }
                islandModel[i][j].put("Bear", list);
            }
        }
    }

    @Override
    public double chanceOnEat(Animal animal) {
        if (animal instanceof Snake){
            return 80;
        }else if (animal instanceof Rabbit){
            return 80;
        }else if (animal instanceof Horse){
            return 40;
        }else if (animal instanceof Deer){
            return 80;
        }else if (animal instanceof Mouse){
            return 90;
        }else if (animal instanceof Goat){
            return 70;
        }else if (animal instanceof Sheep){
            return 70;
        }else if (animal instanceof Pig){
            return 50;
        }else if (animal instanceof Buffalo){
            return 20;
        }else if (animal instanceof Duck){
            return 10;
        }else return 0;
    }
}
