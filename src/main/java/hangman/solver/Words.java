package hangman.solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Words {

  private Set<String> wordList;

  public void loadWords(Path p) {
    try {
      wordList = new HashSet<>();
      Files.lines(p).forEach(s -> wordList.add(s));
    } catch (IOException io) {
      throw new RuntimeException("Could not load the file for the words");
    }
  }
}
