package Source;

import Insides.Animal.Animal;
import Insides.Animal.Herbivores;
import Insides.Animal.Herbivoress.*;
import Insides.Animal.Predator;
import Insides.Animal.Predators.*;
import Insides.MyIslandCycle;
import Insides.Plant.Plant;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinWorkerThread;

import static Source.Island.islandModel;

public class DirtyHardWorker extends Population implements MyIslandCycle {
    static Random random = new Random();

    public static void generateInsides() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (Runnable run : task) {
            Thread thread = new Thread(run);
            executorService.submit(thread);
        }
        executorService.shutdown();
    }

    public static void actionsForTick() {
        ArrayList<Integer> number = new ArrayList<>();
        int count = 0;
        int index;
        while (count < 15) {
            do {
                index = random.nextInt(0, 15);
            } while (number.contains(index));
            number.add(index);

            switch (index) {
                case 1 -> helpForTick(new Bear());
                case 2 -> helpForTick(new Eagle());
                case 3 -> helpForTick(new Fox());
                case 4 -> helpForTick(new Snake());
                case 5 -> helpForTick(new Wolf());
                case 6 -> helpForTick(new Caterpillar());
                case 7 -> helpForTick(new Buffalo());
                case 8 -> helpForTick(new Deer());
                case 9 -> helpForTick(new Duck());
                case 10 -> helpForTick(new Goat());
                case 11 -> helpForTick(new Horse());
                case 12 -> helpForTick(new Mouse());
                case 13 -> helpForTick(new Pig());
                case 14 -> helpForTick(new Rabbit());
                case 15 -> helpForTick(new Sheep());
            }
            count++;
        }
    }

    private static void helpForTick(Animal animal) {
        animal.moves();
        if (animal instanceof Predator) {
            ArrayList<Animal> animalsEat = ((Predator) animal).getWhoCanEats();
            int index;
            for (int i = 0; i < islandModel.length; i++) {
                for (int j = 0; j < islandModel[i].length; j++) {
                    for (int k = 0; k < islandModel[i][j].get(animal.getNameClass()).size(); k++) {
                        int sizee = animalsEat.size();
                        index = random.nextInt(0, sizee);
                        if (!islandModel[i][j].get(animalsEat.get(index).getNameClass()).isEmpty()) {
                            ((Predator) islandModel[i][j].get(animal.getNameClass()).get(k)).eatAnimal((Animal) islandModel[i][j].get(animalsEat.get(index).getNameClass()).get(0));
                        }

                    }


                }
            }
        } else if (animal instanceof Herbivores) {
            for (int i = 0; i < islandModel.length; i++) {
                for (int j = 0; j < islandModel[i].length; j++) {
                    for (int k = 0; k < islandModel[i][j].get(animal.getNameClass()).size(); k++) {
                        ((Herbivores) animal).eatPlant((Plant) islandModel[i][j].get("Plant").get(random.nextInt(0, islandModel[i][j].get("Plant").size() - 1)));
                    }
                }

            }
        }
    }

    public static void getStatistic() {
        System.out.println("На карте находится :");
        for (Animal a : listAnimal) {
            for (int i = 0; i < islandModel.length; i++) {
                for (int j = 0; j < islandModel[i].length; j++) {
                    for (int k = 0; k < islandModel[i][j].get(a.getNameClass()).size(); k++) {
                        ((Animal) islandModel[i][j].get(a.getNameClass()).get(k)).hunger();
                    }
                }
            }
            System.out.print(a.getNameClass() + ":" + a.getCountOnModel() + " ");
        }
        System.out.println();
    }
}