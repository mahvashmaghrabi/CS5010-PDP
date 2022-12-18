package Assignment3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ValidateArgsTest {
  private static final String EMAIL_PATH = "/Volumes/workplace/MahvashAssignment3/files/email-template.txt";
  private static final String LETTER_PATH = "/Volumes/workplace/MahvashAssignment3/files/letter-template.txt";
  private static final String OUTPUT_DIR_PATH = "/Volumes/workplace/MahvashAssignment3/files/emails/";
  private static final String CSV_FILE_PATH = "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv";
  private static final String[] CORRECT_INPUT_EMAIL = {"--email", "--email-template", "/Volumes/workplace/MahvashAssignment3/files/email-template.txt",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] CORRECT_INPUT_LETTER = {"--letter", "--letter-template", "/Volumes/workplace/MahvashAssignment3/files/letter-template.txt",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] CORRECT_INPUT_EMAIL_LETTER = {"--email", "--email-template", "/Volumes/workplace/MahvashAssignment3/files/email-template.txt",
      "--letter", "--letter-template", "/Volumes/workplace/MahvashAssignment3/files/letter-template.txt",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] INCORRECT_INPUT_EMAIL_TEMPLATE_MISSING = {"--email", "/Volumes/workplace/MahvashAssignment3/files/email-template.txt",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] INCORRECT_INPUT_EMAIL_PATH_MISSING = {"--email", "--email-template",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] INCORRECT_INPUT_LETTER_TEMPLATE_MISSING = {"--letter", "/Volumes/workplace/MahvashAssignment3/files/letter-template.txt",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] INCORRECT_INPUT_LETTER_PATH_MISSING = {"--letter", "--letter-template",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] INCORRECT_INPUT_OUTPUT_DIR_PATH_MISSING = {"--email", "--email-template", "/Volumes/workplace/MahvashAssignment3/files/email-template.txt",
      "--output-dir",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] INCORRECT_INPUT_CSV_FILE_PATH_MISSING = {"--email", "--email-template", "/Volumes/workplace/MahvashAssignment3/files/email-template.txt",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file"};
  String[] INCORRECT_INPUT_OUTPUT_DIR_MISSING = {"--email", "--email-template", "/Volumes/workplace/MahvashAssignment3/files/email-template.txt",
      "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] INCORRECT_INPUT_CSV_FILE_MISSING = {"--email", "--email-template", "/Volumes/workplace/MahvashAssignment3/files/email-template.txt",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  String[] INCORRECT_INPUT_EMAIL_AND_LETTER_MISSING = {"--email-template", "/Volumes/workplace/MahvashAssignment3/files/email-template.txt",
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv"};
  private static final String[] INCORRECT_INPUT = {};
  String[] INCORRECT_INPUT_EMAIL_TEMPLATE_MISSING_END_OF_FILE = {
      "--output-dir", "/Volumes/workplace/MahvashAssignment3/files/emails/",
      "--csv-file", "/Volumes/workplace/MahvashAssignment3/files/insurance-company-members.csv",
      "--email", "--email-template"};

  private UserCliInput userCliInput = new UserCliInput();
  private ValidateArgs validateArgs = new ValidateArgs();

  @BeforeEach
  void setUp() {
  }

  @Test
  void validateCLIArgs_CorrectEmailTemplate() {
    userCliInput = validateArgs.validateCLIArgs(CORRECT_INPUT_EMAIL);
    Assertions.assertEquals(EMAIL_PATH, userCliInput.getEmailTemplatePath());
    Assertions.assertEquals("", userCliInput.getLetterTemplatePath());
    Assertions.assertEquals(OUTPUT_DIR_PATH, userCliInput.getOutputDirPath());
    Assertions.assertEquals(CSV_FILE_PATH, userCliInput.getCsvFilePath());
  }

  @Test
  void validateCLIArgs_CorrectLetterTemplate() {
    userCliInput = validateArgs.validateCLIArgs(CORRECT_INPUT_LETTER);
    Assertions.assertEquals("", userCliInput.getEmailTemplatePath());
    Assertions.assertEquals(LETTER_PATH, userCliInput.getLetterTemplatePath());
    Assertions.assertEquals(OUTPUT_DIR_PATH, userCliInput.getOutputDirPath());
    Assertions.assertEquals(CSV_FILE_PATH, userCliInput.getCsvFilePath());
  }

  @Test
  void validateCLIArgs_CorrectEmailLetterTemplate() {
    userCliInput = validateArgs.validateCLIArgs(CORRECT_INPUT_EMAIL_LETTER);
    Assertions.assertEquals(EMAIL_PATH, userCliInput.getEmailTemplatePath());
    Assertions.assertEquals(LETTER_PATH, userCliInput.getLetterTemplatePath());
    Assertions.assertEquals(OUTPUT_DIR_PATH, userCliInput.getOutputDirPath());
    Assertions.assertEquals(CSV_FILE_PATH, userCliInput.getCsvFilePath());
  }

  @Test
  void validateCLIArgs_IncorrectEmailInputTemplateMissing() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_EMAIL_TEMPLATE_MISSING);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectEmailInputPathMissing() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_EMAIL_PATH_MISSING);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectLetterInputOutputDirPathMissing() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_OUTPUT_DIR_PATH_MISSING);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectLetterInputOutputDirMissing() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_OUTPUT_DIR_MISSING);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectLetterInputTemplateMissing() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_LETTER_TEMPLATE_MISSING);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectLetterInputPathMissing() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_LETTER_PATH_MISSING);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectEmailInputCsvFilePathMissing() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_CSV_FILE_PATH_MISSING);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectEmailInputCsvFileMissing() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_CSV_FILE_MISSING);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectInputEmailAndLetterMissing() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_EMAIL_AND_LETTER_MISSING);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectInputEmptyArgs() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT);
    Assertions.assertEquals(null, userCliInput);
  }

  @Test
  void validateCLIArgs_IncorrectInputEmailEndOfIndex() {
    userCliInput = validateArgs.validateCLIArgs(INCORRECT_INPUT_EMAIL_TEMPLATE_MISSING_END_OF_FILE);
    Assertions.assertEquals(null, userCliInput);
  }
}