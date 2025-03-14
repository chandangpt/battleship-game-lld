package com.chandan.game.battleship;

import com.chandan.game.battleship.exceptions.CoordinateOutOfBoundaryException;
import com.chandan.game.battleship.io.output.IOutputPrinter;
import com.chandan.game.battleship.model.PlayerChanceTarget;
import com.chandan.game.battleship.model.player.Player;
import com.chandan.game.battleship.strategy.IPlayerPickingStrategy;
import com.chandan.game.battleship.strategy.IWinnerStrategy;
import lombok.NonNull;

import java.util.List;

public class GameLoop {
    private final List<Player> players;
    private final IWinnerStrategy winnerStrategy;
    private final IOutputPrinter printer;
    private final IPlayerPickingStrategy nextPlayerStrategy;

    public GameLoop(@NonNull final List<Player> players, @NonNull final IWinnerStrategy winnerStrategy, @NonNull IOutputPrinter printer, @NonNull final IPlayerPickingStrategy nextPlayerStrategy) {
        this.players = players;
        this.winnerStrategy = winnerStrategy;
        this.printer = printer;
        this.nextPlayerStrategy = nextPlayerStrategy;
    }

    public void start() {
        int currentPlayerIndex = nextPlayerStrategy.firstPlayer(this.players);
        printer.printMsg("Starting game!");
        while(true) {
            final Player currentPlayer = players.get(currentPlayerIndex);
            printer.printMsg("\n\nPlayer: " + currentPlayer.getId() + " chance:");
            final PlayerChanceTarget playerChanceTarget = currentPlayer.takeChance(this.players);
            try {
                playerChanceTarget.getTargetPlayer().takeHit(playerChanceTarget.getTarget());
            } catch (CoordinateOutOfBoundaryException exception) {
                printer.printMsg("Hit was out of bounds.");
            }
            printer.printSelfBoard(currentPlayer);
            printer.printOpponentBoard(players, currentPlayer);
            final Player winner = winnerStrategy.getWinner(players);
            if(winner != null) {
                printer.printWinner(winner);
                break;
            }
            currentPlayerIndex = nextPlayerStrategy.pickNextPlayer(currentPlayerIndex, this.players);
        }
    }
}
