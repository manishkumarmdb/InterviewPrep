package com.coderbyte.interview.divit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaRiverPuzzleProject {

  public static void main(String[] args) {
    CsvReader csvReader = new CsvReader();
    String filePath = "problemsolving/src/main/resources/com.coderbyte.interview.divit/game_moves.csv";
    List<String[]> moveSequences = csvReader.readMovesFromCsv(filePath);

    Validator validator = new Validator();
    for (int i = 0; i < moveSequences.size(); i++) {
      boolean isValid = validator.validateGame(moveSequences.get(i));
      System.out.println("Sequence " + (i + 1) + " is " + (isValid ? "valid" : "invalid"));
    }

  }

  private static class GameState {

    private Set<String> left = new HashSet<>();
    private Set<String> right = new HashSet<>();
    private boolean boatOnLeft = true;

    public GameState() {
      left.add("wolf");
      left.add("goat");
      left.add("cabbage");
    }

    public boolean moveItem(String item) {

      // normalize "alone"
      if ("alone".equalsIgnoreCase(item)) {
        item = null;
      }

      Set<String> source = boatOnLeft ? left : right;
      Set<String> destination = boatOnLeft ? right : left;

      if (item != null) {
        if (!source.contains(item)) {
          return false;
        }
        source.remove(item);
        destination.add(item);
      }

      boatOnLeft = !boatOnLeft;
      return isValidState();
    }

    public boolean isValidState() {

      if (!boatOnLeft) {
        if (left.contains("wolf") && left.contains("goat")) return false;
        if (left.contains("goat") && left.contains("cabbage")) return false;
      }

      if (boatOnLeft) {
        if (right.contains("wolf") && right.contains("goat")) return false;
        if (right.contains("goat") && right.contains("cabbage")) return false;
      }

      return true;
    }

    public boolean isSolved() {
      return right.contains("wolf")
          && right.contains("goat")
          && right.contains("cabbage");
    }
  }

  private static class Validator {

    public boolean validateGame(String[] moves) {

      GameState state = new GameState();

      for (String move : moves) {
        String item = move.trim();
        if (!state.moveItem(item)) {
          return false;
        }
      }

      return state.isSolved();
    }
  }

  private static class CsvReader {

    public List<String[]> readMovesFromCsv(String filePath) {

      List<String[]> moveSequences = new ArrayList<>();

      try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
          if (!line.trim().isEmpty()) {
            moveSequences.add(line.split(","));
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      return moveSequences;
    }
  }

}
