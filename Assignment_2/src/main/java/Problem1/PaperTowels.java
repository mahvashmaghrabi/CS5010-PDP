package Problem1;

import Problem1.Household;

/**
 * Creating class PaperTowels which extends Household
 */

public class PaperTowels extends Household {
  private int noOfUnits;

  /**
   * Constructor for PaperTowel class
   * @param manufacturerName Name of manufacturer of product
   * @param productName Name of the product
   * @param price Price of the product
   * @param age Age of the customer buying the product
   * @param noOfUnits No of units of the product present
   */
  public PaperTowels(String manufacturerName, String productName, double price, int age, int noOfUnits) {
    super(manufacturerName, productName, price, age, noOfUnits);
    this.noOfUnits = noOfUnits;
  }

  /**
   * Generating getter
   * @return returns no. of units
   */
  public int getNoOfUnits() {
    return noOfUnits;
  }

  /**
   * Generating setter
   * @param noOfUnits sets the number of units
   */
  public void setNoOfUnits(int noOfUnits) {
    this.noOfUnits = noOfUnits;
  }
}
