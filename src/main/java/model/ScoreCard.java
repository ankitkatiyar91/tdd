package model;

import exception.PlayerNotFound;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class ScoreCard {

    private Map<Player, Integer> playerScore = new HashMap<>();
    private static ScoreCard scoreCard = new ScoreCard();

    private ScoreCard() {
    }

    public ScoreCard initScoreCard(Player... players) {
        Arrays.stream(players).forEach(player ->
                scoreCard.playerScore.put(player, 0));
        return scoreCard;
    }

    public static ScoreCard getScoreCard() {
        return scoreCard;
    }

    public Optional<Integer> getScore(Player player) {
        return Optional.ofNullable(playerScore.get(player));
    }

    public void updateScore(Player player, Integer score) {
        if (playerScore.containsKey(player)) {
            playerScore.put(player, playerScore.get(player) + score);
        } else {
            throw new PlayerNotFound();
        }
    }
}

