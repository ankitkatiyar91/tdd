package model;

import service.RandomMoveGenerator;

public class RandomPlayer extends Player {

    public RandomPlayer(String name) {
        super(name, new RandomMoveGenerator());
    }
}
