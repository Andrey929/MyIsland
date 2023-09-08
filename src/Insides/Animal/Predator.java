package Insides.Animal;

public abstract class Predator extends Animal {
    public Predator(float weight, int maxStep, float saturation, float saturation_required, int x, int y) {
        super(weight, maxStep, saturation, saturation_required,x,y);
    }

    abstract void eatAnimal(Animal animal);
    }

