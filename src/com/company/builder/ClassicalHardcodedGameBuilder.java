package com.company.builder;

import com.company.logic.classicalgame.ClassicalDiceRoller;
import com.company.logic.classicalgame.ClassicalSNLGame;
import com.company.logic.DiceRoller;
import com.company.logic.Game;
import com.company.model.GameBoard;
import com.company.interfaces.Actor;
import com.company.model.classicalgame.*;

import java.util.Arrays;
import java.util.List;

public class ClassicalHardcodedGameBuilder extends GameBuilder {
    @Override
    public GameBoard buildGameboard() {
        List<Player> playerList = buildPlayerList();

        //Hardcode actors
        Actor s1 = new Snake(new Position(14), new Position(3));
        Actor s2 = new Snake(new Position(16), new Position(8));
        Actor s3 = new Snake(new Position(19), new Position(4));

        //Hardcode ladders
        Actor l1 = new Ladder(new Position(10), new Position(15));
        Actor l2 = new Ladder (new Position(9), new Position(17));
        Actor l3 = new Ladder (new Position(5), new Position(13));

        List<Actor> actorList = Arrays.asList(s1, s2, s3, l1, l2, l3);


        //player positions all start from 0
        List<Position> playerPositions = Arrays.asList(new Position(0), new Position(0));

        //maxcell
        Position maxCell = new Position(20);

        return new ClassicalSNLBoard(playerList,actorList,playerPositions,maxCell);
    }

    @Override
    public DiceRoller buildDiceRoller() {
        return new ClassicalDiceRoller();
    }

    @Override
    public List<Player> buildPlayerList() {
        //Hardcode players
        Player p1 = new Player("Tushar");
        Player p2 = new Player("Ash");
        return Arrays.asList(p1, p2);
    }

    @Override
    public Game buildGame() {
        return new ClassicalSNLGame(buildPlayerList(),buildGameboard(),buildDiceRoller());
    }
}
