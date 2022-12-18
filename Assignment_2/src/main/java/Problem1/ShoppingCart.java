package Problem1;

import java.util.List;

/**
 * Creating a class for customer Shopping cart
 */
public class ShoppingCart {
  private List<Product> productList;

  /**
   * Empty Constructor
   */
  public ShoppingCart() {

  }

  /**
   * Constructor for ShoppingCart class
   * @param productList List of products
   */
  public ShoppingCart(List<Product> productList) {
    this.productList = productList;
  }

  /**
   * getter
   * @return returns product list
   */
  public List<Product> getProductList() {
    return productList;
  }

  /**
   * setter
   * @param productList sets the productList
   */
  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

}
