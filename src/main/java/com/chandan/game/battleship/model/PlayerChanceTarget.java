package com.chandan.game.battleship.model;

import com.chandan.game.battleship.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerChanceTarget {
    final Player targetPlayer;
    final Coordinate target;
}
