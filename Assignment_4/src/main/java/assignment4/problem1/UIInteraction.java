package assignment4.problem1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Creating class UIInteraction to take input from the user
 */
public class UIInteraction {

  static String directoryName = "";
  static String[] pathNames;
  private static List<Path> grammars;
  private static Scanner sc;


  /**
   * creating an object of scanner
   */
  public UIInteraction() {
    sc = new Scanner(System.in);
  }

  /**
   * method generateGrammar generates grammar using the json files present in the given directory
   */
  public void generateGrammar() {
    System.out.println("Enter directory name");

    directoryName = sc.nextLine();
    System.out.println("Directory is : " + directoryName);
    try {
      if (!Files.isDirectory(Paths.get(directoryName))) {
        throw new RuntimeException("Please enter valid directory name.");
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    grammars = getGrammars(directoryName);

    chooseGrammar();
  }

  /**
   * method to choose grammar from the list of grammars given
   */
  private void chooseGrammar() {
    System.out.println("Loading grammars...\n");
    System.out.println("The following grammars are available: ");
    for (int i = 0; i < grammars.size(); i++) {
      int j = i + 1;
      System.out.println(j + ". " + grammars.get(i).getFileName());
    }
    System.out.println("Which would you like to use? (q to quit)");

    String userGrammarChoice = sc.nextLine();
    System.out.println("User choice : " + userGrammarChoice);
    if (userGrammarChoice.equalsIgnoreCase("q")) {
      return;
    }
    int grammarChoice;
    try {
      grammarChoice = Integer.parseInt(userGrammarChoice);
    } catch (NumberFormatException nfe) {
      System.out.println("Wrong input entered " + userGrammarChoice
          + ". Number should be entered. Please start over.");
      return;
    }
    try {
      if (grammars.size() < grammarChoice) {
        throw new RuntimeException("Invalid number entered.");
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

    printGrammar(grammars.get(grammarChoice - 1));
  }

  /**
   * print the grammar
   *
   * @param grammarFileName grammar file name
   */
  private void printGrammar(Path grammarFileName) {
    boolean isSuccess = readGrammarFile(grammarFileName);
    if (!isSuccess) {
      return;
    }
    // if else condition for the user wants another sentence from grammar
    System.out.println("Would you like another? (y/n)");
    String answer = sc.nextLine();
    System.out.println("User choice : " + answer);
    if (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y")) {
      printGrammar(grammarFileName);
    } else if (answer.equalsIgnoreCase("NO") || answer.equalsIgnoreCase("N")) {
      chooseGrammar();
    } else {
      try {
        throw new RuntimeException("Wrong input entered. Expecting inputs are: yes/no.");
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  private boolean readGrammarFile(Path grammarFileName) {
    String fileContents = null;

    try {
      fileContents = Files.readString(grammarFileName);
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    Grammar grammar = GrammarDeserializer.parseGrammar(fileContents);
    if (grammar == null) {
      chooseGrammar();
      return false;
    } else {
      grammar.generateString();
      System.out.println(grammar.printRandomSentence());
    }
    return true;
  }

  /**
   * gets the grammar from the given directory
   *
   * @param directoryName where the grammar files are stored
   * @return filenames
   */
  public List<Path> getGrammars(String directoryName) {
    File f = new File(directoryName);

    pathNames = f.list();
    List<Path> grammars = new ArrayList<>();
    if (pathNames == null || pathNames.length == 0) {
      throw new RuntimeException(
          "The given directory name does not have any grammar file. Please start over");
    } else {
      for (String pathName : pathNames) {
        var filePath = Paths.get(f.getAbsolutePath() + "/" + pathName);
        if (!Files.isRegularFile(filePath)) {
          continue;
        }
        grammars.add(filePath);

      }
      try {
        if (grammars.size() == 0) {
          throw new RuntimeException("No grammar file found.");
        }
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
    return grammars;
  }

  /**
   * generating toString
   *
   * @return UIInteraction
   */
  @Override
  public String toString() {
    return "UIInteraction{}";
  }

  /**
   * generating hashcode
   *
   * @return super
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare.
   * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}