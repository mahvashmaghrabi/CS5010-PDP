package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;


class InventoryTest {
  private Inventory invent;
  private static final Cheese CHEESE = new Cheese("Beechers","Cheese1",15.5,0, 12 );
  private static final Shampoo SHAMPOO = new Shampoo("Beechers","Shampoo1",12.5,0,17 );
  private static final StockItem GROCERY_STOCK = new StockItem(CHEESE, 20);
  private static final StockItem HOUSEHOLD_STOCK = new StockItem(SHAMPOO, 22);

  @BeforeEach
  void setUp() {
   this.invent = new Inventory(List.of(GROCERY_STOCK), List.of(HOUSEHOLD_STOCK));
  }

  @Test
  void getGroceryStock() {
    Assertions.assertEquals(List.of(GROCERY_STOCK), this.invent.getGroceryStock());

  }

  @Test
  void setGroceryStock() {
    this.invent.setGroceryStock(Collections.emptyList());
    Assertions.assertEquals(Collections.emptyList(), this.invent.getGroceryStock());
  }

  @Test
  void getHouseholdStock() {
    Assertions.assertEquals(List.of(HOUSEHOLD_STOCK), this.invent.getHouseholdStock());

  }

  @Test
  void setHouseholdStock() {
    this.invent.setHouseholdStock(Collections.emptyList());
    Assertions.assertEquals(Collections.emptyList(), this.invent.getHouseholdStock());
  }

}