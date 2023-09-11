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
        super(2, 2, 0.45f, 0.45f, x, y);
    }

    @Override
    public boolean eatPlant(Plant plant) {
        if (getSaturation() < getSaturation_required()) {
            if (plant.getWeight() >= getSaturation_required()) {
                plant.setWeight(plant.getWeight() - (getSaturation_required() - getSaturation()));
                setSaturation(getSaturation_required());
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
        int step = 0;
        int countStep = ThreadLocalRandom.current().nextInt(0, rabbit.getMaxStep());
        while (step < countStep) {
            int x = rabbit.getX();
            int y = rabbit.getY();
            int rand = ThreadLocalRandom.current().nextInt(0, 10);
            if (rand % 2 == 0) {
                rand = ThreadLocalRandom.current().nextInt(0, 10);
                if (x > 0 & x <5 & y >0 & y <5) {
                    if (rand % 2 == 0) { //first in up or down
                        if (islandModel[x - 1][y].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & x-1 >=0) {// up
                            //
                            move(rabbit,x-1,y);
                        } else {
                            if (islandModel[x+ 1][y].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & x+1 < 5) {// down
                                //
                                move(rabbit,x+1,y);
                            }
                        }
                    } else {
                        if (islandModel[x+ 1][y].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & x+1 < 5) {// down
                            //
                            move(rabbit,x+1,y);
                        }else {
                            if (islandModel[x- 1][y].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & x-1 >=0) {// up
                                //
                                move(rabbit,x-1,y);
                            }
                        }
                    }
                }else {
                    if (islandModel[x + 1][y].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & x+1 < 5) {// down
                        //
                        move(rabbit,x+1,y);
                    }
                }
            }else{
                rand = ThreadLocalRandom.current().nextInt(0, 10);
                if (rand % 2 == 0) {
                    rand = ThreadLocalRandom.current().nextInt(0, 10);
                    if (x > 0 & x <5 & y >0 & y <5) {
                        if (rand % 2 == 0) { //first in up or down
                            if (islandModel[x][y-1].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & y -1 >=0) {// left
                                //
                                move(rabbit,x,y-1);
                            } else {
                                if (islandModel[x][y+1].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & y +1 <5) {// right
                                    //
                                    move(rabbit,x,y+1);
                                }
                            }
                        } else {
                            if (islandModel[x][y+1].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & y +1 <5) {// right
                                //
                                move(rabbit,x,y+1);
                            }else {
                                if (islandModel[x][y-1].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & y -1 >=0) {// left
                                    //
                                    move(rabbit,x,y-1);
                                }
                            }
                        }
                    }else {
                        if (islandModel[x][y+1].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL & y +1 <5) {// right
                            //
                            move(rabbit,x,y+1);
                        }
                    }
                }
            }
            step++;

        }

    }
    private void move(Rabbit rabbit,int x2,int y2){
        islandModel[rabbit.getX()][rabbit.getY()].get("Rabbit").remove(rabbit);
        ArrayList<Rabbit> newList = (ArrayList<Rabbit>) islandModel[x2][y2].get("Rabbit");
        newList.add(rabbit);
        islandModel[x2][y2].replace("Rabbit",newList);

    }

    @Override
    public void run() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0, 150);
                ArrayList<Rabbit> list = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    list.add(new Rabbit(i, j));
                }
                islandModel[i][j].put("Rabbit", list);
            }
        }
    }
}
