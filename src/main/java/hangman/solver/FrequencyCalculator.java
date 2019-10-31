package hangman.solver;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public  class FrequencyCalculator {

  //Start by just getting the frequency of guesses in the file
  //Can make a smarter one that compares the frequency of letters on a word level
  public static Iterator<Character> optimalGuesses() {
    Multiset<Character> letterFreq = HashMultiset.create();
    try (BufferedReader reader = new BufferedReader(
        new FileReader("src/main/java/hangman/solver/wordlist.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        for (char c : line.toCharArray())
          letterFreq.add(c);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    letterFreq.removeIf(c -> !Character.isAlphabetic(c));
    letterFreq = Multisets.copyHighestCountFirst(letterFreq);
    Set<Character> descOrderLetters = new LinkedHashSet<>();
    descOrderLetters.addAll(letterFreq);

    return descOrderLetters.iterator();
  }
}
