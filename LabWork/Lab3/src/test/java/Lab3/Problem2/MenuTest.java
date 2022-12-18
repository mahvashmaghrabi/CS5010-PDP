package Lab3.Problem2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MenuTest {
  private Menu food;

  @BeforeEach
  void setUp() {

    //this.food = new Menu("jame","jame","jame","jame","jame","jame");
    //this.food= new Menu( List<String>meals = new ArrayList<String>();
    //this.food = new Menu(Arrays.asList("Burger","Chips","Pizza","Pasta"), List.of("Pastry","Cookies","Ice-Cream","Chocolate Pie"), List.of("Tea","Coffee"), List.of("Pepsi","Coco-Cola"), true , false);
    this.food = new Menu(List.of("Burger","Chips","Pizza","Pasta"), List.of("Pastry","Cookies","Ice-Cream","Chocolate Pie"), List.of("Tea","Coffee"), List.of("Pepsi","Coco-Cola"));

  }

  @Test
  void getMeals() {
    Assertions.assertEquals(List.of("Burger","Chips","Pizza","Pasta"), this.food.getMeals());
  }

  @Test
  void setMeals() {
  }

  @Test
  void getDesserts() {
    Assertions.assertEquals(List.of("Pastry","Cookies","Ice-Cream","Chocolate Pie"), this.food.getDesserts());

  }

  @Test
  void setDesserts() {
  }

  @Test
  void getBeverages() {
    Assertions.assertEquals(List.of("Tea","Coffee"), this.food.getBeverages());
  }

  @Test
  void setBeverages() {
  }

  @Test
  void getDrinks() {
    Assertions.assertEquals(List.of("Pepsi","Coco-Cola"), this.food.getDrinks());

  }

  @Test
  void setDrinks() {
  }

}