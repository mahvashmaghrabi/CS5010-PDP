package Lab3.Problem2;

import java.util.*;

public class Menu {
  private List <String> meals;
  private List <String> desserts;
  private List <String> beverages;
  private List <String> drinks;


  public Menu(List<String> meals, List<String> desserts, List<String> beverages, List<String> drinks) {
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;

  }

  public List<String> getMeals() {
    return meals;
  }

  public void setMeals(List<String> meals) {
    this.meals = meals;
  }

  public List<String> getDesserts() {
    return desserts;
  }

  public void setDesserts(List<String> desserts) {
    this.desserts = desserts;
  }

  public List<String> getBeverages() {
    return beverages;
  }

  public void setBeverages(List<String> beverages) {
    this.beverages = beverages;
  }

  public List<String> getDrinks() {
    return drinks;
  }

  public void setDrinks(List<String> drinks) {
    this.drinks = drinks;
  }



}

