package com.company.model.classicalgame;

import com.company.model.GameBoard;
import com.company.model.Move;
import com.company.interfaces.Actor;

import java.util.List;
import java.util.Optional;

public class ClassicalSNLBoard extends GameBoard {
    private final boolean gameOver;
    private final Optional<Player> winner;

    public ClassicalSNLBoard(List<Player> players, List<Actor> actors, List<Position> playerPositions, Position maxCell) {
        super(players, actors, playerPositions, maxCell);
        for (Player p : players) {
            Position pos = getPlayerPosition(p);
            if (pos.getPos().equals(getMaxPositionOnBoard().getPos()))
            {
                this.gameOver = true;
                this.winner = Optional.ofNullable(p);
                return;
            }
        }
        this.gameOver = false;
        this.winner = Optional.empty();
    }

    @Override
    public GameBoard movePlayer(Player p, Move move) {
        Position newPosition = move.getPosition();
        int currPlayerInd = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(p.getName())) {
                currPlayerInd = i;
                break;
            }
        }
        if (currPlayerInd == -1)
            throw new IllegalArgumentException("Player with this name was not found on the board.");

        List<Position> currPlayerPositions = getAllPlayerPositions();
        if (newPosition.getPos() <= maxPositionOnBoard.getPos()) {
            currPlayerPositions.set(currPlayerInd, newPosition);
        }
        return new ClassicalSNLBoard(players, actors, currPlayerPositions, maxPositionOnBoard);
    }

    @Override
    public Boolean isLegal(Move move) {
        return (move.getPosition().getPos() > maxPositionOnBoard.getPos());
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Optional<Player> getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("MaxCell " + maxPositionOnBoard + "\n").append("\nActors : \n");
        for (Actor a : actors) {
            sb.append(a + "\n");
        }
        sb.append("\nPlayer Positions \n");
        for (int i = 0; i < players.size(); i++) {
            sb.append("Player " + players.get(i).getName() + " is at position " + playerPositions.get(i) + "\n");
        }
        return sb.toString();
    }
}
