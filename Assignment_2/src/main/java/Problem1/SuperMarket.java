package Problem1;

import java.util.*;

/**
 *
 */
public class SuperMarket {
  /**
   * Main method
   * @param args has the main method and implementations of the entire code
   */

  public static void main(String[] args) {

    // Initialize all inventory products
    Salmon salmon = new Salmon("Beechers","Salmon1",10.5,0, 10);
    Beer beer =new Beer("Beechers","Beer1",20.5,21, 12);
    Cheese cheese = new Cheese("Beechers","Cheese1",15.5,0, 12 );
    PaperTowels paperTowels = new PaperTowels("Beechers","PaperTowel1",5.5,0,15 );
    Shampoo shampoo = new Shampoo("Beechers","Shampoo1",12.5,0,17 );
    Salmon salmon1 = new Salmon("Beechers1","Salmon2",10.5,0,15 );
    Beer beer1 =new Beer("Beechers1","Beer2",20.5,21,4 );
    Cheese cheese1 = new Cheese("Beechers1","Cheese2",15.5,0,3 );
    PaperTowels paperTowels1 = new PaperTowels("Beechers1","PaperTowels2",5.5,0,5 );
    Shampoo shampoo1 = new Shampoo("Beechers1","Shampoo2",12.5,0,7 );
    Salmon salmon2 = new Salmon("Beechers2","Salmon3",10.5,0,15 );
    Beer beer2 =new Beer("Beechers2","Beer3",20.5,21,8 );
    Cheese cheese2 = new Cheese("Beechers2","Cheese3",15.5,0,18 );
    PaperTowels paperTowels2 = new PaperTowels("Beechers2","PaperTowel3",5.5,0,17 );
    Shampoo shampoo2 = new Shampoo("Beechers2","Shampoo3",12.5,0,16 );

    ShoppingCart shoppingCart = new ShoppingCart() ;
    shoppingCart.setProductList(new ArrayList<Product>());

    List<StockItem> groceryStockItems=new ArrayList<>();
    groceryStockItems.add(new StockItem(salmon,10));
    groceryStockItems.add(new StockItem(cheese,0));
    groceryStockItems.add(new StockItem(beer,0));
    groceryStockItems.add(new StockItem(salmon1,5));
    groceryStockItems.add(new StockItem(cheese1,6));
    groceryStockItems.add(new StockItem(beer1,1));
    groceryStockItems.add(new StockItem(salmon2,10));
    groceryStockItems.add(new StockItem(cheese2,2));
    groceryStockItems.add(new StockItem(beer2,1));

    List<StockItem> householdStockItems=new ArrayList<>();
    householdStockItems.add(new StockItem(paperTowels,10));
    householdStockItems.add(new StockItem(shampoo,20));
    householdStockItems.add(new StockItem(paperTowels1,20));
    householdStockItems.add(new StockItem(shampoo1,20));
    householdStockItems.add(new StockItem(paperTowels2,20));
    householdStockItems.add(new StockItem(shampoo2,20));

    // Create inventory
    Inventory stockInventory = new Inventory(groceryStockItems, householdStockItems);


    // Test customer
    Customers customer = new Customers("maha", 20, shoppingCart);

    //customer orders products
    orderProducts(stockInventory, shoppingCart);

    // Fullfill order. This will be done after order products
    orderFulfilled(stockInventory, shoppingCart);

    Receipts receipts = new Receipts();

    // after customer places order and it is fulfilled it is processed to provide customer products
    orderProcessed(stockInventory, shoppingCart, receipts, customer);

    }

  /**
   *The quantity is set to one by default if the customer does not specify
   * Stock will be adjusted only after the order is processed
   * @param stockInventory object of Inventory class
   * @param cart Customer shopping cart
   */
  static ShoppingCart orderProducts(Inventory stockInventory, ShoppingCart cart) {
    System.out.println("Which items do you want to buy");
    List<StockItem> allStockItems = new ArrayList<>();
    allStockItems.addAll(stockInventory.getGroceryStock());
    allStockItems.addAll(stockInventory.getHouseholdStock());

    for (int j=1; j < allStockItems.size() +  1; j++) {
      System.out.println(j + ". " + allStockItems.get(j-1).getProduct().toString());
    }

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter product item No. and quantity of product");
    System.out.println("Enter 2 numbers separated by space to specify quantity. Default will be 1");
    int itemNo = sc.nextInt();
    int quantity = Optional.ofNullable(sc.nextInt()).orElse(1);
    System.out.println("Your item is : " + allStockItems.get(itemNo).getProduct().toString());
    System.out.println("Your quantity is : " + quantity);

    // does item exist - number is between the entire list
    // quantity of number is less than requested
    if (itemNo <= allStockItems.size()) {
      //&& quantity <= allStockItems.get(itemNo - 1).getQuantity()) {
      cart.getProductList().add(allStockItems.get(itemNo - 1).getProduct());
    } else {
      if (itemNo > allStockItems.size()) {
        System.out.println("Please enter correct item number between 1 and " + allStockItems.size());
      }/* else {
        System.out.println("Enough quantity of product not available. Requested quantity " + quantity +
            " Available quantity is " + allStockItems.get(itemNo - 1).getQuantity());
      }*/
    }

    System.out.println("Do you want to continue shopping. Enter Yes/Y to continue shopping");
    System.out.println(cart.getProductList());
    sc.nextLine();
    String userInput = sc.nextLine();

    if (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("Yes")) {
      //Recursion
      orderProducts(stockInventory, cart);
    } else {
      System.out.println("Thank you for shopping with us.");
      System.out.println("Your final cart details");

      System.out.println(cart.getProductList());
    }

    return cart;
  }

  /**
   *
   Products can be substituted only if it belongs to the same type has weight equal to or
   more than the mentioned one and has price equal to or lesser than the original one
   If no substitution is found the product is removed from the customers cart
   * @param stockInventory object created for Inventory
   * @param cart Customer shopping cart
   */
  static ShoppingCart orderFulfilled(Inventory stockInventory, ShoppingCart cart) {
    List<StockItem> allStockItems = new ArrayList<>();
    allStockItems.addAll(stockInventory.getGroceryStock());
    allStockItems.addAll(stockInventory.getHouseholdStock());

    List<Product> itemsSubstitutedToAdd = new ArrayList<>();
    List<Product> itemsSubstitutedToRemove = new ArrayList<>();
    List<Product> cartNewList = new ArrayList<>();

    for (Product product: cart.getProductList()) {
      boolean canAddItemCheck = canAddItem(allStockItems, product);
      if(canAddItemCheck){
        //Do Nothing
      } else {
        Product pro = substituteItem(allStockItems, product);
        if (pro != null) {
          itemsSubstitutedToAdd.add(pro);
        }
        itemsSubstitutedToRemove.add(product);
      }
      cartNewList.add(product);
    }

    cartNewList.removeAll(itemsSubstitutedToRemove);
    cartNewList.addAll(itemsSubstitutedToAdd);
    cart.setProductList(cartNewList);
    return cart;
  }

  /**
   *
   * @param stockItems
   * @param product
   * @return
   */
  static boolean canAddItem(List<StockItem> stockItems, Product product) {
    for (StockItem stockItem:stockItems) {
      if (stockItem.getProduct().equals(product)) {
        if (stockItem.getQuantity() > 0) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   *
   * @param stockItems all stockItems
   * @param product object created
   * @return returns
   */
  static Product substituteItem(List<StockItem>stockItems, Product product){
    List<StockItem> matchingList = new ArrayList<>();
    for (StockItem stockItem1:stockItems) {
      if(stockItem1.getProduct().getClass().equals(product.getClass())) {
        if (stockItem1.getQuantity() > 0
            && stockItem1.getProduct().getPrice() <= product.getPrice()) {
          if (product.getClass().getSuperclass().getSimpleName().equals("Grocery")) {
            if (((Grocery) stockItem1.getProduct()).getWeight() >= ((Grocery) product).getWeight()) {
              matchingList.add(stockItem1);
            }
          } else if (product.getClass().getSuperclass().getSimpleName().equals("Household")) {
            if(((Household) stockItem1.getProduct()).getUnits() >= ((Household) product).getUnits()) {
              matchingList.add(stockItem1);
            }
          }
        }
      }
    }

    if (matchingList.size()==0){
      return null;
    } else {

      System.out.println("Your final cart details " + matchingList.get(0).getProduct().toString());

      //System.out.println("Your final cart details " + matchingList.get(1).getProduct().toString());
      return matchingList.get(0).getProduct();
    }
  }

  /**
   *Items the customer is not old enough to buy are removed from the cart
   * Quantities are updated in the system
   * Shopping cart is emptied and receipt is generated
   * @param inventory contains list of household and grocery items
   * @param cart every customer has their own shopping cart
   * @param receipts receipt genererated at the end
   * @param customer who buys the products
   */
  static Receipts orderProcessed(Inventory inventory, ShoppingCart cart, Receipts receipts, Customers customer){

    // for all items in shopping cart add them to products received in receipts

    double total = 0.0;
    List<Product> productsInCart = cart.getProductList();

    List<Product> productsRemovedDueToAge = new ArrayList<>();
    List<Product> productsRemovedDueToOutOfStock = new ArrayList<>();
    List<StockItem> groceryStock = inventory.getGroceryStock();
    List<StockItem> householdStock = inventory.getHouseholdStock();
    for (Product pro:productsInCart) {
      if (pro.getAge() == 0 || (pro.getAge() > 0 && customer.getAge() > pro.getAge())) {
        receipts.getProductsReceived().add(pro);
        pro.getPrice();
        total = total+pro.getPrice();

        // Fetch quantity stock item and reduce current quantity
        if (pro.getClass().getSuperclass().getSimpleName().equals("Grocery")) {
          for (int i = 0; i < groceryStock.size(); i++) {
            if (pro == groceryStock.get(i).getProduct()) {
              int currentQuantity = groceryStock.get(i).getQuantity();
              inventory.getGroceryStock().get(i).setQuantity(currentQuantity - 1);
            }
          }
        } else if (pro.getClass().getSuperclass().getSimpleName().equals("Household")) {
          for (int i = 0; i < householdStock.size(); i++) {
            if (pro == householdStock.get(i).getProduct()) {
              int currentQuantity = householdStock.get(i).getQuantity();
              inventory.getHouseholdStock().get(i).setQuantity(currentQuantity - 1);
            }
          }
        }
      } else {
        productsRemovedDueToAge.add(pro);
      }
    }

    // empty cart
    cart.setProductList(new ArrayList<>());

    // setup receipt and print
    receipts.setTotalPrice(total);
    receipts.setProductsRemoved(productsRemovedDueToAge);
    receipts.setProductsOutOfStock(productsRemovedDueToOutOfStock);

    printReceipt(receipts);

    return receipts;
  }

  /**
   *Shopping cart is emptied and receipt is generated
   * @param receipts receipt is generated at the end of shopping
   */
  static void printReceipt(Receipts receipts) {
    System.out.println("Your Receipt Details");
    System.out.println("Products received in this transaction");
    int i = 1;
    for (Product product : receipts.getProductsReceived()) {
      System.out.println(i + ". " + product.toString());
      i++;
    }
    i = 0;

    System.out.println("Products removed from original order due to age");
    if (receipts.getProductsRemoved().size() == 0) {
      System.out.println("none");
    } else {
      for (Product product : receipts.getProductsRemoved()) {
        System.out.println(i + ". " + product.toString());
        i++;
      }
    }
    i = 1;

    System.out.println("Products out of stock from original order");
    if (receipts.getProductsOutOfStock().size() == 0) {
      System.out.println("none");
    } else {
      for (Product product : receipts.getProductsOutOfStock()) {
        System.out.println(i + ". " + product.toString());
        i++;
      }
    }

    System.out.println("Your Receipt total : " + receipts.getTotalPrice());
  }
}


