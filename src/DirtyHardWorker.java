import Insides.MyIslandСycle;

import java.util.ArrayList;

import static Source.Island.islandModel;

public class DirtyHardWorker implements MyIslandСycle {
    public static ArrayList<? extends MyIslandСycle> searchTrueList(ArrayList<? extends MyIslandСycle> list,int x,int y){
        for (int i = 0; i <islandModel[x][y].size()-1 ; i++) {
            if (islandModel[x][y].get(i).get(0).getClass().equals(list.get(0).getClass())) {

                System.out.println("Найден");
                return islandModel[x][y].get(i);

            }
    }
    return new ArrayList<>();
}
}
