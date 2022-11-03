public class SavingAccount extends BankAccount // حساب سپرده
{
    private int bankInterestPercentage; // درصد سود بانکی
    Type type; // نوع
    private int period; // مدت تعیین شده

    public SavingAccount(long accountNumber, Person person, double balance, int year, int month, int day,
                         int negativePoint, int bankInterestPercentage, Type type, int period, int id)
    {
        super(accountNumber, person, balance, year, month, day, negativePoint, id);
        this.bankInterestPercentage = bankInterestPercentage;
        this.type = type;
        this.period = period;
    }

    enum Type
    {
        ShortTermDeposits, longTermDeposits, VipDeposits
    }

    public double bankDepositInterest()
    {
        return ( (bankInterestPercentage * getBalance()) / 100 ) ;
    }

}
