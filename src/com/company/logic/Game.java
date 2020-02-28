package com.company.logic;

import com.company.model.GameBoard;
import com.company.model.classicalgame.Player;

import java.util.List;

public abstract class Game {
    private List<Player> players;

    public Game(List<Player> players, GameBoard gameboard, DiceRoller diceroller) {
        this.players = players;
        this.gameboard = gameboard;
        this.diceroller = diceroller;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameBoard getGameboard() {
        return gameboard;
    }

    public void setGameboard(GameBoard gb) {
        this.gameboard = gb;
    }

    public DiceRoller getDiceroller() {
        return diceroller;
    }

    private GameBoard gameboard;
    private DiceRoller diceroller;

    public abstract void play();
    public abstract boolean isOver();
    public abstract void declareWinner();
}
