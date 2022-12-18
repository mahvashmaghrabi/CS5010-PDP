package Problem1;

import Problem1.Product;

/**
 * Creating an abstract class Grocery
 */
public abstract class Grocery extends Product {
  private double weight;

  /**
   * Constrictor for Grocery class
   * @param manufacturerName Name of the product manufacturer
   * @param productName Name of the product
   * @param price Price of product
   * @param age Age of Customer
   * @param weight Weight of the product
   */
  public Grocery(String manufacturerName, String productName, double price, int age, double weight) {
    super(manufacturerName, productName, price, age);
    this.weight = weight;
  }

  /**
   * Generating getter
   * @return returns weight
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Generating setter
   * @param weight sets weight value
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }
}
