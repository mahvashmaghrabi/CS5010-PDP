package Problem1;

/**
 * Creating a Customer Class
 */
public class Customers {
  private String name;
  private int age;
  private ShoppingCart cart;

  /**
   * Constructor for Customer class
   * @param name Name of the customer
   * @param age Age of the customer
   * @param cart Shopping cart of customer
   */
  public Customers(String name, int age, ShoppingCart cart) {
    this.name = name;
    this.age = age;
    this.cart = cart;
  }

  /**
   * Generating a getter
   * @return returns name
   */
  public String getName() {
    return name;
  }

  /**
   * Generating a setter
   * @param name sets name of the customer
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Generating getter
   * @return return age
   */
  public int getAge() {
    return age;
  }

  /**
   * Generating a setter
   * @param age sets Age of the customer
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Generating a getter
   * @return returns customer Shopping cart
   */
  public ShoppingCart getCart() {
    return cart;
  }

  /**
   * Generating a setter
   * @param cart sets cart value
   */
  public void setCart(ShoppingCart cart) {
    this.cart = cart;
  }

}
