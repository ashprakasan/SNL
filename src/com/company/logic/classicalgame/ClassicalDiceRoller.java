package com.company.logic.classicalgame;

import com.company.logic.DiceRoller;
import com.company.model.classicalgame.ClassicalDice;

import java.util.Random;

public class ClassicalDiceRoller extends DiceRoller {

    public ClassicalDiceRoller(){
        super(new ClassicalDice());
    }
    @Override
    public int roll() {
        Random random = new Random();
        return random.nextInt(5)+1;
    }
}
