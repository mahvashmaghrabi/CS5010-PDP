package assignment4.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UIInteractionTest {

  public static final String USER_DIR = "./json/correct";
  public static final String WRONG_USER_DIR = "./json/test";
  public static final String EMPTY_NON_GRAMMAR_DIR = "./json/emptyNonGrammar";
  public static final String TITLE_EMPTY_USER_DIR = "./json/incorrect";
  public static final String EMPTY_FOLDER = "./json/empty";
  public static final String NO = "No";
  public static final String USER_CHOICE = "2";
  public static Grammar INSULT_GRAMMAR;
  public static Grammar TEST_GRAMMAR;

  static {
    try {
      //Files.readString(Paths.get(filePath))
      INSULT_GRAMMAR = GrammarDeserializer.parseGrammar(
          Files.readString(Paths.get("./json/correct/insult_grammar.json")));
      TEST_GRAMMAR = GrammarDeserializer.parseGrammar(
          Files.readString(Paths.get("./json/correct/test.json")));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  UIInteraction uiInteraction;

  @BeforeEach
  void setUp() {
    this.uiInteraction = new UIInteraction();
  }

  @Test
  void testGenerateGrammar_NO() {
    InputStream inputStream1 = System.in;
    String simulatedUserInput = USER_DIR +
        System.lineSeparator() +
        "2" + System.lineSeparator() +
        "No" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.generateGrammar();

    System.setIn(inputStream1);
    System.setOut(printStream1);

    String[] lines = outputStream.toString().split(System.lineSeparator());
    List<String> allLines = Arrays.stream(lines).toList();
    for (String line : lines) {
      System.out.println(line);
    }

    assertTrue(allLines.contains("Directory is : " + USER_DIR));
    assertTrue(allLines.contains("User choice : " + NO));
  }

  @Test
  void testGenerateGrammar_N() {
    InputStream inputStream1 = System.in;
    String simulatedUserInput = USER_DIR +
        System.lineSeparator() +
        "2" + System.lineSeparator() +
        "N" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.generateGrammar();

    System.setIn(inputStream1);
    System.setOut(printStream1);

    String[] lines = outputStream.toString().split(System.lineSeparator());
    List<String> allLines = Arrays.stream(lines).toList();
    for (String line : lines) {
      System.out.println(line);
    }

//    assertTrue(allLines.contains("Directory is : " + USER_DIR));
//    assertTrue(allLines.contains("User choice " + USER_CHOICE));
  }


  @Test
  void testGenerateGrammar_empty() {
    InputStream inputStream1 = System.in;
    String simulatedUserInput = EMPTY_FOLDER +
        System.lineSeparator() +
        "2" + System.lineSeparator() +
        "No" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    Throwable exp = Assertions.assertThrows(Exception.class, uiInteraction::generateGrammar);
    Assertions.assertEquals(
        "The given directory name does not have any grammar file. Please start over",
        exp.getMessage());

  }

  @Test
  void testGenerateGrammar_EmptyNonGrammar() {
    InputStream inputStream1 = System.in;
    String simulatedUserInput = EMPTY_NON_GRAMMAR_DIR +
        System.lineSeparator() +
        "1" + System.lineSeparator() +
        "YES" + System.lineSeparator() +
        "n" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.generateGrammar();
  }

  @Test
  void testGenerateGrammar_YES() {
    InputStream inputStream1 = System.in;
    String simulatedUserInput = USER_DIR +
        System.lineSeparator() +
        "2" + System.lineSeparator() +
        "YES" + System.lineSeparator() +
        "n" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.generateGrammar();

    System.setIn(inputStream1);
    System.setOut(printStream1);

    String[] lines = outputStream.toString().split(System.lineSeparator());
    List<String> allLines = Arrays.stream(lines).toList();
    for (String line : lines) {
      System.out.println(line);
    }

    assertTrue(allLines.contains("Directory is : " + USER_DIR));
  }

  @Test
  void testGenerateGrammar_Y() {
    InputStream inputStream1 = System.in;
    String simulatedUserInput = USER_DIR +
        System.lineSeparator() +
        "2" + System.lineSeparator() +
        "Y" + System.lineSeparator() +
        "n" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.generateGrammar();

    System.setIn(inputStream1);
    System.setOut(printStream1);

    String[] lines = outputStream.toString().split(System.lineSeparator());
    List<String> allLines = Arrays.stream(lines).toList();
    for (String line : lines) {
      System.out.println(line);
    }

    assertTrue(allLines.contains("Directory is : " + USER_DIR));
  }

  @Test
  void testGenerateGrammar_InvalidFolderName() {
    InputStream inputStream1 = System.in;
    String simulatedUserInput = WRONG_USER_DIR +
        System.lineSeparator() +
        "1" + System.lineSeparator() +
        "y" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    Throwable exp = Assertions.assertThrows(Exception.class, uiInteraction::generateGrammar);
    Assertions.assertEquals(
        "The given directory name does not have any grammar file. Please start over",
        exp.getMessage());
  }

  @Test
  void testGenerateGrammar_MoreThanGrammarLst() {
    InputStream inputStream1 = System.in;
    String simulatedUserInput = USER_DIR +
        System.lineSeparator() +
        "4" + System.lineSeparator() +
        "y" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    Throwable exp = Assertions.assertThrows(Exception.class, uiInteraction::generateGrammar);
  }

  @Test
  void testGenerateGrammar_TitleEmpty() {
    InputStream inputStream1 = System.in;
    String simulatedUserInput = TITLE_EMPTY_USER_DIR +
        System.lineSeparator() +
        "1" + System.lineSeparator() +
        "y" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.generateGrammar();
    Throwable exp = Assertions.assertThrows(Exception.class, uiInteraction::generateGrammar);
  }

  @Test
  void testGenerateGrammar_InvalidInputExpectingNumber() {
    InputStream inputStream1 = System.in;
    String userNumber = "W";
    String simulatedUserInput = USER_DIR +
        System.lineSeparator() +
        "W" + System.lineSeparator() +
        "No" + System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream printStream1 = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.generateGrammar();
    //  Throwable exp = Assertions.assertThrows(Exception.class,()->);
    //  Assertions.assertTrue(exp.getMessage().contains("Number should be entered."));
    System.setIn(inputStream1);
    System.setOut(printStream1);

    String[] lines = outputStream.toString().split(System.lineSeparator());
    List<String> allLines = Arrays.stream(lines).toList();
    for (String line : lines) {
      System.out.println(line);
    }

    assertTrue(allLines.contains("Directory is : " + USER_DIR));
    assertFalse(allLines.contains("User choice " + userNumber));
  }

  @Test
  void testGenerateGrammar_InputQ() {
    InputStream stdin = System.in;
    String simulatedUserInput = USER_DIR +
        System.lineSeparator() +
        "q" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(
        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
    System.setIn(inputStream);

    OutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream stdout = System.out;
    System.setOut(printStream);

    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.generateGrammar();

    System.setIn(stdin);
    System.setOut(stdout);

    String[] lines = outputStream.toString().split(System.lineSeparator());
    List<String> allLines = Arrays.stream(lines).toList();
    for (String line : lines) {
      System.out.println(line);
    }

    assertTrue(allLines.contains("Directory is : " + USER_DIR));
    assertFalse(allLines.contains("User choice " + USER_CHOICE));
    assertFalse(allLines.contains("User choice q"));
    assertFalse(allLines.contains("User choice " + NO));
  }

  @Test
  void getGrammars() {
    UIInteraction uiInteraction = new UIInteraction();
    List<Path> grammars =
        uiInteraction.getGrammars("./json/correct");

    assertEquals(2, grammars.size());
//    assertEquals(TEST_GRAMMAR.getTitle(), grammars.get(1).getTitle());
//    assertEquals(INSULT_GRAMMAR.getTitle(), grammars.get(0).getTitle());
  }

  @Test
  void getGrammars_badDir() {
    UIInteraction uiInteraction = new UIInteraction();
    List<Path> grammars =
        uiInteraction.getGrammars("./json/correct");
    assertEquals(2, grammars.size());
  }

  @Test()
  void getGrammars_list() {
    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.getGrammars("./json/");
//    assertThrows(RuntimeException.class, () -> );
  }

  @Test
  void testEquals() {
    UIInteraction equalUIInteraction = this.uiInteraction;
    Assertions.assertTrue(this.uiInteraction.equals(equalUIInteraction));
    UIInteraction diffEqualTitle = new UIInteraction();
    Assertions.assertFalse(this.uiInteraction.equals(diffEqualTitle));
    Assertions.assertTrue(this.uiInteraction.equals(this.uiInteraction));
    Assertions.assertFalse(this.uiInteraction.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertTrue(this.uiInteraction.hashCode() != new UIInteraction().hashCode());
    Assertions.assertTrue(this.uiInteraction.hashCode() == this.uiInteraction.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.uiInteraction.toString().isEmpty());
    Assertions.assertTrue(this.uiInteraction.toString().contains("UIInteraction{"));
  }
}