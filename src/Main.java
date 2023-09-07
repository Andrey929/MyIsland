import Insides.Plant.Plant;
import Source.Island;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Island.CreateIsland();
        DirtyHardWorker dirtyHardWorker = new DirtyHardWorker();
        ArrayList<Plant> plants = (ArrayList<Plant>) dirtyHardWorker.searchTrueList(new ArrayList< Plant >(),4,4);
        System.out.println(plants.get(0).getPlantName());
    }
}