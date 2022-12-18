package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptsTest {
  private static Cheese CHEESE = new Cheese("Beechers","Cheese1",15.5,0, 12 );
  private Receipts r;

  @BeforeEach
  void setUp() {
    this.r = new Receipts();

  }

  @Test
  void getTotalPrice() {
    this.r.setTotalPrice(20);
    Assertions.assertEquals(20, this.r.getTotalPrice());

  }

  @Test
  void getProductsReceived() {
    this.r.setProductsReceived(List.of(CHEESE));
    Assertions.assertEquals(List.of(CHEESE), this.r.getProductsReceived());
  }

  @Test
  void getProductsOutOfStock() {
    this.r.setProductsOutOfStock(List.of(CHEESE));
    Assertions.assertEquals(List.of(CHEESE), this.r.getProductsOutOfStock());
  }

  @Test
  void getProductsRemoved() {
    this.r.setProductsRemoved(Collections.emptyList());
    Assertions.assertEquals(Collections.emptyList(), this.r.getProductsOutOfStock());
  }

}