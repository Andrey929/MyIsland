package Source;

import Insides.Animal.Animal;
import Insides.Animal.Herbivoress.Caterpillar;

import java.util.ArrayList;
import java.util.stream.Stream;

public class GameProcess extends Population implements Runnable{
    static ArrayList<Animal> lusers = new ArrayList<>();
    static {lusers.add(new Caterpillar());}
    @Override
    public void run() {
        DirtyHardWorker.getStatistic();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DirtyHardWorker.actionsForTick();
    }
    public static boolean checkOnFinish(){

        ArrayList<Animal>  alive = new ArrayList<>();
        for (Animal a:listAnimal) {
            if (!lusers.contains(a)){
                alive.add(a);
            }
        }
        for (Animal a: alive) {
            if (a.getCountOnModel() == 0) {
                alive.remove(a);
                lusers.add(a);
            }
        }
        if (lusers.size() == 14) {
            System.out.println(alive.toString());
            return true;
        }else return false;
    }
}
