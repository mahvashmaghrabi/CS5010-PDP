package assignment5.problem1.concurrentSolution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Represents a File Generator facade which connects all componenets of the application
 */
public class FilesGeneratorConcurrentFacade {

  private static final int POOL_SIZE = 4;
  // minimum 3 threads should be running for executor to work in this design

  /**
   * Constructs File generator facade object
   */
  public FilesGeneratorConcurrentFacade() {
  }

  /**
   * Generates files from main method
   *
   * @param args arguments passed in command line
   */
  public void generateFiles(String[] args) {
    try {
      String fullInputFolderPath = CommandLineParser.parseCommand(args);

      SharedFileData sharedFileData = new SharedFileData(Integer.parseInt(args[1]));
      ExecutorService service = Executors.newFixedThreadPool(POOL_SIZE);

      service.execute(new Producer(sharedFileData, fullInputFolderPath));

      service.execute(new Processor(sharedFileData));

      service.execute(new Consumer(sharedFileData));

      service.shutdown();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}

