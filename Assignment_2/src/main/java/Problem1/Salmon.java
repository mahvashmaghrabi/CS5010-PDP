package Problem1;

import Problem1.Grocery;

/**
 * Creating class Salmon which extends Grocery
 */
public class Salmon extends Grocery {
  private int ounces;

  /**
   * Constructor for Salmon class
   * @param manufacturerName Name of the manufacturer
   * @param productName Name of the pouct purchased
   * @param price Price of the product
   * @param age Age of the person buying the product
   * @param ounces Quantity of the item
   */
  public Salmon(String manufacturerName, String productName, double price, int age, int ounces) {
    super(manufacturerName, productName, price, age, ounces);
    this.ounces = ounces;
  }

  /**
   * getter
   * @return the quantity
   */
  public int getOunces() {
    return ounces;
  }

  /**
   * setter
   * @param ounces sets the quantity
   */
  public void setOunces(int ounces) {
    this.ounces = ounces;
  }
}
