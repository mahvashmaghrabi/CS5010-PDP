package Problem1;

/**
 * Creating class Product
 */
public class Product {
 private String manufacturerName;
 private String productName;
 private double price;
 private int age;

 @Override
 public String toString() {
  return
      "ProductName='" + productName + '\'' +
      "manufacturerName='" + manufacturerName + '\'' +
      ", price=" + price ;
 }

 /**
  * Constructor for Product class
  * @param manufacturerName Name of the product manufacturer
  * @param productName Name of the product
  * @param price Price of product
  * @param age Age of Customer
  */
 public Product(String manufacturerName, String productName, double price, int age) {
  this.manufacturerName = manufacturerName;
  this.productName = productName;
  this.price = price;
  this.age = age;
 }

 /**
  * Generate getter
  * @return returns manufacturer name
  */
 public String getManufacturerName() {
  return manufacturerName;
 }

 /**
  * Generate setter
  * @param manufacturerName sets manufacturer name
  */
 public void setManufacturerName(String manufacturerName) {
  this.manufacturerName = manufacturerName;
 }

 /**
  * Generates getter
  * @return returns product name
  */
 public String getProductName() {

  return productName;
 }

 /**
  * Generates setter
  * @param productName sets product name
  */
 public void setProductName(String productName) {
  this.productName = productName;
 }

 /**
  * getter
  * @return returns price
  */
 public double getPrice() {
  return price;
 }

 /**
  * setter
  * @param price sets price
  */
 public void setPrice(double price) {
  this.price = price;
 }

 /**
  * getter
  * @return returns age
  */
 public int getAge() {
  return age;
 }

 /**
  * setter
  * @param age sets age
  */
 public void setAge(int age) {
  this.age = age;
 }
}


