package Insides.Animal;

import Insides.Plant.Plant;

public abstract class Herbivores extends Animal {
    public Herbivores(String nameClass,float weight, int maxStep, float saturation, float saturation_required, int x, int y) {
        super(nameClass,weight, maxStep, saturation, saturation_required,x,y);
    }
    public Herbivores(){}

    public abstract boolean eatPlant(Plant plant);
}
