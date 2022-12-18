
public class TransitCard {
  private cardOwner cardOwner;
  private Balance cardBalance;

  public cardOwner getCardOwner() {
    return cardOwner;
  }

  public void setCardOwner(cardOwner cardOwner) {
    this.cardOwner = cardOwner;
  }

  public Balance getCardBalance() {
    return cardBalance;
  }

  public void setCardBalance(Balance cardBalance) {
    this.cardBalance = cardBalance;
  }

  public TransitCard(cardOwner cardOwner, Balance cardBalance) {
    this.cardOwner = cardOwner;
    this.cardBalance = cardBalance;
  }

  public void depositMoney(Deposit newDeposit) throws Exception {
    if(!this.cardOwner.getFirstname().equals(newDeposit.getFirstname())||
    !this.cardOwner.getLastname().equals(newDeposit.getLastname())){
      throw new Exception("Name does not match");
    }
    double d = newDeposit.getDeposit_amount();
    int dollar = cardBalance.getDollars();
    int cent = cardBalance.getCents();

    String doubleAsString = String.valueOf(d);
    int indexOfDecimal = doubleAsString.indexOf(".");
    System.out.println("Double Number: " + d);
    int dollar_amt = Integer.parseInt(doubleAsString.substring(0, indexOfDecimal));
    int cent_amt =  Integer.parseInt(doubleAsString.substring(indexOfDecimal+1));

    int add_cent = cent + cent_amt;
    int carry = 0;
    carry = add_cent/100;
    add_cent = add_cent % 100;

    System.out.println("carry Number: " + carry);
    System.out.println("cent Number: " + add_cent);

    dollar_amt = dollar + dollar_amt + carry;

    System.out.println("dollar Number: " + dollar_amt);
    cardBalance.setDollars(dollar_amt);
    cardBalance.setCents(add_cent);


  }
}






