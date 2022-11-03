public class Check
{
    private double amount; // مبلغ
    private Person receiver; // دریافت کننده
    private Person accountProprietor; // صاحب حساب
    // تاریخ وصول چک
    private int year ;
    private int month ;
    private int dayDate ;
    private long ownerAccountNumber; //  شماره حساب صاحب چک

    public Check(double amount, Person receiver, Person accountProprietor, int year, int month,
                 int dayDate, int ownerAccountNumber)
    {
        this.amount = amount;
        this.receiver = receiver;
        this.accountProprietor = accountProprietor;
        this.year = year;
        this.month = month;
        this.dayDate = dayDate;
        this.ownerAccountNumber = ownerAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public Person getReceiver() {
        return receiver;
    }

    public Person getAccountProprietor() {
        return accountProprietor;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayDate() {
        return dayDate;
    }

    public long getOwnerAccountNumber() {
        return ownerAccountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public void setAccountProprietor(Person accountProprietor) {
        this.accountProprietor = accountProprietor;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDayDate(int dayDate) {
        this.dayDate = dayDate;
    }

    public void setOwnerAccountNumber(long ownerAccountNumber) {
        this.ownerAccountNumber = ownerAccountNumber;
    }
}
