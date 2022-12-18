public class Publications {

  private String title;
  private String authors;
  private int year=1800;
  private int citations;

  public double estimateImpact() {
    System.out.println("estimate base");
    if (noOfYears() < 3)
    {
      return citations+100;
    }
    else if(noOfYears()>250){

      System.out.println("returns exception as book is very old");return 0.00000000000000000000000000;
    }
    else{
      return citations / noOfYears();
    }

  }

  public int noOfYears(){

    System.out.println(java.time.LocalDate.now());
    System.out.println(java.time.LocalDate.now().getYear() - year);
    return (java.time.LocalDate.now().getYear() - year);

  }

}

