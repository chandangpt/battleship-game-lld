package com.chandan.game.battleship.strategy;

import com.chandan.game.battleship.exceptions.InvalidInputException;
import com.chandan.game.battleship.model.player.Player;

import java.util.List;

public class RoundRobinPlayerPickingStrategy implements IPlayerPickingStrategy {
    @Override
    public Integer firstPlayer(List<Player> allPlayers) {
        if(allPlayers.size() == 0) {
            throw new InvalidInputException();
        }
        return 0;
    }

    @Override
    public Integer pickNextPlayer(Integer currentPlayerIndex, List<Player> allPlayers) {
        return (currentPlayerIndex + 1) % allPlayers.size();
    }
}
