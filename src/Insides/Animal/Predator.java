package Insides.Animal;

import Insides.Animal.Herbivoress.Rabbit;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static Source.Island.islandModel;

public abstract class Predator extends Animal {
    ArrayList<Animal> whoCanEats = new ArrayList<>();
    public Predator(String nameClass,float weight, int maxStep,
                    float saturation, float saturation_required, float hungerForOneTime, float deadly_saturation,
                    int x, int y) {
        super(nameClass, weight, maxStep, saturation, saturation_required, hungerForOneTime, deadly_saturation, x, y);
    }
    public Predator(String name){
        super(name);
    }
    public ArrayList<Animal> getWhoCanEats() {
        return whoCanEats;
    }
    public int getCountWhoCanEats(){
        return whoCanEats.size();
    }

    public void setWhoCanEats(ArrayList<Animal> whoCanEat) {
        this.whoCanEats = whoCanEat;
    }

    public Predator() {
    }

    public abstract double chanceOnEat(Animal animal);


    public void eatAnimal(Animal animal) {
        if (this.getX() == animal.getX() && this.getY() == animal.getY()) {
            if (this.chanceOnEat(animal) > ThreadLocalRandom.current().nextInt(0, 100)) {
                if (this.getSaturation() < this.getSaturation_required()) {
                    if (animal.getWeight() + this.getSaturation() > this.getSaturation_required()) {
                        this.setSaturation(this.getSaturation_required());
                    } else {
                        this.setSaturation(this.getSaturation() + animal.getWeight());
                    }
                    islandModel[animal.getX()][animal.getY()].get(animal.getNameClass()).remove(animal);
                }
            }
        }
    }

}


