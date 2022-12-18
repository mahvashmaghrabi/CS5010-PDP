package assignment4.problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrammarTest {

  Grammar grammar, notEqualsGrammar;
  String title;
  String desc;
  List<List<Node>> startList;
  List<List<Node>> rules;
  Map<String, NonTerminalDefinition> nonTerminalDefinitionMap;
  String filePath;

  @BeforeEach
  void setUp() {
    this.title = "Greeting Generator";
    this.desc = "A grammar that generates greeting. ";
    this.rules = new ArrayList<>();
    this.startList = new ArrayList<>();
    this.filePath = "./json/test.json";
    this.grammar = createActualGrammar();
    //GrammarDeserializer.parseGrammar(Files.readString(Paths.get(filePath)));
    this.notEqualsGrammar = createEqualsGrammar(this.title, this.desc);
//        GrammarDeserializer.parseGrammar(Files.readString(Paths.get(
//        "./json/test_equals.json")));
  }

  public Grammar createEqualsGrammar(String title, String desc) {
    NonTerminalNode nounNT = new NonTerminalNode("noun");
    TerminalNode helloTN = new TerminalNode("Hello");
    PunctuationNode pn = new PunctuationNode(' ');
    TerminalNode humanTN = new TerminalNode("human");
    TerminalNode alienTN = new TerminalNode("alien");
    TerminalNode touristTN = new TerminalNode("tourist");
    List<Node> nounRule = new ArrayList<>();
    nounRule.add(humanTN);
    nounRule.add(alienTN);
    nounRule.add(touristTN);
    List<Node> startRule = new ArrayList<>();
    startRule.add(helloTN);
    nounRule.add(pn);
    startRule.add(nounNT);
    List<List<Node>> startListEquals = new ArrayList<>();
    List<List<Node>> rulesEquals = new ArrayList<>();
    rulesEquals.add(nounRule);
    startListEquals.add(startRule);
    NonTerminalDefinition nounDef = new NonTerminalDefinition(rulesEquals,
        nounNT.getName());
    Map<String, NonTerminalDefinition> nonTerminalDefinitionMapEquals = new HashMap<>();
    nonTerminalDefinitionMapEquals.put(nounNT.getName(), nounDef);
//    var noRandom = new Grammar(title, desc, startListEquals,
//        nonTerminalDefinitionMapEquals, -1);
    return new Grammar(title, desc, startListEquals,
        nonTerminalDefinitionMapEquals, 2);
  }

  private Grammar createActualGrammar() {
    NonTerminalNode nounNT = new NonTerminalNode("noun");
    TerminalNode helloTN = new TerminalNode("Hello");
    PunctuationNode pn = new PunctuationNode(' ');
    TerminalNode humanTN = new TerminalNode("human");
    TerminalNode alienTN = new TerminalNode("alien");
    TerminalNode touristTN = new TerminalNode("tourist");
    NonTerminalNode greetNT = new NonTerminalNode("greet");
    TerminalNode welcomeTN = new TerminalNode("welcome");
    TerminalNode comeTN = new TerminalNode("come");
    TerminalNode goTN = new TerminalNode("go");
    NonTerminalNode placeNT = new NonTerminalNode("place");
    TerminalNode homeTN = new TerminalNode("home");
    TerminalNode countryTN = new TerminalNode("country");
    TerminalNode cityTN = new TerminalNode("city");
    NonTerminalNode adjNT = new NonTerminalNode("adj");
    TerminalNode sacredTN = new TerminalNode("sacred");
    TerminalNode beautifulTN = new TerminalNode("beautiful");
    TerminalNode to_ourTN = new TerminalNode("to our ");
    PunctuationNode commaPN = new PunctuationNode(',');
    PunctuationNode fullStopPN = new PunctuationNode('.');
    List<List<Node>> nounRule = new ArrayList<>();
    var human = new ArrayList<Node>();
    human.add(humanTN);
//    var alien = new ArrayList<Node>();
//    alien.add(alienTN);
//    var tou = new ArrayList<Node>();
//    tou.add(touristTN);
    nounRule.add(human);
    // nounRule.add(alien);
    // nounRule.add(tou);
    List<List<Node>> placeRule = new ArrayList<>();
    var home = new ArrayList<Node>();
    home.add(homeTN);
    var country = new ArrayList<Node>();
    country.add(countryTN);
    var city = new ArrayList<Node>();
    city.add(cityTN);
    placeRule.add(home);
    placeRule.add(country);
    placeRule.add(city);
    List<List<Node>> greetRule = new ArrayList<>();
    var welcome = new ArrayList<Node>();
    welcome.add(welcomeTN);
    var come = new ArrayList<Node>();
    come.add(comeTN);
    var go = new ArrayList<Node>();
    go.add(goTN);
    greetRule.add(welcome);
    greetRule.add(come);
    greetRule.add(go);
    List<List<Node>> adjRule = new ArrayList<>();
    var sacred = new ArrayList<Node>();
    sacred.add(sacredTN);
    var bea = new ArrayList<Node>();
    bea.add(beautifulTN);
    adjRule.add(sacred);
    adjRule.add(bea);
    List<Node> startRule = new ArrayList<>();
    startRule.add(helloTN);
    startRule.add(pn);
    startRule.add(nounNT);
    startRule.add(new PunctuationNode(','));
    startRule.add(greetNT);
    startRule.add(pn);
    startRule.add(to_ourTN);
    startRule.add(pn);
    startRule.add(adjNT);
    startRule.add(pn);
    startRule.add(placeNT);
    startRule.add(fullStopPN);
    this.startList.add(startRule);
    NonTerminalDefinition nounDef = new NonTerminalDefinition(nounRule,
        nounNT.getName());
    NonTerminalDefinition greetDef = new NonTerminalDefinition(greetRule,
        greetNT.getName());
    NonTerminalDefinition placeDef = new NonTerminalDefinition(placeRule,
        placeNT.getName());
    NonTerminalDefinition adjDef = new NonTerminalDefinition(adjRule,
        adjNT.getName());
    this.nonTerminalDefinitionMap = new HashMap<>();
    this.nonTerminalDefinitionMap.put(nounNT.getName(), nounDef);
    this.nonTerminalDefinitionMap.put(greetNT.getName(), greetDef);
    this.nonTerminalDefinitionMap.put(placeNT.getName(), placeDef);
    this.nonTerminalDefinitionMap.put(adjNT.getName(), adjDef);

    return new Grammar(this.title, this.desc, this.startList,
        this.nonTerminalDefinitionMap, 2);
  }

  @Test
  void generateString() {
    this.grammar.generateString();
    String result = this.grammar.printRandomSentence();
    System.out.println(result);
    Assertions.assertNotNull(result);
    Assertions.assertTrue(result.contains("Hello human"));
  }

  @Test
  void getDefinition_Positive() {
    Assertions.assertTrue(this.grammar.getDefinition("noun") != null);
    Assertions.assertFalse(this.grammar.getDefinition("noun").getRule().isEmpty());
  }

  @Test
  void getDefinition_Negative() {
    var result = this.grammar.getDefinition("test");
    Assertions.assertNull(result);
  }

  @Test
  void testEquals() {
    Grammar notEqualGrammar = this.notEqualsGrammar;
    Assertions.assertFalse(this.grammar.equals(notEqualGrammar));
    Grammar notEqualTitle = createEqualsGrammar("test", this.desc);
    Assertions.assertFalse(this.grammar.equals(notEqualTitle));
    Grammar notEqualDesc = createEqualsGrammar(this.title, "test");
    Assertions.assertFalse(this.grammar.equals(notEqualDesc));
    Grammar equalGrammar = this.grammar;
    Assertions.assertTrue(this.grammar.equals(equalGrammar));
    Grammar diffEqualGrammar = createActualGrammar();
    Assertions.assertFalse(this.grammar.equals(diffEqualGrammar));
    Assertions.assertTrue(this.grammar.equals(this.grammar));
    Assertions.assertFalse(this.grammar.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertTrue(this.grammar.hashCode() != this.notEqualsGrammar.hashCode());
    Assertions.assertTrue(this.grammar.hashCode() == this.grammar.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.grammar.toString().isEmpty());
    Assertions.assertTrue(this.grammar.toString().contains("Grammar{"));
  }

  @Test
  void getTitle() {
    Assertions.assertEquals(this.title, this.grammar.getTitle());
  }

  @Test
  void getDescription() {
    Assertions.assertEquals(this.desc, this.grammar.getDescription());
  }

  @Test
  void getStartList() {
    Assertions.assertEquals(this.startList, this.grammar.getStartList());
  }

  @Test
  void getDefinition() {
    Assertions.assertEquals(this.nonTerminalDefinitionMap,
        this.grammar.getNonTerminalDefinitionMap());
  }

}