package service;

import model.Move;

public class CopyCatMoveGenerator implements MoveGenerator {

    private boolean first = true;

    @Override
    public Move nextMove(Move otherPlayersLastMove) {
        if (first) {
            first = false;
            return Move.COOPERATE;
        }
        return otherPlayersLastMove;
    }
}
