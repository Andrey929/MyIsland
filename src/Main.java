import Insides.Animal.Herbivoress.Horse;
import Insides.Plant.Plant;
import Source.Island;

import static Source.Island.islandModel;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Island.CreateIsland();
        Thread.sleep(200);
        System.out.println(islandModel[1][1].get("Mouse").size());
    }
}