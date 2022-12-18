public class conferenceProceeding extends Article {
  private String name;
  private String location;

  public conferenceProceeding(String title, String authors, int year, int citations) {
    super(title, authors, year, citations);
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}

