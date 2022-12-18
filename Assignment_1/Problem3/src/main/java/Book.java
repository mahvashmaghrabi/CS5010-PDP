public class Book extends Publications {
  private String publishingCompany;
  private int noOfPages;

  @Override
  public double estimateImpact() {
    return super.estimateImpact()*4;


  }


}
