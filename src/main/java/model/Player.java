package model;

import service.MoveGenerator;

public abstract class Player {
    private String name;
    protected MoveGenerator moveGenerator;

    protected Player(String name, MoveGenerator moveGenerator) {
        this.name = name;
        this.moveGenerator = moveGenerator;
    }

    public String getName() {
        return name;
    }

    public Move nextMove(Move otherPlayersLastMove) {
        return moveGenerator.nextMove(otherPlayersLastMove);
    }
}
