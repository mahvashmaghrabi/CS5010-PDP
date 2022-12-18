package Assignment3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creating class Template Reader which contains all the methods to read, write and replace the file
 */
public class TemplateReader {
  private static final Pattern EMAIL_PATTERN = fetchCommonPattern(CsvFileHeaders.EMAIL);
  private static final Pattern FIRST_NAME_PATTERN =  fetchCommonPattern(CsvFileHeaders.FIRSTNAME);
  private static final Pattern LAST_NAME_PATTERN = fetchCommonPattern(CsvFileHeaders.LASTNAME);
  private static final Pattern COMPANY_NAME_PATTERN = fetchCommonPattern(CsvFileHeaders.COMPANY_NAME);
  private static final Pattern ADDRESS_PATTERN = fetchCommonPattern(CsvFileHeaders.ADDRESS);
  private static final Pattern CITY_PATTERN = fetchCommonPattern(CsvFileHeaders.CITY);
  private static final Pattern COUNTY_PATTERN = fetchCommonPattern(CsvFileHeaders.COUNTY);
  private static final Pattern STATE_PATTERN = fetchCommonPattern(CsvFileHeaders.STATE);
  private static final Pattern ZIP_PATTERN = fetchCommonPattern(CsvFileHeaders.ZIPCODE);
  private static final Pattern PHONE1_PATTERN = fetchCommonPattern(CsvFileHeaders.PHONE_NUMBER1);
  private static final Pattern PHONE2_PATTERN = fetchCommonPattern(CsvFileHeaders.PHONE_NUMBER2);
  private static final Pattern WEB_PATTERN = fetchCommonPattern(CsvFileHeaders.WEB_URL);

  /**
   *
   * @param templateReader reads the template
   * @param templateWriter writes into the template by replacing the required fields
   * @param customer a csv file which contains the customer list
   */
  public static void readTemplate(BufferedReader templateReader, BufferedWriter templateWriter, Customer customer) {
    try {
      String strCurrentLine;
      while ((strCurrentLine = templateReader.readLine()) != null) {
        //System.out.println(strCurrentLine);
        writeTextToFile(strCurrentLine, templateWriter, customer);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Write the templtae into another file while replacing the required fields
   * @param textToWrite writes the text into a new file
   * @param bufferedWriter writes into a new file
   * @param customer variable name of the Customer file
   */
  public static void writeTextToFile(String textToWrite, BufferedWriter bufferedWriter, Customer customer) {
    try {
      boolean shouldReplaceText = regex(textToWrite);

      if (shouldReplaceText) {
        String replacedText = replaceText(textToWrite, customer);
        //System.out.println(replacedText);
        bufferedWriter.write(replacedText);
      } else {
        //System.out.println(textToWrite);
        bufferedWriter.write(textToWrite);
      }
      bufferedWriter.newLine();
    } catch (IOException e) {
      System.out.print(e.getMessage());
    }
  }

  /**
   * Regex methods checks if the given text matches the pattern
   * @param fileText text file which contains the template
   * @return true or false
   */
  public static boolean regex(String fileText) {
    // String to be scanned to find the pattern.
    String patternMatcher = "\\[{2}\\w+\\]{2}";
    Pattern pattern = Pattern.compile(patternMatcher);
    Matcher matcher = pattern.matcher(fileText);
    return matcher.find();
  }

  /**
   * Replaces the matching pattern with the Customers in the CSV file
   * @param textToReplace present in the template
   * @param customer variable name of the Customer class
   * @return replaced text
   */
  public static String replaceText(String textToReplace, Customer customer) {
    textToReplace = EMAIL_PATTERN.matcher(textToReplace).replaceAll(customer.getPersonal().getEmail());
    textToReplace = FIRST_NAME_PATTERN.matcher(textToReplace).replaceAll(customer.getFirst_name());
    textToReplace = LAST_NAME_PATTERN.matcher(textToReplace).replaceAll(customer.getLast_name());
    textToReplace = COMPANY_NAME_PATTERN.matcher(textToReplace).replaceAll(customer.getCompany_name());
    textToReplace = ADDRESS_PATTERN.matcher(textToReplace).replaceAll(customer.getAddress().getAddress());
    textToReplace = CITY_PATTERN.matcher(textToReplace).replaceAll(customer.getAddress().getCity());
    textToReplace = COUNTY_PATTERN.matcher(textToReplace).replaceAll(customer.getAddress().getCounty());
    textToReplace = STATE_PATTERN.matcher(textToReplace).replaceAll(customer.getAddress().getState());
    textToReplace = ZIP_PATTERN.matcher(textToReplace).replaceAll(String.valueOf(customer.getAddress().getZip()));
    textToReplace = PHONE1_PATTERN.matcher(textToReplace).replaceAll(customer.getPersonal().getPhone1());
    textToReplace = PHONE2_PATTERN.matcher(textToReplace).replaceAll(customer.getPersonal().getPhone2());
    textToReplace = WEB_PATTERN.matcher(textToReplace).replaceAll(customer.getPersonal().getWeb());
    return textToReplace;
  }

  /**
   *fetches the common pattern
   * @param patternString String pattern
   * @return pattern replaced by given data
   */
  private static Pattern fetchCommonPattern(String patternString) {
    return Pattern.compile("\\[{2}" + patternString + "\\]{2}",
        Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
  }
}




