package Source;

import Insides.Animal.Animal;
import Insides.Animal.Herbivores;
import Insides.Animal.Herbivoress.*;
import Insides.Animal.Predator;
import Insides.Animal.Predators.*;
import Insides.Plant.PlantsThread;

import java.util.ArrayList;

public class Population {
    static ArrayList<Runnable> task = new ArrayList<>();
    static ArrayList<Animal> listAnimal = new ArrayList<>();
    static ArrayList<Herbivores> herbivores = new ArrayList<>();
    static ArrayList<Predator> predators = new ArrayList<>();
    static {
        task.add(new Rabbit());
        listAnimal.add(new Rabbit());
        task.add(new Buffalo());
        listAnimal.add(new Buffalo());
        task.add(new Caterpillar());
        listAnimal.add(new Caterpillar());
        task.add(new Deer());
        listAnimal.add(new Deer());
        task.add(new Duck());
        listAnimal.add(new Duck());
        task.add(new Goat());
        listAnimal.add(new Goat());
        task.add(new Horse());
        listAnimal.add(new Horse());
        task.add(new Mouse());
        listAnimal.add(new Mouse());
        task.add(new Pig());
        listAnimal.add(new Pig());
        task.add(new Sheep());
        listAnimal.add(new Sheep());
        task.add(new Bear());
        listAnimal.add(new Bear());
        task.add(new Eagle());
        listAnimal.add(new Eagle());
        task.add(new Fox());
        listAnimal.add(new Fox());
        task.add(new Snake());
        listAnimal.add(new Snake());
        task.add(new Wolf());
        listAnimal.add(new Wolf());
        task.add(new PlantsThread());

        for (Animal a: listAnimal) {
            if (a instanceof Predator) {
                predators.add((Predator) a);
            }else {
                herbivores.add((Herbivores) a);
            }
        }
    }
}
