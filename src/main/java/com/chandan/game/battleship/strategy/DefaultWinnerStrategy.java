package com.chandan.game.battleship.strategy;

import com.chandan.game.battleship.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class DefaultWinnerStrategy implements IWinnerStrategy {
    @Override
    public Player getWinner(List<Player> playerList) {
        final List<Player> alivePlayers = new ArrayList<>();
        for(Player player: playerList) {
            if(!player.areAllShipsKilled()) {
                alivePlayers.add(player);
            }
        }
        if(alivePlayers.size() == 1) {
            return alivePlayers.get(0);
        }
        return null;
    }
}
