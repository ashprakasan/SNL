package com.company.logic.classicalgame;

import com.company.logic.DiceRoller;
import com.company.logic.Game;
import com.company.logic.classicalgame.ClassicalDiceRoller;
import com.company.model.GameBoard;
import com.company.model.Move;
import com.company.model.classicalgame.ClassicalSNLBoard;
import com.company.model.classicalgame.Player;
import com.company.model.classicalgame.Position;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClassicalSNLGame extends Game {
    public ClassicalSNLGame(List<Player> players, GameBoard gameBoard, DiceRoller diceRoller) {
        super(players, gameBoard, diceRoller);
    }

    @Override
    public void play() {
        DiceRoller diceRoller = new ClassicalDiceRoller();
        Move nextMove;
        boolean gameOver = false;
        while(!gameOver) {
            for (Player p : getPlayers()) {
                System.out.println(p.getName() + "'s move");
                int diceRoll = diceRoller.roll();
                System.out.println("DiceRoll : " + diceRoll);
                nextMove = new Move(new Position(getGameboard().getPlayerPosition(p).getPos() + diceRoll));
                setGameboard(getGameboard().movePlayer(p, nextMove));
                System.out.println(p.getName() + " moved to position " + getGameboard().getPlayerPosition(p));
                if (isOver()) {
                    System.out.println("**********Game is over***********");
                    declareWinner();
                    System.out.println("Press any key to exit.");
                    Scanner s = new Scanner(System.in);
                    String in = s.next();
                    gameOver = true;
                    break;
                } else {
                    System.out.println("Continuing ................................");
                }
            }
        }
    }

    @Override
    public boolean isOver() {
        ClassicalSNLBoard gameBoard = (ClassicalSNLBoard) getGameboard();
        return gameBoard.isGameOver();
    }

    @Override
    public void declareWinner() {
        ClassicalSNLBoard gameBoard = (ClassicalSNLBoard) getGameboard();
        Optional<Player> winner = gameBoard.getWinner();
        if (winner.isPresent()) {
            System.out.println("!!!!!!!!!!!!!!!!!! Winner is " + winner.get().getName() + "!!!!!!!!!!!!!!!!!!!!!!!");
        } else {
            System.out.println("There is no winner in this game.");
        }
    }
}
