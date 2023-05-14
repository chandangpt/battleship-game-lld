package com.chandan.game.battleship.strategy;

import com.chandan.game.battleship.model.PlayerChanceTarget;
import com.chandan.game.battleship.model.player.Player;

import java.util.List;

public interface IChanceGenerationStrategy {
    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents);
}
