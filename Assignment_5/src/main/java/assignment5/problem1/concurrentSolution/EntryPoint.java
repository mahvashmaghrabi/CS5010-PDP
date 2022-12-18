package assignment5.problem1.concurrentSolution;


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
    final long startTime = System.currentTimeMillis();

    FilesGeneratorConcurrentFacade facade = new FilesGeneratorConcurrentFacade();
    facade.generateFiles(args);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("Shutdown Hook is running !");
      final long endTime = System.currentTimeMillis();
      System.out.println("Calculated in: " + (endTime - startTime) / 1000 + " seconds");
    }));
  }

}
