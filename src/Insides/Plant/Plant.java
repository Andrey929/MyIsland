package Insides.Plant;

import Insides.MyIslandСycle;
import Source.Island;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Source.Island.islandModel;

public class Plant implements MyIslandСycle {
    private final String name = "Травка";
    private float weight = 1;
    private boolean readyToEat;
    private int X;
    private int Y;
    public Plant(int x,int y){
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public String getPlantName() {
        return name;
    }
    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isReadyToEat() {
        return readyToEat;
    }

    public void setReadyToEat(boolean readyToEat) {
        this.readyToEat = readyToEat;
    }

    public static int getCountPlantInCell(int x,int y){
        return islandModel[x][y].get(0).size();
    }

}
