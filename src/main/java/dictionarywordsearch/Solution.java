package dictionarywordsearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.firstSolution();
  }

  private String S = "abppplee";
  private String[] dictionary = {"able", "ale", "apple", "bale", "kangaroo"};

  public String firstSolution() {
    List<String> contained = new ArrayList<>();
    for(String word : dictionary) {
      if(isContained(word, S))
        contained.add(word);
    }
    contained.sort(Comparator.comparingInt(String::length));
    contained.forEach(System.out::println);

  if(contained.isEmpty())
    return null;

  return contained.get(contained.size() - 1);
  }

  private boolean isContained(String word, String S) {
    int wordIndex = 0, sIndex = 0;
    while(sIndex < S.length()) {
      if(wordIndex == word.length())
        return true;
      if(word.charAt(wordIndex) == S.charAt(sIndex))
        wordIndex++;
      sIndex++;
    }
    return false;
  }
}