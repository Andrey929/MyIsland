package Source;

import Insides.Animal.Herbivoress.Rabbit;
import Insides.MyIslandCycle;
import Insides.Plant.PlantsThread;

import java.util.ArrayList;
import java.util.HashMap;

import static Source.Setting.Island_Parameter.*;

public class Island {
    public static HashMap<String, ArrayList<? extends MyIslandCycle>>[][] islandModel = new HashMap[WIDTH_ISLAND][HEIGHT_ISLAND];

    public static void CreateIsland() {
        init();
        Thread rabbit = new Thread(new Rabbit());
        PlantsThread plant = new PlantsThread();
        plant.start();
        rabbit.start();
        try {
            plant.join();
            rabbit.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    private static void init(){
        for (int i = 0; i < Island.islandModel.length; i++) {
            for (int j = 0; j < Island.islandModel[i].length; j++) {
                Island.islandModel[i][j] = new HashMap<>();
            }
         }
    }
}
