package Source;

import Insides.Animal.Herbivoress.*;
import Insides.Animal.Predators.*;
import Insides.MyIslandCycle;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinWorkerThread;

import static Source.Island.islandModel;

public class DirtyHardWorker implements MyIslandCycle {
    public static void generateAnimal(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ArrayList<Runnable> task = new ArrayList<>();
        task.add(new Rabbit());
        task.add(new Buffalo());
        task.add(new Caterpillar());
        task.add(new Deer());
        task.add(new Duck());
        task.add(new Goat());
        task.add(new Horse());
        task.add(new Mouse());
        task.add(new Pig());
        task.add(new Sheep());
        task.add(new Bear());
        task.add(new Eagle());
        task.add(new Fox());
        task.add(new Snake());
        task.add(new Wolf());
        for (Runnable run: task) {
            Thread thread= new Thread(run);
            executorService.submit(thread);
        }
        executorService.shutdown();
    }
}
