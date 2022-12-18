package Problem1;

import Problem1.Grocery;

/**
 * Creating Beer class which extends Grocery
 */
public class Beer extends Grocery {
  // TODO - Age restricted - implement age clause
  private int ounces;
  private static int REQUIRED_AGE = 21;

  /**
   * Constructor for Beer Class
   * @param manufacturerName Name of the product manufacturer
   * @param productName Name of the product
   * @param price Price of product
   * @param age Age of Customer
   * @param ounces Ounces of the grocery product
   */
  public Beer(String manufacturerName, String productName, double price, int age, int ounces) {
    // age > 21
    super(manufacturerName, productName, price, age, ounces);
    this.ounces = ounces;
  }

  /**
   * Generating getters
   * @return returns ounces
   */
  public int getOunces() {
    return ounces;
  }

  /**
   * Generating setters
   * @param  ounces set value of ounces
   */

  public void setOunces(int ounces) {
    this.ounces = ounces;
  }
}
