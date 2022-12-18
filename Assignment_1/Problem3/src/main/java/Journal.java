public class Journal extends Article{
  private String Publisher;
  private String Editors;

  public Journal(String title, String authors, int year, int citations) {
    super(title, authors, year, citations);
  }

  @Override
  public double estimateImpact() {
    return super.estimateImpact()*2;
  }
}
