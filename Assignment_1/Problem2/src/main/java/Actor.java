public class Actor extends Artist{
  private String Movies;
  private String Series;
  private String multiMedia;

  public String getMovies() {
    return Movies;
  }

  public void setMovies(String movies) {
    Movies = movies;
  }

  public String getSeries() {
    return Series;
  }

  public void setSeries(String series) {
    Series = series;
  }

  public String getMultiMedia() {
    return multiMedia;
  }

  public void setMultiMedia(String multiMedia) {
    this.multiMedia = multiMedia;
  }
}
