package service;

import model.Move;

public class AllCooperateMoveGenerator implements MoveGenerator {
    @Override
    public Move nextMove(Move otherPlayersLastMove) {
        return Move.COOPERATE;
    }
}
