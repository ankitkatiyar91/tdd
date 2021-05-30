package model;

import service.AllCooperateMoveGenerator;

public class SweetPerson extends Player {

    public SweetPerson(String name) {
        super(name, new AllCooperateMoveGenerator());
    }
}
