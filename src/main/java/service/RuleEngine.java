package service;

import model.Move;

public class RuleEngine {

    public Integer[] scores(Move move1, Move move2) {
        if (move1 == Move.CHEAT && move2 == Move.CHEAT) {
            return new Integer[]{0, 0};
        } else if (move1 == Move.CHEAT && move2 == Move.COOPERATE) {
            return new Integer[]{3, -1};
        } else if (move1 == Move.COOPERATE && move2 == Move.CHEAT) {
            return new Integer[]{-1, 3};
        } else if (move1 == Move.COOPERATE && move2 == Move.COOPERATE) {
            return new Integer[]{2, 2};
        }
        throw new UnsupportedOperationException();
    }
}
