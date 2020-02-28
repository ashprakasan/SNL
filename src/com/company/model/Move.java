package com.company.model;

import com.company.model.classicalgame.Position;

public class Move {
    Position position;

    public Move(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
