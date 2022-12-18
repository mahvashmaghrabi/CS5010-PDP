package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockItemTest {
  private static Cheese CHEESE = new Cheese("Beechers","Cheese1",15.5,0, 12 );
  private static Salmon SALMON = new Salmon("Beechers","Salmon1",10.5,0, 10);
  private StockItem item;

  @BeforeEach
  void setUp() {
    this.item = new StockItem(CHEESE,20);

  }

  @Test
  void getProduct() {
    Assertions.assertEquals(CHEESE, this.item.getProduct());

  }

  @Test
  void setProduct() {
    this.item.setProduct(SALMON);
    Assertions.assertEquals(SALMON, this.item.getProduct());
  }

  @Test
  void getQuantity() {
    Assertions.assertEquals(20, this.item.getQuantity());
  }

  @Test
  void setQuantity() {
    this.item.setQuantity(21);
    Assertions.assertEquals(21, this.item.getQuantity());
  }
}