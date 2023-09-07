package Insides.Animal;

import Insides.MyIslandСycle;

public abstract class Animal implements MyIslandСycle {
    private float weight;
    private int maxStep;
    private float Saturation;
    private float Saturation_required;

    public Animal(float weight, int maxStep, float saturation, float saturation_required) {
        this.weight = weight;
        this.maxStep = maxStep;
        Saturation = saturation;
        Saturation_required = saturation_required;
    }

    public abstract void moveTo();

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getMaxStep() {
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
}
