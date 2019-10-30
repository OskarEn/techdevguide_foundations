package hangman.solver;

import java.util.List;

public class GuessOptimiser {

  private Words words;

  public GuessOptimiser(Words words) {
    this.words = words;
  }

  public char nextGuess(List<Character> guesses, String hint) {
    //TODO
    return 'N';
  }

  public Words getWords() {
    return words;
  }

  public void setWords(Words words) {
    this.words = words;
  }
}
