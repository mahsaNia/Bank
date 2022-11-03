public class longTermDeposits extends SavingAccount // حساب سپرده بلند مدت
{
    public longTermDeposits(long accountNumber, Person person, double balance, int year, int month, int day,
                            int negativePoint, int bankInterestPercentage, Type type, int period, int id)
    {
        super(accountNumber, person, balance, year, month, day, negativePoint, bankInterestPercentage,
                type, period, id);
    }

    @Override
    public double bankDepositInterest()
    {
        if ((MyDate.day - getDay()) >= 30)
        {
            double money = super.bankDepositInterest() + getBalance();
            return money;
        }
        else
        {
            return getBalance();
        }
    }
}
