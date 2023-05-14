package com.chandan.game.battleship.model;

import com.chandan.game.battleship.model.boundary.IBoundary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class BoardItem {
    private final String name;
    private final IBoundary boundary;

    public boolean isKilled(@NonNull final List<Coordinate> hitLocations) {
        final List<Coordinate> shipCoordinates = boundary.allCoordinates();
        for(Coordinate coordinate : shipCoordinates) {
            if(!hitLocations.contains(coordinate)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsCoordinate(@NonNull final Coordinate coordinate) {
        return this.boundary.contains(coordinate);
    }
}
