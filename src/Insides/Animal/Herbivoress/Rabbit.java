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
        super("Rabbit",2, 2, 0.45f, 0.45f, x, y);
    }

    @Override
    public boolean eatPlant(Plant plant) {
        if (this.getSaturation() < this.getSaturation_required()) {
            if (plant.getWeight() >= this.getSaturation_required()) {
                plant.setWeight(plant.getWeight() - (this.getSaturation_required() - this.getSaturation()));
                this.setSaturation(this.getSaturation_required());
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }


    @Override
    public void moveTo(Animal animal) {
        Rabbit rabbit = (Rabbit) animal;
        int countStep = ThreadLocalRandom.current().nextInt(0, rabbit.getMaxStep());
        for (int step = 0; step <= countStep; step++) {
            int x = rabbit.getX();
            int y = rabbit.getY();
            int rand = ThreadLocalRandom.current().nextInt(0, 10);

            if (rand % 2 == 0) { // Вверх или вниз
                if (x > 0 && islandModel[x - 1][y].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL) { // Вверх
                    move(rabbit, x - 1, y);
                } else {
                    if (x < 4 && islandModel[x + 1][y].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL) { // Вниз
                        move(rabbit, x + 1, y);
                    }
                }
            } else { // Влево или вправо
                if (y > 0 && islandModel[x][y - 1].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL) { // Влево
                    move(rabbit, x, y - 1);
                } else {
                    if (y < 4 && islandModel[x][y + 1].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL) {
                        // Вправо
                        move(rabbit, x, y + 1);
                    }
                }
            }
        }
    }

    protected void move(Animal animal, int x2, int y2) {
        Rabbit rabbit = (Rabbit) animal;
        islandModel[rabbit.getX()][rabbit.getY()].get("Rabbit").remove(rabbit);
        ArrayList<Rabbit> newList = (ArrayList<Rabbit>) islandModel[x2][y2].get("Rabbit");
        rabbit.setX(x2);
        rabbit.setY(y2);
        newList.add(rabbit);
        islandModel[x2][y2].replace("Rabbit", newList);

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
