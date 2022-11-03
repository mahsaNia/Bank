import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BankManager // سامانه بانک
{
    private static BankManager bankManager = new BankManager();
    public static BankManager getBankManager()
    {
        return bankManager;
    }

    // sign in
    public int register(int nationalId, String password)
    {
        for(int i = 0; i < FinalProject.people.size(); i++)
        {
            if(FinalProject.people.get(i).getNationalId() == nationalId)
            {
                int id = BankAccount.count ;
                BankAccount user = new BankAccount(id, password);
                FinalProject.bankAccounts.add(user);
                return id ;
            }
        }
       return 0;
    }

    // log in
    public boolean LogIn(int id, String password)
    {
        boolean found = false ;
        for(int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            if(FinalProject.bankAccounts.get(i).getId() == id)
            {
                if(FinalProject.bankAccounts.get(i).getPassword().equals(password))
                {
                    found = true ;
                    break;
                }
            }
        }
        return found ;
    }

    public long openCurrentAccount(int id ,int nationalId, double balance, int year, int month,
                                   int day, int password)
    {
        long cardNumber = BankCard.returnCardNumber();
        long cvv2 = BankCard.returnCvv2();
        long accountNumber = BankAccount.returnAccountNumber();
        BankCard bankCard = new BankCard(cardNumber, cvv2, password); // ساخت کارت بانکی
        ArrayList<Check> checkBook = new ArrayList<>(); // ساخت دسته چک

        Person person = null;
        for (int i = 0; i < FinalProject.people.size(); i++)
        {
            if(FinalProject.people.get(i).getNationalId() == nationalId)
            {
                 person = FinalProject.people.get(i);
                break;
            }
        }

        CurrentAccount currentAccount = new CurrentAccount(accountNumber, person, balance, year, month,
                day,0, bankCard, checkBook, id);

        FinalProject.currentAccounts.add(currentAccount); // اد کردن به ارایه ی حساب های جاری

        for (int i = 0; i < FinalProject.bankAccounts.size(); i++) // اد کردن به ارایه حساب های بانکی
        {
            if(FinalProject.bankAccounts.get(i).getId() == id)
            {
                FinalProject.bankAccounts.get(i).setAccountNumber(accountNumber);
                FinalProject.bankAccounts.get(i).setPerson(person);
                FinalProject.bankAccounts.get(i).setBalance(balance);
                FinalProject.bankAccounts.get(i).setYear(year);
                FinalProject.bankAccounts.get(i).setMonth(month);
                FinalProject.bankAccounts.get(i).setDay(day);
                FinalProject.bankAccounts.get(i).setNegativePoint(0);
                break;
            }
        }
        return accountNumber;
    }

    public long openInterestFreeAccount(int id ,int nationalId, double balance, int year, int month,
                                        int day, int password)
    {
        long cardNumber = BankCard.returnCardNumber();
        long cvv2 = BankCard.returnCvv2();
        long accountNumber = BankAccount.returnAccountNumber();
        BankCard bankCard = new BankCard(cardNumber, cvv2, password); // ساخت کارت بانکی

        Person person = null;
        for (int i = 0; i < FinalProject.people.size(); i++)
        {
            if(FinalProject.people.get(i).getNationalId() == nationalId)
            {
                person = FinalProject.people.get(i);
                break;
            }
        }

        InterestFreeAccount interestFreeAccount = new InterestFreeAccount(accountNumber, person, balance,
                year, month, day, 0, bankCard, id);

        FinalProject.interestFreeAccounts.add(interestFreeAccount); // اد کردن به ارایه حساب های قرض الحسنه

        for (int i = 0; i < FinalProject.bankAccounts.size(); i++) // اد کردن به ارایه حساب های بانکی
        {
            if(FinalProject.bankAccounts.get(i).getId() == id)
            {
                FinalProject.bankAccounts.get(i).setAccountNumber(accountNumber);
                FinalProject.bankAccounts.get(i).setPerson(person);
                FinalProject.bankAccounts.get(i).setBalance(balance);
                FinalProject.bankAccounts.get(i).setYear(year);
                FinalProject.bankAccounts.get(i).setMonth(month);
                FinalProject.bankAccounts.get(i).setDay(day);
                FinalProject.bankAccounts.get(i).setNegativePoint(0);
                break;
            }
        }
        return accountNumber;
    }

    public void  writeCheck(double amount, String receiverName, String receiverLastName, int receiverNationalID,
                            int year, int month, int day, int ID, int ownerNationalId)
    {
        int receiverAge = 0 ; String receiverGender = null ; double receiverWallet = 0;
        for (int i = 0; i < FinalProject.people.size(); i++)
        {
            if (FinalProject.people.get(i).getNationalId() == receiverNationalID)
            {
                receiverAge = FinalProject.people.get(i).getAge();
                receiverGender = FinalProject.people.get(i).getGender();
                receiverWallet = FinalProject.people.get(i).getWallet();
                break;
            }
        }

        int ownerAge = 0; String ownerGender = null; double ownerWallet = 0;
        String ownerName = null; String ownerLastName = null;
        for (int i = 0; i < FinalProject.people.size(); i++)
        {
            if (FinalProject.people.get(i).getNationalId() == ownerNationalId)
            {
                ownerAge = FinalProject.people.get(i).getAge();
                ownerGender = FinalProject.people.get(i).getGender();
                ownerWallet = FinalProject.people.get(i).getWallet();
                ownerName = FinalProject.people.get(i).getName();
                ownerLastName = FinalProject.people.get(i).getLastName();
                break;
            }
        }


        Person receiver = new Person(receiverName, receiverLastName, receiverAge,
                receiverGender, receiverNationalID, receiverWallet);
        Person owner = new Person(ownerName, ownerLastName, ownerAge, ownerGender, ownerNationalId, ownerWallet);

        for (int i = 0; i < FinalProject.currentAccounts.size(); i++)
        {
            if(FinalProject.currentAccounts.get(i).getId() == ID)
            {
                FinalProject.currentAccounts.get(i).getCheckBook().get(i).setAmount(amount);
                FinalProject.currentAccounts.get(i).getCheckBook().get(i).setReceiver(receiver);
                FinalProject.currentAccounts.get(i).getCheckBook().get(i).setAccountProprietor(owner);
                FinalProject.currentAccounts.get(i).getCheckBook().get(i).setMonth(month);
                FinalProject.currentAccounts.get(i).getCheckBook().get(i).setYear(year);
                FinalProject.currentAccounts.get(i).getCheckBook().get(i).setDayDate(day);
                FinalProject.currentAccounts.get(i).getCheckBook().get(i).setOwnerAccountNumber(FinalProject
                        .currentAccounts.get(i).getAccountNumber());

                FinalProject.checks.add(FinalProject.currentAccounts.get(i).getCheckBook().get(i));
                break;
            }
        }
    }

    // وصول چک
    public void  cashCheque(int receiverId)
    {
        int receiverNationalId = 0 ;
        int ownerNationalId = 0 ;
        for (int i = 0; i < FinalProject.currentAccounts.size(); i++)
        {
            if(FinalProject.currentAccounts.get(i).getId() == receiverId)
            {
                receiverNationalId = FinalProject.currentAccounts.get(i).getPerson().getNationalId();
                break;
            }
        }

        for (int i = 0; i < FinalProject.checks.size(); i++)
        {
            if(FinalProject.checks.get(i).getReceiver().getNationalId() == receiverNationalId)
            {
                ownerNationalId = FinalProject.checks.get(i).getAccountProprietor().getNationalId();
                break;
            }
        }

        // وصول چک
        for (int i = 0; i < FinalProject.checks.size(); i++)
        {
            if(FinalProject.checks.get(i).getReceiver().getNationalId() == receiverNationalId)
            {
                for(int j = 0; j < FinalProject.currentAccounts.size(); j++)
                {
                    if(FinalProject.currentAccounts.get(j).getPerson().getNationalId() == receiverNationalId)
                    {
                        for (int k = 0; k < FinalProject.currentAccounts.size(); k++)
                        {
                            if(FinalProject.currentAccounts.get(k).getPerson().getNationalId() == ownerNationalId)
                            {
                                FinalProject.currentAccounts.get(j).setBalance(FinalProject.currentAccounts
                                        .get(j).getBalance() + FinalProject.checks.get(i).getAmount()); // واریز پول

                                FinalProject.currentAccounts.get(k).setBalance(FinalProject.currentAccounts.get(k)
                                        .getBalance() - FinalProject.checks.get(i).getAmount());
                                break;
                            }
                        }
                    }
                }
            }
        }

        // **
        for (int i = 0; i < FinalProject.checks.size(); i++)
        {
            if(FinalProject.checks.get(i).getReceiver().getNationalId() == receiverNationalId)
            {
                for(int j = 0; j < FinalProject.bankAccounts.size(); j++)
                {
                    if(FinalProject.bankAccounts.get(j).getPerson().getNationalId() == receiverNationalId)
                    {
                        for (int k = 0; k < FinalProject.bankAccounts.size(); k++)
                        {
                            if(FinalProject.bankAccounts.get(k).getPerson().getNationalId() == ownerNationalId)
                            {
                                FinalProject.bankAccounts.get(j).setBalance(FinalProject.bankAccounts
                                        .get(j).getBalance() + FinalProject.checks.get(i).getAmount()); // واریز پول

                                FinalProject.bankAccounts.get(k).setBalance(FinalProject.bankAccounts.get(k)
                                        .getBalance() - FinalProject.checks.get(i).getAmount());
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public int getLoan(int nationalId, int initialLoanAmount, int interestPercentage, int totalNumberPayment)
    {
        for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            if(FinalProject.bankAccounts.get(i).getPerson().getNationalId() == nationalId)
            {
                if (FinalProject.bankAccounts.get(i).getNegativePoint() < 5) // وام تعلق میگیرد
                {
                    Loan loan = new Loan(initialLoanAmount, interestPercentage, totalNumberPayment, nationalId);
                    FinalProject.loans.add(loan); FinalProject.helpLoans.add(loan);
                    FinalProject.bankAccounts.get(i).getPerson().setWallet(FinalProject.bankAccounts.get(i)
                            .getPerson().getWallet() + initialLoanAmount); // اضافه کردن وام به کیف پول
                    return 1 ;
                }
                else
                {
                    return 0 ;
                }
            }
        }
        return 0 ;
    }

    public long openSavingAccount(int id, int nationalId, double balance, int year, int month, int day,
                                  SavingAccount.Type type)
    {
        long accountNumber = BankAccount.returnAccountNumber();

        Person person = null;
        for (int i = 0; i < FinalProject.people.size(); i++)
        {
            if(FinalProject.people.get(i).getNationalId() == nationalId)
            {
                person = FinalProject.people.get(i);
                break;
            }
        }

        if (type == SavingAccount.Type.ShortTermDeposits) // کوتاه مدت
        {
            SavingAccount shortTermDeposits = new ShortTermDeposits(accountNumber, person, balance,year,
                    month, day, 0, 10, type, 10, id);
            FinalProject.savingAccounts.add(shortTermDeposits);
        }

        else if (type == SavingAccount.Type.longTermDeposits) // بلند مدت
        {
            SavingAccount longTermDeposit = new longTermDeposits(accountNumber, person, balance,year,
                    month, day, 0,30, type, 30, id);
            FinalProject.savingAccounts.add(longTermDeposit);

        }

        else if(type == SavingAccount.Type.VipDeposits) // ویژه
        {
            SavingAccount vipDeposits = new VipDeposits(accountNumber, person, balance,year,
                    month, day, 0,50, type, 50, id);
            FinalProject.savingAccounts.add(vipDeposits);
        }

        for (int i = 0; i < FinalProject.bankAccounts.size(); i++) // اد کردن به ارایه حساب های بانکی
        {
            if(FinalProject.bankAccounts.get(i).getId() == id)
            {
                FinalProject.bankAccounts.get(i).setAccountNumber(accountNumber);
                FinalProject.bankAccounts.get(i).setPerson(person);
                FinalProject.bankAccounts.get(i).setBalance(balance);
                FinalProject.bankAccounts.get(i).setYear(year);
                FinalProject.bankAccounts.get(i).setMonth(month);
                FinalProject.bankAccounts.get(i).setDay(day);
                FinalProject.bankAccounts.get(i).setNegativePoint(0);
                break;
            }
        }
        return accountNumber;
    }

    public void receiveBankInterest(int nationalId)
    {
        for (int i = 0; i < FinalProject.savingAccounts.size(); i++)
        {
            if (FinalProject.savingAccounts.get(i).getPerson().getNationalId() == nationalId)
            {
                double money = FinalProject.savingAccounts.get(i).bankDepositInterest();
                for (int j = 0; j < FinalProject.bankAccounts.size(); j++)
                {
                    if (FinalProject.bankAccounts.get(i).getPerson().getNationalId() == nationalId)
                    {
                        FinalProject.bankAccounts.get(j).getPerson().setWallet(FinalProject.bankAccounts
                                .get(j).getPerson().getWallet() + money);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void withdrawal(int id, double balance)
    {
        for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            if(FinalProject.bankAccounts.get(i).getId() == id)
            {
                FinalProject.bankAccounts.get(i).getPerson().setWallet(FinalProject.bankAccounts.get(i).getPerson()
                        .getWallet() + balance); // واریز وجه به کیف پول

                // کسر مبلغ از حساب
                FinalProject.bankAccounts.get(i).setBalance(FinalProject.bankAccounts.get(i).getBalance() - balance);
                break;
            }
        }
    }

    public void fromYourWalletToYourBankAccount(long accountNumber, double balance)
    {
        for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            if (FinalProject.bankAccounts.get(i).getAccountNumber() == accountNumber)
            {
                FinalProject.bankAccounts.get(i).setBalance(FinalProject.bankAccounts.get(i).getBalance()
                        + balance); // واریز وجه به حساب

                // کسر مبلغ از کیف پول
                FinalProject.bankAccounts.get(i).getPerson().setWallet(FinalProject.bankAccounts.get(i).getPerson()
                        .getWallet() - balance);
                break;
            }
        }

    }

    public void fromYourWalletToPeopleAccount(int id, long accountNumber,  double balance)
    {
        for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            if(FinalProject.bankAccounts.get(i).getId() == id)
            {
                FinalProject.bankAccounts.get(i).getPerson().setWallet(FinalProject.bankAccounts.get(i)
                        .getPerson().getWallet() - balance);
                break;
            }
        }

        for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            if (FinalProject.bankAccounts.get(i).getAccountNumber() == accountNumber)
            {
               FinalProject.bankAccounts.get(i).setBalance(FinalProject.bankAccounts.get(i).getBalance() +
                       balance);
               break;
            }
        }

    }

    public void moneyTransfer(long yourAccountNumber, long destinationAccountNum,double balance)
    {
        for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            if(FinalProject.bankAccounts.get(i).getAccountNumber() == yourAccountNumber)
            {
                FinalProject.bankAccounts.get(i).setBalance(FinalProject.bankAccounts.get(i).getBalance() - balance);
                break;
            }
        }

        for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            if(FinalProject.bankAccounts.get(i).getAccountNumber() == destinationAccountNum)
            {
                FinalProject.bankAccounts.get(i).setBalance(FinalProject.bankAccounts.get(i).getBalance() + balance);
                break;
            }
        }

    }

    // بازیابی اطلاعات بانکی
    public void bankInformationRetrieval()
    {
        File file1 = new File("C:\\Users\\Niazi\\IdeaProjects\\bankAccount.text");
        try(Scanner s1 = new Scanner(file1))
        {
            while (s1.hasNext())
            {
                // person
                int age = s1.nextInt();
                int nationalId = s1.nextInt();
                double wallet = s1.nextDouble();
                String name = s1.next();
                String lastName = s1.next();
                String gender = s1.next();

                long accountNum = s1.nextLong();
                double balance = s1.nextDouble();
                int year = s1.nextInt();
                int month = s1.nextInt();
                int day = s1.nextInt();
                int negativePoint = s1.nextInt();
                int id = s1.nextInt();
                String password = s1.next();

                Person person = new Person(name, lastName, age, gender, nationalId, wallet);
                BankAccount bankAccount = new BankAccount(accountNum, person, balance, year, month, day,
                        negativePoint, id);
                FinalProject.bankAccounts.add(bankAccount);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
