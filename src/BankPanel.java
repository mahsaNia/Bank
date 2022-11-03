import java.util.Scanner;

public class BankPanel // پنل سامانه بانک
{
    Scanner input = new Scanner(System.in);
    Menu menu = new Menu();

    public void bankMenu1()
    {
        int choice = menu.enter();
         switch (choice)
         {
             case 1 : // sign in
             {
                 signIn();
                 break;
             }

             case 2 : // log in
             {
                 login();
                 break;
             }

             case 3 : // Bank information retrieval
             {
                 bankInformationRetrieval();
                 bankMenu1();
                 break;
             }

             case 4 : // back
             {
                 break;
             }

         }
    }

    public void bankMenu2()
    {
        int choice = menu.bankMainMenu1();

        switch (choice)
        {
            case 1 : // open a bank account
            {
               bankMenu3();
               break;
            }

            case 2 : // Deposit money واریز وجه
            {
                System.out.println(" what do you want to do ? ");
                System.out.println(" 1)Deposit money from your wallet to your bank account\n" +
                        " 2) Deposit money from your wallets to other people's accounts");
                System.out.print(" enter your choice : "); int num = input.nextInt();
                    switch (num)
                    {
                        case 1 : // Deposit money from your wallet to your bank account
                        {
                            fromYourWalletToYourBankAccount();break;
                        }
                        case 2 : // Deposit money from your wallets to other people's accounts
                        {
                            fromYourWalletToPeopleAccount();break;
                        }
                    }
                    bankMenu2();
                    break;
            }

            case 3 : // withdrawal برداشت وجه
            {
                withdrawal();
                bankMenu2();
                break;
            }

            case 4 : // Get a bank card
            {
                System.out.println(" choose your bank account : ");
                System.out.println(" 1) Current Account\n 2) Interest-Free Account"); int num = input.nextInt();
                switch (num)
                {
                    case 1 : // Current Account
                    {
                        getBankCardForCurrentAccount();
                        break;
                    }
                    case 2 : // Interest-Free Account
                    {
                        getBankCardForInterestFreeAccount();
                        break;
                    }
                }
                bankMenu2();
                break;
            }

            case 5 : // Get a checkbook and write a check
            {
                getCheckbookAndWriteCheck();
                break;
            }

            case 6 : // cash a cheque وصول چک
            {
                System.out.println("\t**** cash a cheque ****");
                System.out.print(" Enter your id : "); int id = input.nextInt();
                BankManager.getBankManager().cashCheque(id); System.out.println(" Your check has been received.");
                bankMenu2(); break;
            }

            case 7 : // Get a loan گرفتن وام
            {
                getLoan();
                bankMenu2();
                break;
            }

            case 8 : // Receive bank interest دریافت سود بانکی
            {
                receiveBankInterest();
                bankMenu2();
                break;
            }

            case 9 : // Money transfer
            {
                moneyTransfer();
                bankMenu2();break;
            }

            case 10 : // log out
            {
                break;
            }

        }

    }

    public void bankMenu3()
    {
        int choice = menu.bankMainMenu2();

        switch (choice)
        {
            case 1 : // open a current account
            {
                openCurrentAccount();
                bankMenu3();
                break;
            }

            case 2 : // open an interest-free account
            {
                openInterestFreeAccount();
                bankMenu3();
                break;
            }

            case 3 : // open a saving account
            {
               try {
                   openSavingAccount();
               }catch (InvalidType e)
               {
                   e.printStackTrace();
               }
               bankMenu3();
               break;
            }

            case 4 : // back
            {
               bankMenu2();
            }

        }

    }

    public void signIn()
    {
        System.out.println("\t*****Sign in*****");
        System.out.println("\tcreate an account");
        System.out.print(" Enter your national id : ");
        int nationalId = input.nextInt();
        System.out.print(" Enter a password : ");
        String password = input.next() ;
        int id = BankManager.getBankManager().register(nationalId, password);

        if(id == 0)
        {
            System.out.println(" Your information is not registered in the civil registration system !! ");
            bankMenu1();
        }
        else
        {
            System.out.println(" your id is : " + id);
            bankMenu2();
        }
    }

    public void login()
    {
        System.out.println("\t*****Log in*****");
        System.out.println(" Enter your information :");
        System.out.print(" 1) ID : ");
        int id = input.nextInt() ;
        System.out.print(" 2) Password : ");
        String password = input.next() ;
        System.out.println();

        boolean found = BankManager.getBankManager().LogIn(id, password) ;

        if(found)
        {
            System.out.println("log in Successfully !");
            System.out.println("-------------------------------------------------------------");
            bankMenu2();
        }
        else
        {
            System.out.println("ID not found !");
            bankMenu1();
        }
    }

    public void openCurrentAccount()
    {
        System.out.println("\t***** open a current account *****");
        System.out.println(" Enter your information :");
        System.out.print(" 1) id : ");
        int id = input.nextInt();
        System.out.print(" 2) national ID number : ");
        int nationalId = input.nextInt();
        System.out.print(" 3) balance : ");
        double balance = input.nextDouble();
        System.out.print(" 4) a password for your bank card : ");
        int password = input.nextInt();

        long accountNum = BankManager.getBankManager().openCurrentAccount(id, nationalId, balance,MyDate.year, MyDate.month,
                MyDate.day, password);
        System.out.println(" your account number is " + accountNum);
    }

    public void openInterestFreeAccount()
    {
        System.out.println("\t***** open an interest-free account *****");
        System.out.println(" Enter your information :");
        System.out.print(" 1) id : ");
        int id = input.nextInt();
        System.out.print(" 2) national ID number : ");
        int nationalId = input.nextInt();
        System.out.print(" 3) balance : ");
        double balance = input.nextDouble();
        System.out.print(" 4) a password for your bank card : ");
        int password = input.nextInt();

        long accountNum = BankManager.getBankManager().openInterestFreeAccount(id, nationalId, balance, MyDate.year,
                MyDate.month, MyDate.day, password);
        System.out.println(" your account number is " + accountNum);
    }

    public void getBankCardForCurrentAccount()
    {
        System.out.print(" Enter your id : ");
        int id = input.nextInt();

        for (int i = 0; i < FinalProject.currentAccounts.size(); i++)
        {
            if (FinalProject.currentAccounts.get(i).getId() == id)
            {
                System.out.println(" your bank card : ");
                System.out.println(" card number : " + FinalProject.currentAccounts.get(i).getBankCard()
                        .getCardNumber());
                System.out.println(" cvv2 : " + FinalProject.currentAccounts.get(i).getBankCard().getCvv2());
                System.out.println(" expiration date : " + FinalProject.currentAccounts.get(i)
                        .getBankCard().getExpirationDate());
                System.out.println(" password : " + FinalProject.currentAccounts.get(i).getBankCard().getPassword());
                break;
            }
        }
    }

    public void getBankCardForInterestFreeAccount()
    {
        System.out.println(" Enter your id : ");
        int id = input.nextInt();

        for (int i = 0; i < FinalProject.interestFreeAccounts.size(); i++)
        {
            if (FinalProject.interestFreeAccounts.get(i).getId() == id)
            {
                System.out.println(" your bank card : ");
                System.out.println(" card number : " + FinalProject.interestFreeAccounts.get(i).getBankCard()
                        .getCardNumber());
                System.out.println(" cvv2 : " + FinalProject.interestFreeAccounts.get(i).getBankCard().getCvv2());
                System.out.println(" expiration date : " + FinalProject.interestFreeAccounts.get(i)
                        .getBankCard().getExpirationDate());
                System.out.println(" password : " + FinalProject.interestFreeAccounts.get(i)
                        .getBankCard().getPassword());
                break;
            }
        }
    }

    public void getCheckbookAndWriteCheck()
    {
        System.out.println(" Enter your id : ");
        int id = input.nextInt();

        for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            if (FinalProject.bankAccounts.get(i).getId() == id)
            {
                System.out.println(" your check book : ");
                System.out.println(" account proprietor : " + FinalProject.bankAccounts.get(i).getPerson().getName()
                        + "  " + FinalProject.bankAccounts.get(i).getPerson().getLastName());
                System.out.println(" owner account number : " + FinalProject.bankAccounts.get(i)
                        .getAccountNumber());
                break;
            }
        }
        System.out.println("---------------------------------------------------------");
        System.out.println(" Do you want to write a check for someone?" + "  1) yes   2) no ");
        System.out.print(" enter your choice : ");
        int num = input.nextInt();

        if(num == 1)
        {
            System.out.println(" Enter the information : ");
            System.out.print(" 1) amount : ");
            double amount = input.nextDouble();
            System.out.print(" 2) receiver name : ");
            String receiverName = input.next();
            System.out.print(" 3) receiver last name : ");
            String receiverLastName = input.next();
            System.out.print(" 4) receiver national Id : ");
            int receiverNationalID = input.nextInt();
            System.out.println(" 5) Date of receipt of the check : ");
            System.out.print(" | year : ");
            int year = input.nextInt();
            System.out.print(" | month : ");
            int month = input.nextInt();
            System.out.print(" | day : ");
            int day = input.nextInt();
            System.out.print(" 6) your Id : ");
            int ID = input.nextInt();
            System.out.print(" 7) your national Id : ");
            int ownerNationalId = input.nextInt();

            BankManager.getBankManager().writeCheck(amount, receiverName, receiverLastName, receiverNationalID,
                    year, month, day, ID, ownerNationalId);
            bankMenu2();
        }
        else
        {
            bankMenu2();
        }
    }

    public void getLoan()
    {
        System.out.println("\t***** Get a loan *****");
        System.out.println(" Enter the information : ");
        System.out.print(" 1) your national id : ");
        int nationalId = input.nextInt();
        System.out.print(" 2) initial loan amount : ");
        int initialLoanAmount = input.nextInt();
        System.out.println(" 3) interest percentage : ");
        int interestPercentage = input.nextInt();
        System.out.println(" 4) total number of payment :   * 6 payment  or  * 12 payment");
        int totalNumberPayment = input.nextInt();

        int result = BankManager.getBankManager().getLoan(nationalId, initialLoanAmount,
                interestPercentage, totalNumberPayment);
        if(result == 1)
        {
            System.out.println(" Your request was registered and you were given a loan. ");
        }
        else if(result == 0)
        {
            System.out.println(" Oh! You have more than 5 negative points and you can not get a loan !!");
        }
    }

    public void openSavingAccount() throws InvalidType
    {
        System.out.println("\t***** open an saving account *****");
        System.out.println(" Enter your information :");
        System.out.println(" 1) id : ");
        int id = input.nextInt();
        System.out.println(" 2) national ID number : ");
        int nationalId = input.nextInt();
        System.out.println(" 3) balance : ");
        double balance = input.nextDouble();

        System.out.println(" what type do you want?");
        System.out.println(" 1) Short term deposits\n 2) long term deposits\n 3) Vip deposits");
        System.out.print(" Enter your choice : ");
        int type = input.nextInt();
                if(type == 1)
               {
                  long accountNum = BankManager.getBankManager().openSavingAccount(id, nationalId, balance, MyDate.year,
                           MyDate.month, MyDate.day, SavingAccount.Type.ShortTermDeposits);
                   System.out.println(" your account number is " + accountNum);
               }
                else if(type == 2)
                {
                   long accountNum = BankManager.getBankManager().openSavingAccount(id, nationalId, balance, MyDate.year,
                            MyDate.month, MyDate.day, SavingAccount.Type.longTermDeposits);
                    System.out.println(" your account number is " + accountNum);
                }
                else if (type == 3)
                {
                    long accountNum = BankManager.getBankManager().openSavingAccount(id, nationalId, balance, MyDate.year,
                            MyDate.month, MyDate.day, SavingAccount.Type.VipDeposits);
                    System.out.println(" your account number is " + accountNum);
                }
                else
                {
                    throw new InvalidType();
                }

    }

    public void receiveBankInterest()
    {
        System.out.println("\t***** Receive bank interest *****");
        System.out.print(" Enter your national id: ");
        int nationalId = input.nextInt();
        BankManager.getBankManager().receiveBankInterest(nationalId);
        System.out.println(" The operation was successful");
    }

    public void withdrawal()
    {
        System.out.println("\t***** withdrawal ******");
        System.out.print(" 1) enter your id: ");
        int id = input.nextInt();
        System.out.print(" 2) enter the balance: ");
        double balance = input.nextDouble();

        BankManager.getBankManager().withdrawal(id, balance);
        System.out.println(" The amount was transferred to your wallet.");
    }

    public void fromYourWalletToYourBankAccount()
    {
        System.out.print(" Enter your account number: ");
        long accountNumber = input.nextLong();
        System.out.print(" Enter the balance : ");
        double balance = input.nextDouble();

        BankManager.getBankManager().fromYourWalletToYourBankAccount(accountNumber, balance);
        System.out.println(" The amount was transferred to your bank account.");
    }

    public void fromYourWalletToPeopleAccount()
    {
        System.out.println(" Enter your id: ");
        int id = input.nextInt();
        System.out.println(" Enter destination account number: ");
        long accountNumber = input.nextLong();
        System.out.println(" Enter balance: ");
        double balance = input.nextDouble();

        BankManager.getBankManager().fromYourWalletToPeopleAccount(id, accountNumber, balance);
        System.out.println(" The amount was transferred to bank account.");
    }

    public void moneyTransfer()
    {
        System.out.println(" Enter the information : ");
        System.out.print(" 1) your account number : ");
        long yourAccountNumber = input.nextLong();
        System.out.print(" 2) destination account number : ");
        long destinationAccountNum = input.nextLong();
        System.out.print(" 3) balance : ");
        double balance = input.nextLong();

        BankManager.getBankManager().moneyTransfer(yourAccountNumber, destinationAccountNum, balance);
    }

    public void bankInformationRetrieval() // بازیابی و چاپ
    {
        BankManager.getBankManager().bankInformationRetrieval();
        System.out.println(" Data retrieved. You can see the list : ");
        for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
        {
            System.out.println(" national id : " + FinalProject.bankAccounts.get(i).getPerson().getNationalId()
            + "   account number : " + FinalProject.bankAccounts.get(i).getAccountNumber()
            + "    balance : " + FinalProject.bankAccounts.get(i).getBalance());
            System.out.println("--------------------------------------------------------");
        }
    }

}
