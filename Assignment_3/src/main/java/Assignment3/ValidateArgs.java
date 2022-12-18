package Assignment3;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creating class ValidateArgs which contains the arguments
 */
public class ValidateArgs {
  private static final String EMAIL_CLI_ARG = "--email";
  private static final String EMAIL_TEMPLATE_CLI_ARG = "--email-template";
  private static final String LETTER_CLI_ARG = "--letter";
  private static final String LETTER_TEMPLATE_CLI_ARG = "--letter-template";
  private static final String OUTPUT_DIR_CLI_ARG = "--output-dir";
  private static final String CSV_FILE_CLI_ARG = "--csv-file";
  //new-email-template.txt
  private static final String EMAIL_TEMPLATE_FILE_NAME = "email-template.txt";
  private static final String LETTER_TEMPLATE_FILE_NAME = "letter-template.txt";
  private static final List<String> ALL_ARGS = List.of(EMAIL_CLI_ARG, EMAIL_TEMPLATE_CLI_ARG, LETTER_CLI_ARG, LETTER_TEMPLATE_CLI_ARG,
      OUTPUT_DIR_CLI_ARG, CSV_FILE_CLI_ARG);

  /**
   * Empty constructor
   */
  public ValidateArgs() {
  }

  /**
   *command line arguments given through edit configurations
   * @param args command line
   * @return null
   */
  public UserCliInput validateCLIArgs(String[] args) {

    // check if args have been provided
    if (args.length == 0) {
      System.out.println("No command line arguments provided. Please provide CLI arguments");
      printCorrectUserFormat();
      return null;
    }
    int argsLength = args.length;
    UserCliInput userCliInput = new UserCliInput();
    List<String> argsList = Arrays.asList(args);
    //check email or letter not provide
    if (!argsList.contains(EMAIL_CLI_ARG) && !argsList.contains(LETTER_CLI_ARG)) {
      // print CLI args should contain email or letter
      System.out.println("Error: --email or --letter required. \n" +
          "Please provide atleast one type to process");
      printCorrectUserFormat();
      return null;
    }

    // check email
    if (argsList.contains(EMAIL_CLI_ARG)) {
      if (argsList.contains(EMAIL_TEMPLATE_CLI_ARG)) {
        int templateIndex = argsList.indexOf(EMAIL_TEMPLATE_CLI_ARG);
        if ((templateIndex + 1) < argsLength
            && argsList.get(templateIndex + 1).contains(EMAIL_TEMPLATE_FILE_NAME)) {
          String fileName = argsList.get(templateIndex + 1);
          File file = new File(fileName);
          if (!file.exists() && !file.isFile()) {
            System.out.println("Error: Email template file path provided is incorrect");
            printCorrectUserFormat();
          }
          userCliInput.setEmailTemplatePath(fileName);
        } else {
          // print email file path not provide
          System.out.println("Error: Email template file path missing or incorrect");
          printCorrectUserFormat();
          return null;
        }
      } else {
        // print email template not provided
        System.out.println("Error: --email provided but no --email-template was given");
        printCorrectUserFormat();
        return null;
      }
    }

    // check letter

    if (argsList.contains(LETTER_CLI_ARG)) {
      if (argsList.contains(LETTER_TEMPLATE_CLI_ARG)) {
        int templateIndex = argsList.indexOf(LETTER_TEMPLATE_CLI_ARG);
        if ((templateIndex + 1) < argsLength
            && argsList.get(templateIndex + 1).contains(LETTER_TEMPLATE_FILE_NAME)) {
          String fileName = argsList.get(templateIndex + 1);
          File file = new File(fileName);
          if (!file.exists() && !file.isFile()) {
            System.out.println("Error: Letter template file path provided is incorrect");
            printCorrectUserFormat();
          }
          userCliInput.setLetterTemplatePath(fileName);
        } else {
          System.out.println("Error: Letter template file path missing");
          printCorrectUserFormat();
          return null;
        }
      } else {
        System.out.println("Error: --letter provided but no --letter-template was given");
        printCorrectUserFormat();
        return null;
      }
    }

    // check output dir
    if (argsList.contains(OUTPUT_DIR_CLI_ARG)) {
      int outputDirIndex = argsList.indexOf(OUTPUT_DIR_CLI_ARG);
      if ((outputDirIndex + 1) < argsLength
          && !argsList.get(outputDirIndex + 1).isEmpty()) {
        String fileName = argsList.get(outputDirIndex + 1);
        if (ALL_ARGS.contains(fileName)) {
          System.out.println("Error: --output-dir path incorrect");
          printCorrectUserFormat();
          return null;
        }
        userCliInput.setOutputDirPath(fileName);
      } else {
        // print output dir path not given for letter or email
        System.out.println("Error: --output-dir path not given for letter or email");
        printCorrectUserFormat();
        return null;
      }
    } else {
      // output dir arg and path needed
      printCorrectUserFormat();
      return null;
    }

    if (argsList.contains(CSV_FILE_CLI_ARG)) {
      int csvFileIndex = argsList.indexOf(CSV_FILE_CLI_ARG);
      if ((csvFileIndex + 1) < argsLength && !argsList.get(csvFileIndex + 1).isEmpty()) {
        String fileName = argsList.get(csvFileIndex + 1);
        File file = new File(fileName);
        if (!file.exists() && !file.isDirectory() && !!ALL_ARGS.contains(fileName)) {
          System.out.println("Error: CSV file path provided is incorrect");
          printCorrectUserFormat();
        }
        userCliInput.setCsvFilePath(fileName);
      } else {
        // print csv file path not given for customers
        System.out.println("Error: --csv-file path not given ");
        printCorrectUserFormat();
        return null;
      }
    } else {
      // print csv file arg and path needed
      printCorrectUserFormat();
      return null;

    }

    return userCliInput;
  }

  /**
   * Method that prints correct user format to help user provide CLI arguments.
   * this will be invoked if any CLI input provide is incorrect
   */
  private void printCorrectUserFormat() {
    System.out.println("Usage:\n" +
        " --email only generate email messages\n" +
        " --email-template <file> accept a filename that holds the email template.\n" +
        " Required if --email is used\n" +
        " --letter only generate letters\n" +
        " --letter-template <file> accept a filename that holds the letter template.\n" +
        " Required if --letter is used\n" +
        " --output-dir <path> accept the name of a folder, all output is placed in this folder\n" +
        " --csv-file <path> accept the name of the csv file to process\n" +
        "Examples:\n" +
        " --email --email-template email-template.txt --output-dir emails --csv-file customer.csv\n" +
        " --letter --letter-template letter-template.txt --outputdir letters --csv-file customer.csv");
  }
}

