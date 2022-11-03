public class VipDeposits extends SavingAccount // سپرده ویژه
{

    public VipDeposits(long accountNumber, Person person, double balance, int year, int month, int day,
                       int negativePoint, int bankInterestPercentage, Type type, int period, int id)
    {
        super(accountNumber, person, balance, year, month, day, negativePoint, bankInterestPercentage,
                type, period, id);
    }

    @Override
    public double bankDepositInterest()
    {
        if ( (MyDate.month - getMonth()) > 1 )
        {
            double money = super.bankDepositInterest() + getBalance();
            return money;
        }
        else if( (MyDate.month - getMonth()) == 1 && MyDate.day >= 20 )
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
