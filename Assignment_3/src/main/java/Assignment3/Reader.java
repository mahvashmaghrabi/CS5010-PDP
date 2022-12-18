package Assignment3;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creating class Reader which has the Main Method
 */
public class Reader {

  /**
   * Main Method which maps objects to the CSV file and also reads the file
   * @param args main method syntax
   */
  public static void main(String[] args)
  {
    ValidateArgs validateArgs = new ValidateArgs();
    UserCliInput userCliInput = validateArgs.validateCLIArgs(args);
    if (userCliInput == null) {
      return;
    }
    generateEmailOrLetter(userCliInput);
  }

  /**
   * generates the email or letter template given
   * @param userCliInput Command line arguments
   */
  static void generateEmailOrLetter(UserCliInput userCliInput) {
    List<Customer> customers = fetchCustomerList(userCliInput.getCsvFilePath());

    new File(userCliInput.getOutputDirPath()).mkdir();

    for (Customer customer: customers) {

      if (!userCliInput.getEmailTemplatePath().isEmpty()
          && !userCliInput.getEmailTemplatePath().isBlank()) {
        String customerName = customer.getFirst_name() + customer.getLast_name() + TemplateType.EMAIL.name();
        try (BufferedWriter templateWriter = new BufferedWriter(new FileWriter(userCliInput.getOutputDirPath()
            + customerName.trim().replaceAll("\"", "") + ".txt"));
             BufferedReader templateReader = new BufferedReader(new FileReader(userCliInput.getEmailTemplatePath()));
        ) {
          TemplateReader.readTemplate(templateReader, templateWriter, customer);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (!userCliInput.getLetterTemplatePath().isEmpty()
          && !userCliInput.getLetterTemplatePath().isBlank()) {
        String customerName = customer.getFirst_name() + customer.getLast_name() + TemplateType.LETTER.name();
        try (BufferedWriter templateWriter = new BufferedWriter(new FileWriter(userCliInput.getOutputDirPath()
            + customerName.trim().replaceAll("\"", "") + ".txt"));
             BufferedReader templateReader = new BufferedReader(new FileReader(userCliInput.getLetterTemplatePath()))
        ) {
          TemplateReader.readTemplate(templateReader, templateWriter, customer);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   *this method remve the quotes in the header fields
   * @param stringWithQuotes header files qoutes
   * @return string replaced quotes
   */
  static String removeQuotes(String stringWithQuotes) {
    return stringWithQuotes.replace("\"","");
  }

  /**
   *fetches the customer list
   * @param csvFileName name of the csv file which has the headers
   * @return customers
   */
  static List<Customer> fetchCustomerList(String csvFileName) {
    List<Customer> customers = new ArrayList<>();
    String splitBy = "\",\"";
    try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
      String line = br.readLine();

      // Mapping column index to field. This will be used later while entering employee details
      Map<String, Integer> columnToIndexMap = new HashMap<>();
      String[] columnHeaders = line.split(splitBy);
      for (int i = 0; i < columnHeaders.length; i++) {
        columnToIndexMap.put(removeQuotes(columnHeaders[i]), i);
      }

      while ((line = br.readLine()) != null) {
        String[] customer = line.split(splitBy);    // use comma as separator
        Customer singleCustomer = new Customer();
        singleCustomer.setFirst_name(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.FIRSTNAME)]));
        singleCustomer.setLast_name(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.LASTNAME)]));
        singleCustomer.setCompany_name(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.COMPANY_NAME)]));

        Address address = new Address();
        address.setAddress(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.ADDRESS)]));
        address.setCity(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.CITY)]));
        address.setCounty(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.COUNTY)]));
        address.setState(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.STATE)]));
        address.setZip(Integer.parseInt(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.ZIPCODE)])));

        PersonalDetails personal = new PersonalDetails();
        personal.setPhone1(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.PHONE_NUMBER1)]));
        personal.setPhone2(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.PHONE_NUMBER2)]));
        personal.setEmail(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.EMAIL)]));
        personal.setWeb(removeQuotes(customer[columnToIndexMap.get(CsvFileHeaders.WEB_URL)]));

        singleCustomer.setAddress(address);
        singleCustomer.setPersonal(personal);
        customers.add(singleCustomer);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return customers;
  }
}

/**
 *Creating an enum
 */
enum TemplateType {
  EMAIL,
  LETTER
}
