import java.time.LocalDate;

public class InterestFreeAccount extends BankAccount // حساب قرض الحسنه
{
    private BankCard bankCard; // کارت بانکی

    public InterestFreeAccount(long accountNumber, Person person, double balance, int year, int month, int day,
                               int negativePoint, BankCard bankCard, int id)
    {
        super(accountNumber, person, balance, year, month, day, negativePoint, id);
        this.bankCard = bankCard;
    }

    public BankCard getBankCard() {
        return bankCard;
    }
}
