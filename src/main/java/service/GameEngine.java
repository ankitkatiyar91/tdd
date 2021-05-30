package service;

import model.Move;
import model.Player;
import model.ScoreCard;

public class GameEngine {

    private ScoreCard scoreCard;
    private RuleEngine ruleEngine;

    public GameEngine(ScoreCard scoreCard, RuleEngine ruleEngine) {
        this.scoreCard = scoreCard;
        this.ruleEngine = ruleEngine;
    }

    public void play(Player player1, Player player2) {
        scoreCard.initScoreCard(player1, player2);
        Integer[] scores;
        Move lastMovePlayer1 = null, lastMovePlayer2 = null;

        System.out.println("Round " + player1.getName() + " " + player2.getName());

        for (int move = 0; move < 5; move++) {
            final Move move1 = player1.nextMove(lastMovePlayer2);
            final Move move2 = player2.nextMove(lastMovePlayer1);

            scores = ruleEngine.scores(move1, move2);

            lastMovePlayer1 = move1;
            lastMovePlayer2 = move2;
            scoreCard.updateScore(player1, scores[0]);
            scoreCard.updateScore(player2, scores[1]);

            System.out.println(move + " \t" + scoreCard.getScore(player1).get() + "\t" + scoreCard.getScore(player2).get());
        }

    }
}
