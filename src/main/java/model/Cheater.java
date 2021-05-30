package model;

import service.AllCheatMoveGenerator;

public class Cheater extends Player {
    public Cheater(String name) {
        super(name,new AllCheatMoveGenerator());
    }
}

