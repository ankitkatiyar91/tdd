package service;

import model.Move;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RuleEngineTest {

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedWhenMoveIsNull() {
        RuleEngine ruleEngine = new RuleEngine();
        ruleEngine.scores(null, null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedWhenOneMoveIsNull() {
        RuleEngine ruleEngine = new RuleEngine();
        ruleEngine.scores(null, Move.CHEAT);
    }

    @Test
    public void shouldReturnZeroWhenBothCheat() {
        RuleEngine ruleEngine = new RuleEngine();
        assertThat(ruleEngine.scores(Move.CHEAT, Move.CHEAT), is(new Integer[]{0, 0}));
    }

    @Test
    public void shouldReturnThreeAndMinusOneForCheatAndCooperate() {
        RuleEngine ruleEngine = new RuleEngine();
        assertThat(ruleEngine.scores(Move.CHEAT, Move.COOPERATE), is(new Integer[]{3, -1}));
    }

    @Test
    public void shouldReturnMinusOneAndThreeForCooperateCheat() {
        RuleEngine ruleEngine = new RuleEngine();
        assertThat(ruleEngine.scores(Move.COOPERATE, Move.CHEAT), is(new Integer[]{-1, 3}));
    }

    @Test
    public void shouldReturnTwoAndTwoForCooperateCheat() {
        RuleEngine ruleEngine = new RuleEngine();
        assertThat(ruleEngine.scores(Move.COOPERATE, Move.COOPERATE), is(new Integer[]{2, 2}));
    }
}
