package model;

import service.CopyCatMoveGenerator;

public class CopyCat extends Player {
    public CopyCat(String name) {
        super(name, new CopyCatMoveGenerator());
    }
}
