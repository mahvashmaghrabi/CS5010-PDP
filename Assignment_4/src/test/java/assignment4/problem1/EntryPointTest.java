package assignment4.problem1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import assignment5.problem1.sequentialSolution.EntryPoint;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class EntryPointTest {

  public static final String USER_DIR = "./json/correct";
  public static final String NO = "No";
  public static final String USER_CHOICE = "2";

//  @Test
//  void main_1() {
//
//    InputStream inputStream1 = System.in;
//    String simulatedUserInput = USER_DIR + System.lineSeparator() +
//        "2" + System.lineSeparator() +
//        "No" + System.lineSeparator() +
//        "q" + System.lineSeparator();
//    InputStream inputStream = new ByteArrayInputStream(
//        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
//    System.setIn(inputStream);
//
//    OutputStream outputStream = new ByteArrayOutputStream();
//    PrintStream printStream = new PrintStream(outputStream);
//    PrintStream printStream1 = System.out;
//    System.setOut(printStream);
//
//    EntryPoint.main(null);
//
//    System.setIn(inputStream1);
//    System.setOut(printStream1);
//
//    String[] lines = outputStream.toString().split(System.lineSeparator());
//    List<String> allLines = Arrays.stream(lines).toList();
//    for (String line : lines) {
//      System.out.println(line);
//    }
//
//    assertTrue(allLines.contains("Directory is : " + USER_DIR));
//    assertFalse(allLines.contains("User choice " + USER_CHOICE));
//    assertTrue(allLines.contains("User choice : " + NO));
//    assertFalse(allLines.contains("User choice q"));
//
//  }
//
//  @Test
//  void main_2() {
//    InputStream stdin = System.in;
//    String simulatedUserInput = USER_DIR +
//        System.lineSeparator() +
//        "q" + System.lineSeparator();
//    InputStream inputStream = new ByteArrayInputStream(
//        simulatedUserInput.getBytes(StandardCharsets.UTF_8));
//    System.setIn(inputStream);
//
//    OutputStream outputStream = new ByteArrayOutputStream();
//    PrintStream printStream = new PrintStream(outputStream);
//    PrintStream stdout = System.out;
//    System.setOut(printStream);
//
//    EntryPoint.main(null);
//
//    System.setIn(stdin);
//    System.setOut(stdout);
//
//    String[] lines = outputStream.toString().split(System.lineSeparator());
//    List<String> allLines = Arrays.stream(lines).toList();
//    for (String line : lines) {
//      System.out.println(line);
//    }
//
//    assertTrue(allLines.contains("Directory is : " + USER_DIR));
//    assertFalse(allLines.contains("User choice " + USER_CHOICE));
//    assertFalse(allLines.contains("User choice q"));
//    assertFalse(allLines.contains("User choice " + NO));
//  }
}