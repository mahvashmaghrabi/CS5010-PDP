package assignment4.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonTerminalDefinitionTest {

  NonTerminalDefinition definition;
  List<List<Node>> rules;
  String name;
  Random random;// = new Random();

  @BeforeEach
  void setUp() {
    NonTerminalNode nounNT = new NonTerminalNode("noun");
    TerminalNode humanTN = new TerminalNode("human");
    TerminalNode alienTN = new TerminalNode("alien");
    TerminalNode touristTN = new TerminalNode("tourist");
    List<Node> nounRule = new ArrayList<>();
    nounRule.add(humanTN);
    nounRule.add(alienTN);
    nounRule.add(touristTN);
    this.rules = new ArrayList<>();
    this.rules.add(nounRule);
    this.name = "noun";
    this.definition = new NonTerminalDefinition(this.rules, this.name);
  }

  @Test
  void getRule() {
    Assertions.assertEquals(3, this.definition.getRule().size());
  }

  @Test
  void getName() {
    Assertions.assertEquals(this.name, this.definition.getName());
  }

  @Test
  void testEquals() {
    NonTerminalDefinition notEqualNTD = new NonTerminalDefinition(this.rules, "hello");
    Assertions.assertFalse(this.definition.equals(notEqualNTD));
    NonTerminalDefinition notEqualDiffRuleNTD = new NonTerminalDefinition(null, "hello");
    Assertions.assertFalse(this.definition.equals(notEqualDiffRuleNTD));
    NonTerminalDefinition equalNTD = this.definition;
    Assertions.assertTrue(this.definition.equals(equalNTD));
    NonTerminalDefinition diffEqualNTD = new NonTerminalDefinition(this.rules, this.name);
    Assertions.assertFalse(this.definition.equals(diffEqualNTD));
    Assertions.assertTrue(this.definition.equals(this.definition));
    Assertions.assertFalse(this.definition.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.definition.hashCode(), this.definition.hashCode());
    Assertions.assertNotEquals(this.definition.hashCode(),
        new NonTerminalDefinition(this.rules, this.name).hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.definition.toString().isEmpty());
    Assertions.assertTrue(this.definition.toString().contains("NonTerminalDefinition{"));
  }
}