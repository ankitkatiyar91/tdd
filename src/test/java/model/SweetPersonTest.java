package model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SweetPersonTest {

    @Test
    public void shouldAlwaysCooperate() {
        Player sweet = new SweetPerson("Sweet");

        assertThat(sweet.nextMove(), is(Move.COOPERATE));
        assertThat(sweet.nextMove(), is(Move.CHEAT));
    }

}
