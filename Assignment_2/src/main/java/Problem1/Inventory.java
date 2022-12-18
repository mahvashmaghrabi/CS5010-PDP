package Problem1;

import java.util.List;

/**
 *Creating new Inventory Class
 */
public class Inventory {
  private static String GROCERY = "Grocery";
  private static String HOUSEHOLD = "Household";
  private List<StockItem> groceryStock;
  private List<StockItem> householdStock;

  /**
   * Constructors for Inventory class
   * @param groceryStock contains the list of stockitems
   * @param householdStock contains the list of grocery items
   */
  public Inventory(List<StockItem> groceryStock, List<StockItem> householdStock) {
    this.groceryStock = groceryStock;
    this.householdStock = householdStock;
  }

  /**
   * Generating getter
   * @return returns groceryStock
   */
  public List<StockItem> getGroceryStock() {
    return groceryStock;
  }

  /**
   * Generating setter
   * @param groceryStock sets groceryStock
   */
  public void setGroceryStock(List<StockItem> groceryStock) {
    this.groceryStock = groceryStock;
  }

  /**
   * Generating getter
   * @return returns householdStock
   */
  public List<StockItem> getHouseholdStock() {
    return householdStock;
  }

  /**
   * Generating setter
   * @param householdStock sets Householdstock
   */
  public void setHouseholdStock(List<StockItem> householdStock) {
    this.householdStock = householdStock;
  }

  /**
   * this method gets the total inventory value
   */
  public void getTotalInventoryValue() {
    // Loop through inventory - grocery and household == calculate price and return
  }

  /**
   * Adds a new stock item to inventory
   * @param stockItem - has grocery and household list
   */
  public void addNewStockItem(StockItem stockItem) {
    if (stockItem != null) {
      return;
    } else if (stockItem.getProduct().getClass().getSuperclass().getSimpleName().equals(GROCERY)) {
      this.groceryStock.add(stockItem);
    } else if (stockItem.getProduct().getClass().getSuperclass().getSimpleName().equals(HOUSEHOLD)) {
      this.householdStock.add(stockItem);
    } else {
      System.out.println("Invalid Stock Item. Product did not match a valid product type");
    }
    return;
  }

}
