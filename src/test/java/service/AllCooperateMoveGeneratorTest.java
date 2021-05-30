package service;

import model.Move;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AllCooperateMoveGeneratorTest {

    @Test
    public void alwaysMoveCooperate() {
        MoveGenerator moveGenerator = new AllCooperateMoveGenerator();
        assertThat(moveGenerator.nextMove(), is(Move.COOPERATE));
        assertThat(moveGenerator.nextMove(), is(Move.COOPERATE));
    }
}
