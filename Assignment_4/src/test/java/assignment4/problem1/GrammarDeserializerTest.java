package assignment4.problem1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrammarDeserializerTest {

  GrammarDeserializer grammarDeserializer;
  Grammar grammar;
  String filePath;

  @BeforeEach
  void setUp() throws IOException {
    this.grammarDeserializer = new GrammarDeserializer();
    this.filePath = "./json/insult_grammar.json";
    this.grammar = GrammarDeserializer.parseGrammar(Files.readString(Paths.get(filePath)));
    this.grammar.generateString();
    System.out.println(grammar.printRandomSentence());
  }

  @Test
  void parseGrammar() throws IOException {
    Assertions.assertNotNull(
        GrammarDeserializer.parseGrammar(Files.readString(Paths.get(filePath))));
  }

  @Test
  void parseGrammar_Negative() throws IOException {
    GrammarDeserializer.parseGrammar(Files.readString
        (Paths.get("./json/test_titlegiven_fail.json")));
  }

  @Test
  void testToString() {
    Assertions.assertTrue(this.grammarDeserializer.toString().contains("GrammarDeserializer{"));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.grammarDeserializer.hashCode(),
        this.grammarDeserializer.hashCode());
    Assertions.assertNotEquals(this.grammarDeserializer.hashCode(),
        new GrammarDeserializer().hashCode());
  }

  @Test
  void testEquals() {
    GrammarDeserializer deserializer = new GrammarDeserializer();
    Assertions.assertFalse(this.grammarDeserializer.equals(deserializer));
    GrammarDeserializer equalD = this.grammarDeserializer;
    Assertions.assertTrue(this.grammarDeserializer.equals(equalD));
    GrammarDeserializer diffEqualD = new GrammarDeserializer();
    Assertions.assertFalse(this.grammarDeserializer.equals(diffEqualD));
    Assertions.assertTrue(this.grammarDeserializer.equals(this.grammarDeserializer));
    Assertions.assertFalse(this.grammarDeserializer.equals(null));
  }
}
