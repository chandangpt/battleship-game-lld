package com.chandan.game.battleship.strategy;

import com.chandan.game.battleship.exceptions.InvalidInputException;
import com.chandan.game.battleship.io.input.IInputProvider;
import com.chandan.game.battleship.io.input.PlayerInput;
import com.chandan.game.battleship.model.Coordinate;
import com.chandan.game.battleship.model.PlayerChanceTarget;
import com.chandan.game.battleship.model.player.Player;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor

public class LocalChanceGeneration implements IChanceGenerationStrategy {
    private final IInputProvider inputProvider;
    @Override
    public PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents) {
        final PlayerInput playerInput = inputProvider.takeInput();
        Player targetPlayer = null;
        for(Player player: opponents) {
            if(player.getId() == playerInput.getPlayerNum()) {
                targetPlayer = player;
                break;
            }
        }
        if(targetPlayer == null) {
            throw new InvalidInputException();
        }
        return new PlayerChanceTarget(targetPlayer, new Coordinate(playerInput.getTargetX(), playerInput.getTargetY()));
    }
}
