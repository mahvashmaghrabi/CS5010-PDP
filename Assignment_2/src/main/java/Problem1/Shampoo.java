package Problem1;

import Problem1.Household;

/**
 * Creating class Shampoo which extends Household
 */
public class Shampoo extends Household {
  private int noOfUnits;

  /**
   * Constructor for Shampoo class
   * @param manufacturerName Nmae of the manufacturer of the product
   * @param productName Name of the product
   * @param price Price of the product
   * @param age Age of the person buying the product
   * @param noOfUnits quantity
   */
  public Shampoo(String manufacturerName, String productName, double price, int age, int noOfUnits) {
    super(manufacturerName, productName, price, age, noOfUnits);
    this.noOfUnits = noOfUnits;
  }

  /**
   * getter
   * @return returns quantity in units
   */
  public int getNoOfUnits() {
    return noOfUnits;
  }

  /**
   * setter
   * @param noOfUnits sets the quantity
   */
  public void setNoOfUnits(int noOfUnits) {
    this.noOfUnits = noOfUnits;
  }
}
