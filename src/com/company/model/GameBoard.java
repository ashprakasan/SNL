package com.company.model;

import com.company.model.classicalgame.Player;
import com.company.model.classicalgame.Position;
import com.company.interfaces.Actor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GameBoard {
    protected final List<Player> players;
    protected final List<Actor> actors;
    protected final List<Position> playerPositions;
    protected final Position maxPositionOnBoard;

    public GameBoard(List<Player> players, List<Actor> actors, List<Position> playerPositions, Position maxCell) {
        for (Actor actor : actors) {
            playerPositions = playerPositions.stream().map(actor::act).collect(Collectors.toList());
        }
        this.players = Collections.unmodifiableList(players);
        this.actors = Collections.unmodifiableList(actors);
        this.playerPositions = Collections.unmodifiableList(playerPositions);
        this.maxPositionOnBoard = maxCell;
    }

    public List<Position> getAllPlayerPositions() {
        return new ArrayList<>(playerPositions);
    }

    public Position getPlayerPosition (Player p) throws IllegalStateException{
         for (int i=0;i<players.size();i++){
             if(players.get(i).getName().equals(p.getName())){
                 return playerPositions.get(i);
             }
         }
         throw new IllegalStateException("Player "+p+" is not on the board");
    }

    public Position getMaxPositionOnBoard(){
        return maxPositionOnBoard;
    }

    public abstract GameBoard movePlayer(Player p, Move move);

    public abstract Boolean isLegal (Move move);
}
