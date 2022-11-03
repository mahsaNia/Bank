import java.util.concurrent.ThreadLocalRandom;

public class BankAccount // حساب بانکی
{
    private long accountNumber; // شماره حساب
    private Person person; // برای داشتن اطلاعات افراد مثل کد ملیشان
    private double balance; // موجودی
    // تاریخ ساخت
    private int year; private int month; private int day ;
    private int negativePoint; // نمره منفی
    public static int count = 1 ;
    private int id ; // برای لاگین
    private String password;

    public BankAccount(long accountNumber ,Person person, double balance, int year, int month,
                       int day, int negativePoint, int id)
    {
        count++ ;
        this.accountNumber = accountNumber;
        this.person = person;
        this.balance = balance;
        this.year = year;
        this.month = month;
        this.day = day;
        this.negativePoint = negativePoint;
        this.id = id;
    }

    public BankAccount(int id , String password)
    {
        this.id = id ;
        this.password = password ;
    }

    public static long returnAccountNumber()
    {
        long smallest = 1000_0000_0000_0000L;
        long biggest = 9999_9999_9999_9999L;
        long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
        return random;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setNegativePoint(int negativePoint) {
        this.negativePoint = negativePoint;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Person getPerson() {
        return person;
    }

    public double getBalance() {
        return balance;
    }

    public int getNegativePoint() {
        return negativePoint;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
