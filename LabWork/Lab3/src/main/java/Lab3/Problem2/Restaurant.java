package Lab3.Problem2;

public class Restaurant {
  private String restaurantName;
  private Address address;
  private Menu menu;
  private boolean open;

  public Restaurant(String restaurantName, Address address, Menu menu, boolean open) {
    this.restaurantName = restaurantName;
    this.address = address;
    this.menu = menu;
    this.open = open;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public boolean isOpen() {
    return open;
  }

  public void setOpen(boolean open) {
    this.open = open;
  }
}
