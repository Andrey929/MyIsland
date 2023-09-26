package Insides.Animal.Predators;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.*;
import Insides.Animal.Predator;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.*;
import static Source.Island.islandModel;

public class Snake extends Predator {
    ArrayList<Animal> whoCanEat = new ArrayList<>();
    {
        whoCanEat.add(new Fox());
        whoCanEat.add(new Rabbit());
        whoCanEat.add(new Mouse());
        whoCanEat.add(new Duck());
    }
    public Snake() {
        super("Snake");
        setWhoCanEats(whoCanEat);
    }

    public Snake(int x, int y) {
        super("Snake", 15, 1, 3, 3, 0.3f, 0.3f, x, y);
        setWhoCanEats(whoCanEat);
    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, MAX_COUNT_SNAKE_ON_CELL);
                ArrayList<Snake> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Snake(i, j));
                }
                islandModel[i][j].put("Snake", list);
            }
        }
    }

    @Override
    public double chanceOnEat(Animal animal) {
        if (animal instanceof Rabbit) {
            return 20;
        } else if(animal instanceof Fox){
            return 15;
        }
        else if (animal instanceof Mouse){
            return 40;
        }else if (animal instanceof  Duck){
            return 10;
        }else return 0;

    }
}
