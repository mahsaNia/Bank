public class Loan // وام بانکی
{
    private int initialLoanAmount; // مبلغ اولیه وام
    private int amountOfEachPayment ; // مبلغ هر قسط
    private int interestPercentage ; // درصد سود
    private int totalNumberPayment; // تعداد کل اقساط
    private int receiverNationalId; // کد ملی گیرنده وام

    public Loan(int initialLoanAmount, int interestPercentage, int totalNumberPayment, int receiverNationalId)
    {
        this.initialLoanAmount = initialLoanAmount;
        this.interestPercentage = interestPercentage;
        this.totalNumberPayment = totalNumberPayment;
        this.receiverNationalId = receiverNationalId;
    }

    public int calculatePayment() // متد محاسبه هر قسط
    {
        this.amountOfEachPayment = ( ( initialLoanAmount * ((interestPercentage/100) + 1) ) / totalNumberPayment );
        return this.amountOfEachPayment;
    }

    public int getInitialLoanAmount() {
        return initialLoanAmount;
    }

    public int getAmountOfEachPayment() {
        return amountOfEachPayment;
    }

    public int getInterestPercentage() {
        return interestPercentage;
    }

    public int getTotalNumberPayment() {
        return totalNumberPayment;
    }

    public int getReceiverNationalId() {
        return receiverNationalId;
    }

    public void setInitialLoanAmount(int initialLoanAmount) {
        this.initialLoanAmount = initialLoanAmount;
    }

    public void setAmountOfEachPayment(int amountOfEachPayment) {
        this.amountOfEachPayment = amountOfEachPayment;
    }

    public void setInterestPercentage(int interestPercentage) {
        this.interestPercentage = interestPercentage;
    }

    public void setTotalNumberPayment(int totalNumberPayment) {
        this.totalNumberPayment = totalNumberPayment;
    }

    public void setReceiverNationalId(int receiverNationalId) {
        this.receiverNationalId = receiverNationalId;
    }
}
