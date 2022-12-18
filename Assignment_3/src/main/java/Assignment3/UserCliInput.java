package Assignment3;

/**
 * Creating class UserCliInput which contains the Command Line Arguments
 */
public class UserCliInput {
  private String emailTemplatePath;
  private String letterTemplatePath;
  private String outputDirPath;
  private String csvFilePath;

  /**
   * Empty Constructor
   */
  public UserCliInput() {
    emailTemplatePath = "";
    letterTemplatePath = "";
    outputDirPath = "";
    csvFilePath = "";
  }

  /**
   * gets the path of the email template
   * @return email template path
   */
  public String getEmailTemplatePath() {
    return emailTemplatePath;
  }

  /**
   * sets the email template path
   * @param emailTemplatePath can be set
   */
  public void setEmailTemplatePath(String emailTemplatePath) {
    this.emailTemplatePath = emailTemplatePath;
  }

  /**
   * gets the letter template path
   * @return path
   */
  public String getLetterTemplatePath() {
    return letterTemplatePath;
  }

  /**
   * sets the letter template path
   * @param letterTemplatePath can be set
   */
  public void setLetterTemplatePath(String letterTemplatePath) {
    this.letterTemplatePath = letterTemplatePath;
  }

  /**
   * gives the output directory path where the files are to be generated
   * @return output directory path
   */
  public String getOutputDirPath() {
    return outputDirPath;
  }

  /**
   * sets the output directory path
   * @param outputDirPath can be set
   */
  public void setOutputDirPath(String outputDirPath) {
    this.outputDirPath = outputDirPath;
  }

  /**
   * gets the csv file template which contains the customer details
   * @return csv file path
   */
  public String getCsvFilePath() {
    return csvFilePath;
  }

  /**
   * sets the csv file path
   * @param csvFilePath can be set
   */
  public void setCsvFilePath(String csvFilePath) {
    this.csvFilePath = csvFilePath;
  }
}

