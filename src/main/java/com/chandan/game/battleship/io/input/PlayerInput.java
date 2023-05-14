package com.chandan.game.battleship.io.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerInput {
    private final Integer playerNum;
    private final Integer targetX;
    private final Integer targetY;
}
