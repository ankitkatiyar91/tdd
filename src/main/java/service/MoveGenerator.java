package service;

import model.Move;

public interface MoveGenerator {

    public Move nextMove(Move otherPlayersLastMove);
}
