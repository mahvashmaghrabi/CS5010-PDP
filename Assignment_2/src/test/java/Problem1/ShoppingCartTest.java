package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
  private ShoppingCart shop;
  private static Cheese CHEESE = new Cheese("Beechers","Cheese1",15.5,0, 12 );
  private static Salmon SALMON = new Salmon("Beechers","Salmon1",10.5,0, 10);
  private static ShoppingCart CART = new ShoppingCart(List.of(CHEESE));

  @BeforeEach
  void setUp() {
    this.shop = new ShoppingCart(List.of(CHEESE));
  }

  @Test
  void getProductList() {
    Assertions.assertEquals(List.of(CHEESE), this.shop.getProductList());
  }

  @Test
  void setProductList() {
    this.shop.setProductList(List.of(SALMON));
    Assertions.assertEquals(List.of(SALMON), this.shop.getProductList());
  }
}