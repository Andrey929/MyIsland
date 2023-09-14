package Insides.Animal;

import Insides.Animal.Herbivoress.Rabbit;

import java.util.concurrent.ThreadLocalRandom;

import static Source.Island.islandModel;

public abstract class Predator extends Animal {
    public Predator(String nameClass,float weight, int maxStep, float saturation, float saturation_required, int x, int y) {
        super(nameClass,weight, maxStep, saturation, saturation_required, x, y);
    }

    public Predator() {
    }

    public abstract double chanceOnEat(Animal animal);

    public void eatAnimal(Animal animal) {

        if (animal instanceof Rabbit) {
            if (this.chanceOnEat(animal) > ThreadLocalRandom.current().nextInt(0, 100)) {
                if (this.getSaturation() < this.getSaturation_required()) {
                    if (animal.getWeight() + this.getSaturation() > this.getSaturation_required()) {
                        this.setSaturation(this.getSaturation_required());
                    }else {
                        this.setSaturation(this.getSaturation() + animal.getWeight());
                    }
                    islandModel[animal.getX()][animal.getY()].get(animal.getNameClass()).remove(animal);
                }
            }
        }
    }
}


