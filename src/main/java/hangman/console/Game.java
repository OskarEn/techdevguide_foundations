package hangman.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
  private boolean isRunning = true;
  private final String wordToGuess = getRandomWord();
  private List<Character> guesses = new ArrayList<>();

  public static void main(String[] args) {
    Game game = new Game();
    game.greetUser();
    while(game.isRunning) {
     char guess = game.getUserInput();
     game.updateGameState(guess);
    }
    game.showGameResult();
  }

  private void showGameResult() {
    if(obfusticatedWord(wordToGuess, guesses).contains("*")) {
      System.out.println("Bad luckk. The word to guess was: " + wordToGuess);
    } else {
      System.out.println(String.format("Congratulations, you won using %d guesses", guesses.size()));
    }
  }

  private void updateGameState(char guess) {
    guesses.add(guess);
    String guessedWord = obfusticatedWord(wordToGuess, guesses);
    if(wordToGuess.equals(guessedWord)) {
      isRunning = false;
      return;
    }
    System.out.println(guessedWord);
  }

  private String obfusticatedWord(String wordToGuess, List<Character> guesses) {
    char[] hiddenWord = wordToGuess.toCharArray();
    for(int i = 0; i < hiddenWord.length; i++) {
      if(!guesses.contains(hiddenWord[i]))
        hiddenWord[i] = '*';
    }
    return hiddenWord.toString();
  }

  private char getUserInput() {
    Scanner s = new Scanner(System.in);
    while(true) { //either contine or a return statement
      System.out.println("Please enter a guess!");
      String guess = s.nextLine();
      if(isValidInput(guess)) {
        char c = guess.toLowerCase().charAt(0);
        if(guesses.contains(c))
          continue;
        return c;
      }
    }
  }

  private boolean isValidInput(String guess) {
    if(guess.isEmpty())
      return false;
    if(guess.length() > 1)
      return false;
    char c = guess.charAt(0);
    if(Character.isAlphabetic(c))
      return true;

    return false;

  }

  //Init
  private void greetUser() {
    System.out.println("Welcome to CLI Hangman!");
  }

  private String getRandomWord() {
    String[] words = {"github", "compiler", "jakarta", "enterprise", "apache"};
    int randomIndex = (int) (Math.random() * words.length) + 1;
    //System.out.println("The random word that was set: " + words[ randomIndex ]);
    return words[ randomIndex ];
  }
}
