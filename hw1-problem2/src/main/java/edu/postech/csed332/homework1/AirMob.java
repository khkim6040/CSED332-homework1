package edu.postech.csed332.homework1;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * An air monster that moves towards the goal position of the board while satisfying
 * the game board invariants. The class AirMob implements the interface Monster.
 * <p>
 * TODO: implement all unimplemented methods.
 * Feel free to modify this file, e.g. add new fields or methods. If necessary,
 * you can define a new (abstract) superclass that this class inherits. In this case,
 * some methods can be moved to the abstract class.
 *
 * @see GameBoard#isValidBoard
 */
public class AirMob implements Monster {
    GameBoard board;
    public AirMob(GameBoard gameBoard) {
        this.board = gameBoard;
    }

    @Override
    public boolean isGround() {
        return false;
    }

    @Override
    public GameBoard getBoard() {
        return board;
    }

    @Override
    public Position move() {
        return getPosition();
    }
}
