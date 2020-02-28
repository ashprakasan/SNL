package com.company.model.classicalgame;

public class Position {

    public Position(Integer pos) {
        this.pos = pos;
    }

    Integer pos;

    @Override
    public String toString() {
        return "" + pos;
    }

    public Integer getPos() {
        return pos;
    }
}
