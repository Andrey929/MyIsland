import Insides.Animal.Herbivoress.Horse;
import Insides.Animal.Predators.Bear;
import Insides.Animal.Predators.Wolf;
import Insides.Plant.Plant;
import Source.DirtyHardWorker;
import Source.GameProcess;
import Source.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static Source.Island.islandModel;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Island.CreateIsland();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleWithFixedDelay(new GameProcess(),1,2,TimeUnit.MILLISECONDS);
        if (GameProcess.checkOnFinish()) {
            executorService.shutdown();
        }


    }
}