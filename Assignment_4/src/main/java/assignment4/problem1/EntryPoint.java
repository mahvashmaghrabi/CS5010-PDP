package assignment4.problem1;

/**
 * Represents an Entry point for user
 */
public class EntryPoint {

  /**
   * Main method to start generation
   *
   * @param args arguments passed from command line
   */
  public static void main(String[] args) {
    UIInteraction uiInteraction = new UIInteraction();
    uiInteraction.generateGrammar();
  }
}