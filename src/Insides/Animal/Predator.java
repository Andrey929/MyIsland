package Insides.Animal;

public abstract class Predator extends Animal {
    public Predator(float weight, int maxStep, int saturation, int saturation_required) {
        super(weight, maxStep, saturation, saturation_required);
    }

    abstract void eatAnimal(Animal animal);
    }

