package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
  private Product prod;

  @BeforeEach
  void setUp() {
    this.prod=new Product("Beechers","Product",20.5,20);
  }

  @Test
  void getManufacturerName() {
    Assertions.assertEquals("Beechers", this.prod.getManufacturerName());
  }

  @Test
  void setManufacturerName() {
    this.prod.setManufacturerName("Beach");
    Assertions.assertEquals("Beach", this.prod.getManufacturerName());
  }

  @Test
  void getProductName() {
    Assertions.assertEquals("Product", this.prod.getProductName());
  }

  @Test
  void setProductName() {
    this.prod.setProductName("NewProduct");
    Assertions.assertEquals("NewProduct", this.prod.getProductName());
  }

  @Test
  void getPrice() {
    Assertions.assertEquals(20.5, this.prod.getPrice());
  }

  @Test
  void setPrice() {
    this.prod.setPrice(15);
    Assertions.assertEquals(15, this.prod.getPrice());
  }

  @Test
  void getAge() {
    Assertions.assertEquals(20, this.prod.getAge());
  }

  @Test
  void setAge() {
    this.prod.setAge(21);
    Assertions.assertEquals(21, this.prod.getAge());
  }
}