package com.company.model;

public abstract class Dice {
    int numFaces;

    public Dice(int numFaces) {
        this.numFaces = numFaces;
    }
    public int getNumFaces() {
        return numFaces;
    }
}
