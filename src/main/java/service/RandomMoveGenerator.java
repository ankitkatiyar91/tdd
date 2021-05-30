package service;

import model.Move;

import java.util.Random;

public class RandomMoveGenerator implements MoveGenerator {

    private Random random;

    public RandomMoveGenerator() {
        this.random = new Random();
    }

    @Override
    public Move nextMove(Move otherPlayersLastMove) {
        return Move.values()[(random.nextInt(100) % Move.values().length)];
    }
}
