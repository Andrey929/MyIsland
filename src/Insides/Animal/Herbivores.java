package Insides.Animal;

import Insides.Plant.Plant;

public abstract class Herbivores extends Animal {
    public Herbivores(float weight, int maxStep, float saturation, float saturation_required, int x, int y) {
        super(weight, maxStep, saturation, saturation_required,x,y);
    }
    public Herbivores(){}

    public abstract void eatPlant(Plant plant);
}
