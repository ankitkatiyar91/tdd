package model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheaterTest {

    @Test
    public void shouldAlwaysCheat() {
        Player cheater = new Cheater("Cheater");

        assertThat(cheater.nextMove(), is(Move.CHEAT));
        assertThat(cheater.nextMove(), is(Move.CHEAT));
    }
}
