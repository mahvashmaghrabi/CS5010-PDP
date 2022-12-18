package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomersTest {
  private Customers customers;
  private static Cheese CHEESE = new Cheese("Beechers","Cheese1",15.5,0, 12 );
  private static ShoppingCart CART = new ShoppingCart(List.of(CHEESE));

  @BeforeEach
  void setUp() {
    this.customers=new Customers("maha", 20, CART);
  }

  @Test
  void getName() {
    Assertions.assertEquals("maha", this.customers.getName());
  }

  @Test
  void setName() {
    this.customers.setName("mahvash");
    Assertions.assertEquals("mahvash", this.customers.getName());
  }

  @Test
  void getAge() {
    Assertions.assertEquals(20, this.customers.getAge());
  }

  @Test
  void setAge() {
    this.customers.setAge(21);
    Assertions.assertEquals(21, this.customers.getAge());
  }

  @Test
  void getCart() {
    Assertions.assertEquals(CART, this.customers.getCart());

  }

  @Test
  void setCart() {
    ShoppingCart cart = new ShoppingCart(List.of(new Salmon("Beechers","Salmon1",10.5,0, 10)));
    this.customers.setCart(cart);
    Assertions.assertEquals(cart, this.customers.getCart());
  }



}