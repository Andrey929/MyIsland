package Insides.Animal;

import Insides.Plant.Plant;

public abstract class Herbivores extends Animal {
    public Herbivores(String nameClass,float weight, int maxStep,
                      float saturation, float saturation_required,float hungerForOneTime,float deadly_saturation,
                      int x, int y) {
        super(nameClass,weight, maxStep, saturation, saturation_required,hungerForOneTime,deadly_saturation,x,y);
    }
    public Herbivores(){}

    public abstract boolean eatPlant(Plant plant);
}
