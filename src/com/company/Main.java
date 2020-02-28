package com.company;

import com.company.logic.Game;
import com.company.builder.GameBuilder;
import com.company.builder.ClassicalHardcodedGameBuilder;

public class Main {

    public static void main(String[] args) {
        GameBuilder gb = new ClassicalHardcodedGameBuilder();
        Game snlGame = gb.buildGame();
        //System.out.println(snlGame.getGameboard());
        snlGame.play();
    }
}
