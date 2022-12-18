package Problem1;

import Problem1.Grocery;

/**
 * Creating class Cheese which extends Grocery
 */
public class Cheese extends Grocery {
  private int ounces;

  /**
   * Constructor for Cheese class
   * @param manufacturerName Manufacturer name of product
   * @param productName name of the product
   * @param price price of the product
   * @param age age of the person buying the product
   * @param ounces quantity of product
   */
  public Cheese(String manufacturerName, String productName, double price, int age, int ounces) {
    super(manufacturerName, productName, price, age, ounces);
    this.ounces = ounces;
  }

  /**
   * Generating getter
   * @return returns ounces
   */
  public int getOunces() {
    return ounces;
  }

  /**
   * Generating setters
   * @param ounces set Ounces
   */
  public void setOunces(int ounces) {
    this.ounces = ounces;
  }
}
