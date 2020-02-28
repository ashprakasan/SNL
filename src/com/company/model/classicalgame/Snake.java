package com.company.model.classicalgame;

import com.company.interfaces.Actor;

public class Snake implements Actor {
    Position startPos, endPos;
    public Snake(Position start, Position end){
        if (end.getPos() >= start.getPos()) {
            throw new IllegalArgumentException("End position of Snake cannot be greater than or equal to start position.");
        }
        startPos = start;
        endPos = end;
    }
    @Override
    public Position act(Position currentPosition) {
        if(currentPosition.getPos() == startPos.getPos())
            return endPos;
        return currentPosition;
    }

    @Override
    public String toString() {
        return "Snake from " + startPos + " to " + endPos;
    }
}
