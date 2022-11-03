import java.util.ArrayList;

public class CurrentAccount extends BankAccount //حساب جاری
{
   private BankCard bankCard ; // کارت بانکی
   private ArrayList<Check> checkBook = new ArrayList<>(); // دسته چک

   public CurrentAccount(long accountNumber, Person person, double balance, int year, int month, int day,
                         int negativePoint, BankCard bankCard, ArrayList<Check> checkBook, int id)
   {
      super(accountNumber, person, balance, year, month, day, negativePoint, id);
      this.bankCard = bankCard;
      this.checkBook = checkBook;
   }

   public BankCard getBankCard() {
      return bankCard;
   }

   public ArrayList<Check> getCheckBook() {
      return checkBook;
   }

}
