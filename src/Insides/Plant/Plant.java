package Insides.Plant;

import Insides.MyIslandCycle;

import static Source.Island.islandModel;

public class Plant implements MyIslandCycle {
    private final static String name = "Травка";
    private static float weight = 1;
    private boolean readyToEat;
    private static int X;
    private static int Y;
    public Plant(int x,int y){
        X = x;
        Y = y;
        readyToEat = true;
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
        Plant.weight = weight;
    }

    public boolean isReadyToEat() {
        return readyToEat;
    }

    public void setReadyToEat(boolean readyToEat) {
        this.readyToEat = readyToEat;
    }

    public static int getCountPlantInCell(){
        return islandModel[X][Y].get("Plant").size();
    }

}
