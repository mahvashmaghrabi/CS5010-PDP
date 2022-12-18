import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransitCardTest {

  @BeforeEach
  void setUp() {

  }
  @Test
  void testdepositMoney() throws Exception {

    Balance bal = new Balance();
    bal.setDollars(18);
    bal.setCents(97);

    cardOwner card = new cardOwner();
    card.setFirstname("x");
    card.setLastname("y");
    double d = 40.95;
    Deposit deposit = new Deposit("x", "y", d);
    TransitCard tcard = new TransitCard(card, bal);
    tcard.depositMoney(deposit);
    Assertions.assertEquals(tcard.getCardBalance().getDollars(),59);

  }
}