package Lab3.Problem2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
  private Restaurant dinner;
  private static Address ADDRESS = new Address("9th Avenue","Seattle","98052","WA","USA" );
  private static Menu MENU = new Menu(List.of("Burger","Chips","Pizza","Pasta"), List.of("Pastry","Cookies","Ice-Cream","Chocolate Pie"), List.of("Tea","Coffee"), List.of("Pepsi","Coco-Cola"));



  @BeforeEach
  void setUp() {
    this.dinner = new Restaurant("Dinner",ADDRESS, MENU, true);
  }

  @Test
  void getRestaurantName() {
    Assertions.assertEquals("Dinner", this.dinner.getRestaurantName());
  }

  @Test
  void setRestaurantName() {
  }

  @Test
  void getAddress() {
    Assertions.assertEquals(ADDRESS, this.dinner.getAddress());
  }

  @Test
  void setAddress() {
  }

  @Test
  void getMenu() {
    Assertions.assertEquals(MENU, this.dinner.getMenu());
  }

  @Test
  void setMenu() {
  }

  @Test
  void isOpen() {
    Assertions.assertEquals(true, this.dinner.isOpen());
  }

  @Test
  void setOpen() {
  }
}