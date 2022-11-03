import java.util.concurrent.ThreadLocalRandom;

public class BankCard // کارت بانکی
{
    private long cardNumber; // شماره کارت
    private long cvv2 ;
    private final String expirationDate = "1406/4/20" ;
    private int password; // رمز کارت

    public BankCard(long cardNumber, long cvv2, int password)
    {
        this.cardNumber = cardNumber;
        this.cvv2 = cvv2;
        this.password = password;
    }

    public static long returnCardNumber()
    {
        long smallest = 1000_0000_0000_0000L;
        long biggest = 9999_9999_9999_9999L;
        long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
        return random;
    }

    public static long returnCvv2()
    {
        long smallest = 1000;
        long biggest = 9999;
        long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
        return random;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public long getCvv2() {
        return cvv2;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getPassword() {
        return password;
    }
}
