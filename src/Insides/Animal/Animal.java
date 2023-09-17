package Insides.Animal;

import Insides.Animal.Herbivoress.Rabbit;
import Insides.Animal.Predators.Wolf;
import Insides.MyIslandCycle;
import Insides.Plant.Plant;
import Source.Island;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static Insides.MyConst.MAX_COUNT_RABBIT_ON_CELL;
import static Source.Island.islandModel;

public abstract class Animal implements MyIslandCycle,Runnable{
    private String nameClass;
    private float weight;
    private  int maxStep;
    private float Saturation;
    private float Saturation_required;
    private int X;
    private int Y;
    private float deadly_saturation;
    private float hungerForOneTime;
    public Animal(){}

    public float getHungerForOneTime() {
        return hungerForOneTime;
    }

    public Animal(String nameClass, float weight, int maxStep,
                  float saturation, float saturation_required, float hungerForOneTime, float deadly_saturation,
                  int x, int y) {
        this.weight = weight;
        this.deadly_saturation = deadly_saturation;
        this.maxStep = maxStep;
        this.nameClass = nameClass;
        Saturation = saturation;
        this.hungerForOneTime = hungerForOneTime;
        Saturation_required = saturation_required;
        X = x;
        Y = y;
    }

    public String getNameClass() {
        return nameClass;
    }

    public float getDeadly_saturation() {
        return deadly_saturation;
    }

    public  int getX() {
        return X;
    }

    public  void setX(int x) {
        X = x;
    }
    public void setX_Y(int x,int y){
        X = x;
        Y = y;
    }

    public int getY() {
        return Y;
    }

    public  void setY(int y) {
        Y = y;
    }
    public void hunger() {
        if (this.getSaturation() < this.deadly_saturation) {
            islandModel[this.getX()][this.getY()].get(this.getNameClass()).remove(this);
            this.setSaturation(0);
        } else {
            this.setSaturation(this.getSaturation() - this.getHungerForOneTime());
        }
    }
    private void helpMoveTo(Animal animal){
        for (int step = 0; step <= ThreadLocalRandom.current().nextInt(0, animal.getMaxStep()); step++) {
            int x = animal.getX();
            int y = animal.getY();
            int rand = ThreadLocalRandom.current().nextInt(0, 10);

            if (rand % 2 == 0) { // Вверх или вниз
                if (x > 0 && islandModel[x - 1][y].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL) { // Вверх
                    move(animal, x - 1, y);
                } else {
                    if (x < 4 && islandModel[x + 1][y].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL) { // Вниз
                        move(animal, x + 1, y);
                    }
                }
            } else { // Влево или вправо
                if (y > 0 && islandModel[x][y - 1].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL) { // Влево
                    move(animal, x, y - 1);
                } else {
                    if (y < 4 && islandModel[x][y + 1].get("Rabbit").size() < MAX_COUNT_RABBIT_ON_CELL) {
                        // Вправо
                        move(animal, x, y + 1);
                    }
                }
            }
        }
    }

    private void moveTo(Animal animal){
        if (animal instanceof Rabbit) {
            helpMoveTo(animal);
        }else if (animal instanceof Wolf){
            helpMoveTo(animal);
        }
    }
    private void helpMove(Animal animal,int x2, int y2){
        islandModel[animal.getX()][animal.getY()].get(animal.getNameClass()).remove(animal);
        ArrayList<Animal> newList = (ArrayList<Animal>) islandModel[x2][y2].get(animal.getNameClass());
        animal.setX_Y(x2,y2);
        newList.add(animal);
        islandModel[x2][y2].replace(animal.getNameClass(), newList);

    }
    private void move(Animal animal, int x2, int y2){
        if (animal instanceof Rabbit) {
            helpMove(animal,x2,y2);
        }else if (animal instanceof Wolf) {
            helpMove(animal, x2, y2);
        }

    }
    public void moves(){
        System.out.println(this.nameClass);
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                for (int k = 0; k < islandModel[i][j].get(this.nameClass).size(); k++) {
                    ((Animal) islandModel[i][j].get(this.nameClass).get(k)).hunger();
                    moveTo((Animal) islandModel[i][j].get(this.nameClass).get(k));

                }
            }
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public  int getMaxStep() {
        return maxStep;
    }

    public void setMaxStep(int maxStep) {
        this.maxStep = maxStep;
    }

    public float getSaturation() {
        return Saturation;
    }

    public void setSaturation(float saturation) {
        Saturation = saturation;
    }

    public float getSaturation_required() {
        return Saturation_required;
    }

    public void setSaturation_required(float saturation_required) {
        Saturation_required = saturation_required;
    }

    @Override
    public abstract void run();

    public static int getCountInCell(int x,int y,String name) {
        return islandModel[x][y].get(name).size();
    }
}
