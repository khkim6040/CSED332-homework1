package edu.postech.csed332.homework1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * An implementation of GameBoard that implements the interface GameBoard.
 * <p>
 * TODO: implements all the unimplemented methods (marked with TODO)
 * NOTE: Do not modify the signature of public methods (which are used for GUI
 * and grading). But feel free to add new fields or new private methods as needed.
 */
class GameBoardImpl implements GameBoard {
    private final int width, height;
    private Map<Position, Set<Unit>> board;

    // TODO add more fields to implement this class

    /**
     * Create a game board with a given width and height
     *
     * @param width  of this board
     * @param height of this board
     */
    public GameBoardImpl(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new HashMap<>();
        // TODO add more statements if necessary
    }

    @Override
    public void placeUnit(Unit obj, Position p) {
        // TODO: check isValidBoard()

        if(p.x() >= this.width || p.y() >= this.height) {
            throw new IllegalArgumentException("Invalid Position");
        }

        Set<Unit> unitsAtPosition = board.getOrDefault(p, new HashSet<>());
        for(Unit unit: unitsAtPosition) {
            // if unit's class is same as obj's class, then throw error
            if(unit.getClass() == obj.getClass()) {
                throw new IllegalStateException("Already exists SAME UNIT at this position");
            }
        }

        // increase 1 unit count of obj.getClass()
        unitsAtPosition.add(obj);
        board.put(p, unitsAtPosition);
    }

    @Override
    public void clear() {
        // TODO implement this
    }

    @Override
    public Set<Unit> getUnitsAt(Position p) {
        return board.getOrDefault(p, new HashSet<>());
    }

    @Override
    public Position getPosition(Unit obj) {
        for (Map.Entry<Position, Set<Unit>> entry : board.entrySet()) {
            if (entry.getValue().contains(obj)) {
                return entry.getKey();
            }
        }
        return null; // Unit not found on the board
    }

    @Override
    public void step() {
        // TODO implement this
    }

    @Override
    public boolean isValidBoard() {
        // TODO implement this
        return false;
    }

    @Override
    public Set<Monster> getMonsters() {
        Set<Monster> monsters = new HashSet<>();
        for (Set<Unit> unitSet : board.values()) {
            for (Unit unit : unitSet) {
                if (unit instanceof Monster) {
                    monsters.add((Monster) unit);
                }
            }
        }
        return monsters;
    }

    @Override
    public Set<Tower> getTowers() {
        Set<Tower> towers = new HashSet<>();
        for (Set<Unit> unitSet : board.values()) {
            for (Unit unit : unitSet) {
                if (unit instanceof Tower) {
                    towers.add((Tower) unit);
                }
            }
        }
        return towers;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getNumMobsKilled() {
        // TODO implement this
        return 0;
    }

    @Override
    public int getNumMobsEscaped() {
        // TODO implement this
        return 0;
    }
}
