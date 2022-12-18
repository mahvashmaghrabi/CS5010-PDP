package Problem1;

import Problem1.Product;

/**
 * Creating an abstract class Household
 */
public abstract class Household extends Product {
  private int units;


  /**
   * Constructor for Household class
   * @param manufacturerName Manufavturer of the product
   * @param productName Name of the product
   * @param price Price of the product
   * @param age Age of the customer buying the prduct
   * @param units Size of the product in units
   */
  public Household(String manufacturerName, String productName, double price, int age, int units) {
    super(manufacturerName, productName, price, age);
    this.units = units;
  }

  /**
   * Generating getter
   * @return returns unit value
   */
  public int getUnits() {
    return units;
  }

  /**
   * Generating Setter
   * @param units set unit value
   */
  public void setUnits(int units) {
    this.units = units;
  }
}
