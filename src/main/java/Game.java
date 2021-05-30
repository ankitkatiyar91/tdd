import model.Cheater;
import model.CopyCat;
import model.Player;
import model.ScoreCard;
import service.GameEngine;
import service.RuleEngine;

public class Game {

    public static void main(String[] args) {
        Player player1 = new CopyCat("Copy Cat");
        Player player2 = new Cheater("p2");

        ScoreCard scoreCard = ScoreCard.getScoreCard();

        GameEngine gameEngine = new GameEngine(scoreCard, new RuleEngine());
        gameEngine.play(player1, player2);


        System.out.println("Player 1 Score: " + scoreCard.getScore(player1).get());
        System.out.println("Player 2 Score: " + scoreCard.getScore(player2).get());

    }
}
