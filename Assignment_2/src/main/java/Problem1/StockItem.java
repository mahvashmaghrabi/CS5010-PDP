package Problem1;

/**
 * Creating a class StockItem
 */
public class StockItem {
  private Product product;
  private int quantity;

  /**
   * Constructor for StockItem class
   * @param product object of class Product
   * @param quantity Quantity in ounces or units
   */
  public StockItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * getter
   * @return returns product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * setter
   * @param product sets product value
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * getter
   * @return returns quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * setter
   * @param quantity set quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
