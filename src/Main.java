import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.Rabbit;
import Insides.Animal.Predators.Wolf;
import Insides.Plant.Plant;
import Source.Island;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Source.Island.islandModel;

public class Main {
    public static void main(String[] args) {
        Island.CreateIsland();
        List<Integer> list = new ArrayList<>();
        List<Integer> rezlist = new ArrayList<>();
        Rabbit rabbit = (Rabbit) islandModel[0][0].get("Rabbit").get(0);
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                list.add(islandModel[i][j].get("Rabbit").size());
                for (int k = 0; k < islandModel[i][j].get("Rabbit").size(); k++) {
                    try {
                        rabbit.moveTo((Animal) islandModel[i][j].get("Rabbit").get(k));
                    }catch (Exception e){
                    }
                }
            }
        }
        System.out.println("-------------------------------------------");
        rabbit.moveTo(rabbit);
        //islandModel[1][1].get("Rabbit").remove(rabbit);
        System.out.println(islandModel.length);
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                rezlist.add(islandModel[i][j].get("Rabbit").size());
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(rezlist.toArray()));


    }
}