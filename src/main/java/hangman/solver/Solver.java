package hangman.solver;

import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Logger;

//TODO Modify my hangman game to test the solver
public class Solver {

  private static Logger logger = Logger.getLogger("Solver progress");

  public static void main(String[] args) {
    Long start = System.currentTimeMillis();
    Scanner scanner = new Scanner(System.in);
    Iterator<Character> guesses = FrequencyCalculator.optimalGuesses();
    while(scanner.hasNextLine()) {
      String input = scanner.nextLine();
      if(isEnded(input)) {
        logger.info("System has ended. Completed in " + (System.currentTimeMillis() - start));
        break;
      }
      if(isNextRound(input)) {
        guesses = FrequencyCalculator.optimalGuesses();
      }
      System.out.println(guesses.next()); //This should pass to a game instance
    }
  }

  private static boolean isEnded(String input) {
    return input.equals("END");
  }
  //NextRound is declared by passing a string consisting only of underscores
  private static boolean isNextRound(String input) {
    for(char c : input.toCharArray()) {
      if(c!='_')
        return false;
    }
    return true;
  }
}
