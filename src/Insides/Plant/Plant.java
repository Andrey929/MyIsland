package Insides.Plant;

import Insides.Animal.Animal;
import Insides.MyIslandCycle;

import static Insides.MyConst.MAX_PLANT_WEIGHT;
import static Source.Island.islandModel;

public class Plant implements MyIslandCycle {
    private final static String name = "Травка";

    private static float weight = 1;

    private static int X;
    private static int Y;

    public Plant(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void growthPlantForTik() {
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                for (int k = 0; k < islandModel[i][j].get("Plant").size(); k++) {
                    if (weight < MAX_PLANT_WEIGHT) {
                        weight += 0.1f;
                    }
                }
            }
        }

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


    public static int getCountPlantInCell() {
        return islandModel[X][Y].get("Plant").size();
    }

}
