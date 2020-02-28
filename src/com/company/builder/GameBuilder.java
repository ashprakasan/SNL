package com.company.builder;

import com.company.logic.DiceRoller;
import com.company.logic.Game;
import com.company.model.GameBoard;
import com.company.model.classicalgame.Player;

import java.util.List;

abstract public class GameBuilder {
    public abstract GameBoard buildGameboard();
    public abstract DiceRoller buildDiceRoller();
    public abstract List<Player> buildPlayerList();
    public abstract Game buildGame();
}
