package hangman.solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Words {

  Set<String> words = new HashSet<>();

  public Words(Path p) throws IOException {
    Files.lines(p).forEach(s -> words.add(s));
  }

}
