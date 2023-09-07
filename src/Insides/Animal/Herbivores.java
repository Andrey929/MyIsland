package Insides.Animal;

import Insides.Plant.Plant;

public abstract class Herbivores extends Animal {
    public Herbivores(float weight, int maxStep, float saturation, float saturation_required) {
        super(weight, maxStep, saturation, saturation_required);
    }

    public abstract void eatPlant(Plant plant);
}
