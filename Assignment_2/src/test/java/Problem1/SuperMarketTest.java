package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static Problem1.SuperMarket.*;
import static org.junit.jupiter.api.Assertions.*;

class SuperMarketTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void orderProductsTest() {
    Salmon salmon = new Salmon("Beechers","Salmon1",10.5,0, 10);
    Beer beer =new Beer("Beechers","Beer1",20.5,21, 12);
    Cheese cheese = new Cheese("Beechers","Cheese1",15.5,0, 12 );
    PaperTowels paperTowels = new PaperTowels("Beechers","PaperTowel1",5.5,0,15 );
    Shampoo shampoo = new Shampoo("Beechers","Shampoo1",12.5,0,17 );

    List<StockItem> groceryStockItems=new ArrayList<>();
    groceryStockItems.add(new StockItem(salmon,10));
    groceryStockItems.add(new StockItem(cheese,0));
    groceryStockItems.add(new StockItem(beer,0));

    List<StockItem> householdStockItems=new ArrayList<>();
    householdStockItems.add(new StockItem(paperTowels,10));
    householdStockItems.add(new StockItem(shampoo,20));

    ShoppingCart cart = new ShoppingCart();
    cart.setProductList(new ArrayList<>());
    Inventory stockInventory = new Inventory(groceryStockItems, householdStockItems);
    String userInput = String.format("1 1%s%sn",
        System.lineSeparator(),
        System.lineSeparator());
    ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(inputStream);

    ShoppingCart actualCart = orderProducts(stockInventory, cart);
    Assertions.assertEquals(List.of(salmon), actualCart.getProductList());
  }


  /*@Test
  void orderProductsTestContinueTest() {
    Salmon salmon = new Salmon("Beechers","Salmon1",10.5,0, 10);
    Beer beer =new Beer("Beechers","Beer1",20.5,21, 12);
    Cheese cheese = new Cheese("Beechers","Cheese1",15.5,0, 12 );
    PaperTowels paperTowels = new PaperTowels("Beechers","PaperTowel1",5.5,0,15 );
    Shampoo shampoo = new Shampoo("Beechers","Shampoo1",12.5,0,17 );

    List<StockItem> groceryStockItems=new ArrayList<>();
    groceryStockItems.add(new StockItem(salmon,10));
    groceryStockItems.add(new StockItem(cheese,0));
    groceryStockItems.add(new StockItem(beer,0));

    List<StockItem> householdStockItems=new ArrayList<>();
    householdStockItems.add(new StockItem(paperTowels,10));
    householdStockItems.add(new StockItem(shampoo,20));

    ShoppingCart cart = new ShoppingCart();
    cart.setProductList(new ArrayList<>());
    Inventory stockInventory = new Inventory(groceryStockItems, householdStockItems);
    String userInput = String.format("1 1%s%sy%s2 1%s%sn",
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator(),
        System.lineSeparator());
    ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(inputStream);

    ShoppingCart actualCart = orderProducts(stockInventory, cart);
    Assertions.assertEquals(List.of(salmon, beer), actualCart.getProductList());
  }
*/

  @Test
  void checkCanAddItem() {
    Salmon salmon = new Salmon("Beechers","Salmon1",10.5,0, 10);
    Beer beer =new Beer("Beechers","Beer1",20.5,21, 12);
    Cheese cheese = new Cheese("Beechers","Cheese1",15.5,0, 12 );
    Salmon salmon2 = new Salmon("Beechers2","Salmon3",10.5,0,15 );

    List<StockItem> groceryStockItems=new ArrayList<>();
    groceryStockItems.add(new StockItem(salmon,10));
    groceryStockItems.add(new StockItem(beer,1));
    groceryStockItems.add(new StockItem(salmon2, 0));

    Assertions.assertTrue(canAddItem(groceryStockItems, beer));
    Assertions.assertFalse(canAddItem(groceryStockItems, cheese));
    Assertions.assertFalse(canAddItem(groceryStockItems, salmon2));
  }

  @Test
  void substituteItemTest() {
    Cheese cheese = new Cheese("Beechers","Cheese1",15.5,0, 12 );
    Cheese cheese1 = new Cheese("Beechers1","Cheese2",15.5,0,3 );
    Cheese cheese2 = new Cheese("Beechers2","Cheese3",15.5,0,18 );
    Shampoo shampoo1 = new Shampoo("Beechers1","Shampoo2",12.5,0,7 );
    Salmon salmon2 = new Salmon("Beechers2","Salmon3",10.5,0,15 );
    Beer beer2 =new Beer("Beechers2","Beer3",20.5,21,8 );
    PaperTowels paperTowels2 = new PaperTowels("Beechers2","PaperTowel3",5.5,0,17 );
    Shampoo shampoo2 = new Shampoo("Beechers2","Shampoo3",12.5,0,16 );

    List<StockItem> matchingList = new ArrayList<>();
    matchingList.add(new StockItem(cheese,0));
    matchingList.add(new StockItem(cheese1,6));
    matchingList.add(new StockItem(cheese2,2));
    matchingList.add(new StockItem(shampoo1, 0));
    matchingList.add(new StockItem(salmon2, 4));
    matchingList.add(new StockItem(beer2, 10));
    matchingList.add(new StockItem(paperTowels2, 0));
    matchingList.add(new StockItem(shampoo2, 2));

    Assertions.assertEquals(cheese2, SuperMarket.substituteItem(matchingList, cheese));
    Assertions.assertEquals(cheese1, SuperMarket.substituteItem(matchingList, cheese1));
    Assertions.assertEquals(shampoo2, substituteItem(matchingList, shampoo1));
    Assertions.assertEquals(null, substituteItem(matchingList, paperTowels2));
  }

  @Test
  void orderFulfilledTest(){

    Salmon salmon = new Salmon("Beechers","Salmon1",10.5,0, 10);
    Beer beer =new Beer("Beechers","Beer1",20.5,21, 12);
    Cheese cheese = new Cheese("Beechers","Cheese1",15.5,0, 12 );
    PaperTowels paperTowels = new PaperTowels("Beechers","PaperTowel1",5.5,0,15 );
    Shampoo shampoo = new Shampoo("Beechers","Shampoo1",12.5,0,17 );

    List<StockItem> groceryStockItems=new ArrayList<>();
    groceryStockItems.add(new StockItem(salmon,10));
    groceryStockItems.add(new StockItem(cheese,0));
    groceryStockItems.add(new StockItem(beer,0));

    List<StockItem> householdStockItems=new ArrayList<>();
    householdStockItems.add(new StockItem(paperTowels,10));
    householdStockItems.add(new StockItem(shampoo,20));

    ShoppingCart cart = new ShoppingCart();
    cart.setProductList(List.of(cheese, paperTowels));
    Inventory stockInventory = new Inventory(groceryStockItems, householdStockItems);

    ShoppingCart actualShopingCart = orderFulfilled(stockInventory, cart);

    Assertions.assertTrue(actualShopingCart.getProductList().contains(paperTowels));

    Assertions.assertFalse(actualShopingCart.getProductList().contains(cheese));
  }

  @Test
  void orderProcessedTest(){
    Salmon salmon = new Salmon("Beechers","Salmon1",10.5,0, 10);
    Beer beer =new Beer("Beechers","Beer1",20.5,21, 12);
    Cheese cheese = new Cheese("Beechers","Cheese1",15.5,0, 12 );
    PaperTowels paperTowels = new PaperTowels("Beechers","PaperTowel1",5.5,0,15 );
    Shampoo shampoo = new Shampoo("Beechers","Shampoo1",12.5,0,17 );

    List<StockItem> groceryStockItems=new ArrayList<>();
    groceryStockItems.add(new StockItem(salmon,10));
    groceryStockItems.add(new StockItem(cheese,0));
    groceryStockItems.add(new StockItem(beer,0));

    List<StockItem> householdStockItems=new ArrayList<>();
    householdStockItems.add(new StockItem(paperTowels,10));
    householdStockItems.add(new StockItem(shampoo,20));

    Inventory stockInventory = new Inventory(groceryStockItems, householdStockItems);
    ShoppingCart cart = new ShoppingCart();
    cart.setProductList(List.of(cheese, salmon));
    Receipts receipts = new Receipts();
    Customers customer = new Customers("maha", 20, cart);
    Receipts actualReceipt = orderProcessed(stockInventory, cart, receipts, customer);

    Assertions.assertEquals(26, actualReceipt.getTotalPrice());
    Assertions.assertEquals(List.of(cheese, salmon), actualReceipt.getProductsReceived());
    Assertions.assertEquals(new ArrayList<>(), actualReceipt.getProductsOutOfStock());
    Assertions.assertEquals(new ArrayList<>(), actualReceipt.getProductsRemoved());

    ShoppingCart cart1 = new ShoppingCart();
    cart1.setProductList(List.of(cheese, shampoo));
    Receipts receipts1 = new Receipts();
    Customers customer1 = new Customers("maha", 20, cart);
    Receipts actualReceipt1 = orderProcessed(stockInventory, cart1, receipts1, customer1);

    Assertions.assertEquals(28, actualReceipt1.getTotalPrice());
    Assertions.assertEquals(List.of(cheese, shampoo), actualReceipt1.getProductsReceived());
    Assertions.assertEquals(new ArrayList<>(), actualReceipt1.getProductsOutOfStock());
    Assertions.assertEquals(new ArrayList<>(), actualReceipt1.getProductsRemoved());
  }
}