package Assignment3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReaderTest {
  private int emailTemplatePathCalled = 0;
  private int csvFileTemplatePathCalled = 0;
  private int letterTemplatePathCalled = 0;
  private int outputDirPathCalled = 0;
  class MockUserCliInput extends UserCliInput {
    @Override
    public String getEmailTemplatePath() {
      emailTemplatePathCalled++;
      return super.getEmailTemplatePath();
    }

    @Override
    public String getLetterTemplatePath() {
      letterTemplatePathCalled++;
      return super.getLetterTemplatePath();
    }

    @Override
    public String getOutputDirPath() {
      outputDirPathCalled++;
      return super.getOutputDirPath();
    }

    @Override
    public String getCsvFilePath() {
      csvFileTemplatePathCalled++;
      return super.getCsvFilePath();
    }
  }

  private UserCliInput userCliInput;

  @BeforeEach
  void setUp() {
    userCliInput = new MockUserCliInput();
    emailTemplatePathCalled = 0;
    letterTemplatePathCalled = 0;
    csvFileTemplatePathCalled = 0;
    outputDirPathCalled = 0;
    userCliInput.setCsvFilePath("D:\\Assignment3_NOJAR\\src\\main\\resources\\test-insurance-company-members.csv");
    userCliInput.setEmailTemplatePath("D:\\Assignment3_NOJAR\\src\\main\\resources\\email-template.txt");
    userCliInput.setOutputDirPath("D:\\Assignment3_NOJAR\\src\\main\\resources\\emails\\");
    userCliInput.setLetterTemplatePath("");
  }

  @Test
  void generateEmailOrLetter_userCLIWithEmail() {
    Reader.generateEmailOrLetter(userCliInput);
    Assertions.assertEquals(4, outputDirPathCalled);
    Assertions.assertEquals(1, csvFileTemplatePathCalled);
    Assertions.assertEquals(9, emailTemplatePathCalled);
    Assertions.assertEquals(3, letterTemplatePathCalled);
  }

  @Test
  void generateEmailOrLetter_userCLIWithLetter() {
    userCliInput.setEmailTemplatePath("");
    userCliInput.setLetterTemplatePath("D:\\Assignment3_NOJAR\\src\\main\\resources\\letter-template.txt");
    Reader.generateEmailOrLetter(userCliInput);
    Assertions.assertEquals(4, outputDirPathCalled);
    Assertions.assertEquals(1, csvFileTemplatePathCalled);
    Assertions.assertEquals(3, emailTemplatePathCalled);
    Assertions.assertEquals(9, letterTemplatePathCalled);
  }

  @Test
  void generateEmailOrLetter_userCLIWithLetterAndEmail() {
    userCliInput.setLetterTemplatePath("D:\\Assignment3_NOJAR\\src\\main\\resources\\letter-template.txt");
    Reader.generateEmailOrLetter(userCliInput);
    Assertions.assertEquals(7, outputDirPathCalled);
    Assertions.assertEquals(1, csvFileTemplatePathCalled);
    Assertions.assertEquals(9, emailTemplatePathCalled);
    Assertions.assertEquals(9, letterTemplatePathCalled);
  }

/*
  @Test
  void generateEmailOrLetter_userCLIWithLetter() {
    Mockito.when(userCliInput.getCsvFilePath()).thenReturn("/Volumes/workplace/MahvashAssignment3/files/test-insurance-company-members.csv");
    Mockito.when(userCliInput.getEmailTemplatePath()).thenReturn("");
    Mockito.when(userCliInput.getOutputDirPath()).thenReturn("/Volumes/workplace/MahvashAssignment3/files/emails/");
    Mockito.when(userCliInput.getLetterTemplatePath()).thenReturn("/Volumes/workplace/MahvashAssignment3/files/letter-template.txt");
    Reader.generateEmailOrLetter(userCliInput);
    Mockito.verify(userCliInput, Mockito.times(4)).getOutputDirPath();
    Mockito.verify(userCliInput, Mockito.times(1)).getCsvFilePath();
    Mockito.verify(userCliInput, Mockito.times(3)).getEmailTemplatePath();
    Mockito.verify(userCliInput, Mockito.times(9)).getLetterTemplatePath();
  }

  @Test
  void generateEmailOrLetter_userCLIWithLetterAndEmail() {
    Mockito.when(userCliInput.getCsvFilePath()).thenReturn("/Volumes/workplace/MahvashAssignment3/files/test-insurance-company-members.csv");
    Mockito.when(userCliInput.getEmailTemplatePath()).thenReturn("/Volumes/workplace/MahvashAssignment3/files/email-template.txt");
    Mockito.when(userCliInput.getOutputDirPath()).thenReturn("/Volumes/workplace/MahvashAssignment3/files/emails/");
    Mockito.when(userCliInput.getLetterTemplatePath()).thenReturn("/Volumes/workplace/MahvashAssignment3/files/letter-template.txt");
    Reader.generateEmailOrLetter(userCliInput);
    Mockito.verify(userCliInput, Mockito.times(7)).getOutputDirPath();
    Mockito.verify(userCliInput, Mockito.times(1)).getCsvFilePath();
    Mockito.verify(userCliInput, Mockito.times(9)).getEmailTemplatePath();
    Mockito.verify(userCliInput, Mockito.times(9)).getLetterTemplatePath();
  }*/

  @Test
  void removeQuotes_StringWithQuotes() {
    Assertions.assertEquals("StringWithQuotes", Reader.removeQuotes("StringWith\"Quotes"));
  }

  @Test
  void removeQuotes_StringWithoutQuotesUnchanged() {
    Assertions.assertEquals("StringWithoutQuotes", Reader.removeQuotes("StringWithoutQuotes"));
  }

  @Test
  void fetchCustomerList() {
    List<Customer> customerList = Reader.fetchCustomerList("D:\\Assignment3_NOJAR\\src\\main\\resources\\test-insurance-company-members.csv");
    Assertions.assertEquals(3, customerList.size());
    Assertions.assertEquals("James", customerList.get(0).getFirst_name());
    Assertions.assertEquals("Benton, John B Jr", customerList.get(0).getCompany_name());
    Assertions.assertEquals("504-845-1427", customerList.get(0).getPersonal().getPhone2());
    Assertions.assertEquals("jbutt@gmail.com", customerList.get(0).getPersonal().getEmail());
  }
}