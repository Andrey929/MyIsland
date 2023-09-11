package Insides.Animal.Predators;

import Insides.Animal.Animal;
import Insides.Animal.Predator;

public class Wolf extends Predator {
    public static void ex(Wolf wolf){
        System.out.println(wolf.getX());
    }
    public Wolf(int x, int y) {
        super(50, 3, 8, 8, x, y);
    }

    @Override
    public void moveTo(Animal animal) {

    }

    @Override
    public void run() {

    }

    @Override
    protected void eatAnimal(Animal animal) {

    }
}
