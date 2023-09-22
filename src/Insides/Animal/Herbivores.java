package Insides.Animal;

import Insides.Plant.Plant;

public abstract class Herbivores extends Animal {
    public Herbivores(String nameClass, float weight, int maxStep,
                      float saturation, float saturation_required, float hungerForOneTime, float deadly_saturation,
                      int x, int y) {
        super(nameClass, weight, maxStep, saturation, saturation_required, hungerForOneTime, deadly_saturation, x, y);
    }

    public Herbivores() {
    }

    public boolean eatPlant(Plant plant) {
        if (this.getX() == plant.getX() && this.getY() == plant.getY()) {
            if (this.getSaturation() < this.getSaturation_required()) {
                if (plant.getWeight() + this.getSaturation() > this.getSaturation_required()) {
                    this.setSaturation(this.getSaturation_required());
                    plant.setWeight(plant.getWeight() - (this.getSaturation_required() - this.getSaturation()));
                } else if (plant.getWeight() >= this.getSaturation_required()) {
                    plant.setWeight(plant.getWeight() - (this.getSaturation_required() - this.getSaturation()));
                    this.setSaturation(this.getSaturation_required());
                    return true;
                } else {
                    this.setSaturation(this.getSaturation() + plant.getWeight());
                    plant.setWeight(0);
                    return true;
                }
            } else {
                return true;
            }
        } else return false;
        return false;
    }
}
