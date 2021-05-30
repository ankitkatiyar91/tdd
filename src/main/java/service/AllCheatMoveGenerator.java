package service;

import model.Move;

public class AllCheatMoveGenerator implements MoveGenerator {
    @Override
    public Move nextMove(Move otherPlayersLastMove) {
        return Move.CHEAT;
    }
}
