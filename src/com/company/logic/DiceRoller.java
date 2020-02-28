package com.company.logic;

import com.company.model.Dice;
import com.company.interfaces.RollingStrategy;

public abstract class DiceRoller implements RollingStrategy {
    protected Dice dice;

    public DiceRoller(Dice dice){
        this.dice = dice;
    }

}
