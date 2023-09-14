package Insides.Animal;

import Insides.MyIslandCycle;
import Insides.Plant.Plant;
import Source.Island;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static Source.Island.islandModel;

public abstract class Animal implements MyIslandCycle,Runnable{
    private String nameClass;
    private float weight;
    private  int maxStep;
    private float Saturation;
    private float Saturation_required;
    private int X;
    private int Y;
    public Animal(){}

    public Animal(String nameClass,float weight, int maxStep, float saturation, float saturation_required, int x, int y) {
        this.weight = weight;
        this.maxStep = maxStep;
        this.nameClass = nameClass;
        Saturation = saturation;
        Saturation_required = saturation_required;
        X = x;
        Y = y;
    }

    public String getNameClass() {
        return nameClass;
    }

    public  int getX() {
        return X;
    }

    public  void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public  void setY(int y) {
        Y = y;
    }

    public abstract void moveTo(Animal animal);
    protected abstract void move(Animal animal, int x2, int y2);
    public void moves(){
        System.out.println(this.nameClass);
        for (int i = 0; i < islandModel.length; i++) {
            for (int j = 0; j < islandModel[i].length; j++) {
                for (int k = 0; k < islandModel[i][j].get(this.nameClass).size(); k++) {
                    moveTo((Animal) islandModel[i][j].get(this.nameClass).get(k));
                }
            }
        }
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public  int getMaxStep() {
        return maxStep;
    }

    public void setMaxStep(int maxStep) {
        this.maxStep = maxStep;
    }

    public float getSaturation() {
        return Saturation;
    }

    public void setSaturation(float saturation) {
        Saturation = saturation;
    }

    public float getSaturation_required() {
        return Saturation_required;
    }

    public void setSaturation_required(float saturation_required) {
        Saturation_required = saturation_required;
    }

    @Override
    public abstract void run();

    public static int getCountInCell(int x,int y,String name) {
        return islandModel[x][y].get(name).size();
    }
}
