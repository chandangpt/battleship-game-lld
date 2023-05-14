package com.chandan.game.battleship.model.player;

import com.chandan.game.battleship.model.Board;
import com.chandan.game.battleship.model.Coordinate;
import com.chandan.game.battleship.model.PlayerChanceTarget;
import com.chandan.game.battleship.strategy.IChanceGenerationStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
@Getter
@AllArgsConstructor
public class Player {
    private final Board board;
    private final int id;
    private final IChanceGenerationStrategy chanceGenerationStrategy;

    public PlayerChanceTarget takeChance(List<Player> players) {
        List<Player> opponents = new ArrayList<>();
        for(Player player: players) {
            if(player.getId() != this.getId()) {
                opponents.add(player);
            }
        }
        return chanceGenerationStrategy.getPlayerChanceTarget(opponents);
    }

    public boolean areAllShipsKilled() {
        return board.areAllShipsKilled();
    }

    public void takeHit(@NonNull final Coordinate coordinate) {
        board.takeHit(coordinate);
    }
}
