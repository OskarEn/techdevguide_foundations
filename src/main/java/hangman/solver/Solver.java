package hangman.solver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//https://codegolf.stackexchange.com/questions/25496/write-a-hangman-solver
public class Solver {

  //TODO: handling the input from the user ___ ___a___ ____b___
  //TODO: improve the guessing -> could test the frequencies of words in the list

  //Delegate to other methods
  public static void main(String[] args) {
    Words words = new Words();
    words.loadWords(Paths.get("wordlist.txt")); //Make
    GuessOptimiser guessOptimiser = new GuessOptimiser(words);

    boolean running = true;
    while(running) {
      //TODO interaction ...while nextLine != END
      //TODO condition if all are blank...start a new "guessing session"
    }
  }
}
