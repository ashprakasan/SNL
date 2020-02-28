package com.company.model.classicalgame;

import com.company.interfaces.Actor;

public class Ladder implements Actor {
    Position startPos, endPos;

    @Override
    public String toString() {
        return "Ladder from " + startPos + " to" + endPos;
    }

    public Ladder(Position startPos, Position endPos) throws IllegalArgumentException {
        if(endPos.getPos()<=startPos.getPos()) {
            throw new IllegalArgumentException("Start of a ladder cannot be less than the end");
        }
        this.startPos = startPos;
        this.endPos = endPos;
    }

    @Override
    public Position act(Position currentPosition) {
        if (currentPosition.getPos().equals(startPos.getPos())) {
            return endPos;
        }
        return currentPosition;
    }
}
