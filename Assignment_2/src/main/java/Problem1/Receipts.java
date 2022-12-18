package Problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * Creating class Receipts
 */
public class Receipts {
  private double totalPrice;
  private List<Product> productsReceived;
  private List<Product> productsOutOfStock;
  private List<Product> productsRemoved;

  /**
   * Constructors for Receipt class
   */
  public Receipts() {
    this.totalPrice = 0.0;
    this.productsReceived = new ArrayList<>();
    this.productsOutOfStock = new ArrayList<>();
    this.productsRemoved =  new ArrayList<>();
  }

  /**
   * getter
   * @return returns total price
   */
  public double getTotalPrice() {
    return totalPrice;
  }

  /**
   * setter
   * @param totalPrice sets total price
   */
  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * getter
   * @return returns productsReceived
   */
  public List<Product> getProductsReceived() {
    return productsReceived;
  }

  /**
   * setter
   * @param productsReceived sets the productReceived
   */
  public void setProductsReceived(List<Product> productsReceived) {
    this.productsReceived = productsReceived;
  }

  /**
   * getter
   * @return returns the product that are out of stock
   */
  public List<Product> getProductsOutOfStock() {
    return productsOutOfStock;
  }

  /**
   * setter
   * @param productsOutOfStock sets the out of stock product
   */
  public void setProductsOutOfStock(List<Product> productsOutOfStock) {
    this.productsOutOfStock = productsOutOfStock;
  }

  /**
   * getter
   * @return returns the productRemoved
   */
  public List<Product> getProductsRemoved() {
    return productsRemoved;
  }

  @Override
  public String toString() {
    return "Receipts{" +
        "totalPrice=" + totalPrice +
        ", productsReceived=" + productsReceived +
        ", productsOutOfStock=" + productsOutOfStock +
        ", productsRemoved=" + productsRemoved +
        '}';
  }

  /**
   * setter
   * @param productsRemoved sets the value
   */
  public void setProductsRemoved(List<Product> productsRemoved) {
    this.productsRemoved = productsRemoved;
  }
}
