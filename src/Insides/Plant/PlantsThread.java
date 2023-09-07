package Insides.Plant;

import Insides.MyIslandСycle;
import Source.Island;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PlantsThread extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < Island.islandModel.length; i++) {
            for (int j = 0; j < Island.islandModel[i].length; j++) {
                int countPlant = ThreadLocalRandom.current().nextInt(0,200);
                System.out.println(countPlant);
                ArrayList<Plant> plants = new ArrayList<>();
                Island.islandModel[i][j] = new ArrayList<>();
                for (int k = 0; k < countPlant; k++) {
                    plants.add(new Plant(i,j));
                }
                Island.islandModel[i][j].add(plants);
                System.out.println(Island.islandModel[i][j]);
            }

        }
    }
}
