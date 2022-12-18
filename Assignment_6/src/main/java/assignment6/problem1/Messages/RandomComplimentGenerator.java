package assignment6.problem1.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a RandomComplimentGenerator class
 */
public class RandomComplimentGenerator {

  private Random rand;
  private List<String> complimentList;

  /**
   * Constructs a RandomComplimentGenerator object using below params
   */
  public RandomComplimentGenerator() {
    complimentList = new ArrayList<>();
    generateComplimentList();
    this.rand = new Random();
  }

  private void generateComplimentList() {
    this.complimentList.add("Who raised you? They deserve a medal for a job well done.");
    this.complimentList.add("You're great at figuring stuff out.");
    this.complimentList.add("You help me be the best version of myself.");
    this.complimentList.add("Your perspective is refreshing.");
    this.complimentList.add("You are great!");
    this.complimentList.add("You will definitely win.");
    this.complimentList.add("Have a good day!");
    this.complimentList.add("On a scale from 1 to 10, you're an 11");
    this.complimentList.add("You're a great listener.");
  }

  /**
   * Generates random compliment
   *
   * @return string
   */
  public synchronized String generateRandomCompliment() {
    return this.complimentList.get(rand.nextInt(this.complimentList.size()));
  }
}
