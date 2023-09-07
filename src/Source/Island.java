package Source;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.Rabbit;
import Insides.MyIslandСycle;
import Insides.Plant.Plant;
import Insides.Plant.PlantsThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static Source.Setting.Island_Parameter.*;

public class Island {
    public static ArrayList<ArrayList<? extends MyIslandСycle>>[][] islandModel = new ArrayList[WIDTH_ISLAND][HEIGHT_ISLAND];
    public static void CreateIsland(){
        PlantsThread plant = new PlantsThread();
        plant.start();
        try {
            plant.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Rabbit rabbit1 = new Rabbit();
        ArrayList<Rabbit> r = new ArrayList<>();
        r.add(new Rabbit());
        islandModel[4][4].add(r);
        System.out.println(rabbit1.getWeight());
        System.out.println(islandModel[4][4].get(1).size());




    }
    public static void GeneratePlant(){

    }
}
