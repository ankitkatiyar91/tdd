package model;

import exception.PlayerNotFound;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ScoreCardTest {

    @Test
    public void shouldInitializeScoreCardWithNoPlayers() {
        final ScoreCard scoreCard = ScoreCard.getScoreCard();
        assertNotNull(scoreCard);
    }

    @Test
    public void shouldInitializeScoreCardWithOnePlayers() {
        final ScoreCard scoreCard = ScoreCard.getScoreCard();
        final Player player = new RandomPlayer("P1");

        scoreCard.initScoreCard(player);

        final Optional<Integer> player1Score = scoreCard.getScore(player);
        assertTrue(player1Score.isPresent());
        assertThat(player1Score.get(), is(0));
    }

    @Test
    public void shouldInitializeScoreCardWithTwoPlayers() {
        final ScoreCard scoreCard = ScoreCard.getScoreCard();
        final Player player1 = new RandomPlayer("P1");
        final Player player2 = new RandomPlayer("P2");

        scoreCard.initScoreCard(player1, player2);
        final Optional<Integer> player1Score = scoreCard.getScore(player1);
        assertTrue(player1Score.isPresent());
        assertThat(player1Score.get(), is(0));

        final Optional<Integer> player2Score = scoreCard.getScore(player2);
        assertTrue(player2Score.isPresent());
        assertThat(player2Score.get(), is(0));
    }

    @Test
    public void shouldReturnEmptyWhenInitializedWithNoPlayer() {
        final ScoreCard scoreCard = ScoreCard.getScoreCard();

        scoreCard.initScoreCard();

        final Optional<Integer> player1Score = scoreCard.getScore(new RandomPlayer("p1"));
        assertFalse(player1Score.isPresent());
    }


    @Test
    public void shouldReturnEmptyWhenCheckedScoreForNullPLayer() {
        final ScoreCard scoreCard = ScoreCard.getScoreCard();

        scoreCard.initScoreCard();

        final Optional<Integer> player1Score = scoreCard.getScore(null);
        assertFalse(player1Score.isPresent());
    }

    @Test
    public void shouldUpdateScoreCardWithTwoPlayers() {
        final ScoreCard scoreCard = ScoreCard.getScoreCard();
        final Player player1 = new RandomPlayer("P1");
        final Player player2 = new RandomPlayer("P2");

        scoreCard.initScoreCard(player1, player2);
        scoreCard.updateScore(player1, 2);
        scoreCard.updateScore(player2, -2);

        final Optional<Integer> player1Score = scoreCard.getScore(player1);
        assertTrue(player1Score.isPresent());
        assertThat(player1Score.get(), is(2));

        final Optional<Integer> player2Score = scoreCard.getScore(player2);
        assertTrue(player2Score.isPresent());
        assertThat(player2Score.get(), is(-2));
    }

    @Test(expected = PlayerNotFound.class)
    public void shouldThrowPlayerNotFoundWhenUpdatingUnknownPlayer() {
        final ScoreCard scoreCard = ScoreCard.getScoreCard();
        final Player player1 = new RandomPlayer("P1");

        scoreCard.initScoreCard();
        scoreCard.updateScore(player1, 1);
    }
}
