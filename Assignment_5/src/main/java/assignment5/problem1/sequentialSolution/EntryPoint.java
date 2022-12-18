package assignment5.problem1.sequentialSolution;

import java.util.concurrent.TimeUnit;

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
    long t1 = System.nanoTime();
    FilesGeneratorFacade facade = new FilesGeneratorFacade();
    facade.generateFiles(args);
    long t2 = System.nanoTime();
    System.out.println("Time spent : " + (t2 - t1) / 1000);
    System.out.println(
        "Time spent in seconds : " + TimeUnit.SECONDS.convert((t2 - t1), TimeUnit.NANOSECONDS));
  }

}
