import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class AdminSystemManager
{
    // log in
    public boolean logIn(String adminID, String adminPassword)
    {
        boolean found = false ;
        if(FinalProject.administrator.getAdminID().equals(adminID))
        {
            if(FinalProject.administrator.getAdminPassword().equals(adminPassword))
            {
                found = true ;
            }
        }
        return found ;
    }

    // manage days
    public void manageDays()
    {
        // date
        if (MyDate.day == 31)
        {
            MyDate.month++ ;
            MyDate.day = 1 ;
        }
        else
        {
            MyDate.day++ ;
        }

        MyDate.counter++ ;
    }

    public void payLoanInstallment(int i) throws NotEnoughMoney
    {
                int amountOfEachPayment = FinalProject.loans.get(i).calculatePayment(); // مقدار هر قسط
                int nationalId = FinalProject.loans.get(i).getReceiverNationalId();
                for (int j = 0; j < FinalProject.bankAccounts.size(); j++)
                {
                    if(FinalProject.bankAccounts.get(j).getPerson().getNationalId() == nationalId)
                    {
                        if (amountOfEachPayment <= FinalProject.bankAccounts.get(j).getPerson().getWallet() &&
                                FinalProject.loans.get(i).getTotalNumberPayment() != 0)
                        {
                            FinalProject.bankAccounts.get(j).getPerson().setWallet(FinalProject.bankAccounts.get(j)
                                    .getPerson().getWallet() - amountOfEachPayment); // کسر قسط

                            FinalProject.loans.get(i).setTotalNumberPayment(FinalProject.loans.get(i)
                                    .getTotalNumberPayment() - 1); // کسر از تعداد اقساط
                        }
                        else
                        {
                            if(amountOfEachPayment > FinalProject.bankAccounts.get(j).getPerson().getWallet()) // کمبود پول
                            {
                                FinalProject.bankAccounts.get(j).setNegativePoint(FinalProject.bankAccounts
                                        .get(j).getNegativePoint() + 1);
                                throw new NotEnoughMoney();
                            }
                        }
                        break;
                    }
                }
    }

    public void findRobber()
    {
        ArrayList<BankAccount> helpBankAccounts = new ArrayList<>();
        ArrayList<Person> helpPerson = new ArrayList<>();
        ArrayList<Estate> helpEstate = new ArrayList<>();
        File file4 = new File("C:\\Users\\Niazi\\IdeaProjects\\bankAccount.text");
        try(Scanner s = new Scanner(file4))
        {
            while (s.hasNext())
            {
                // person
                int age = s.nextInt();
                int nationalId = s.nextInt();
                double wallet = s.nextDouble();
                String name = s.next();
                String lastName = s.next();
                String gender = s.next();

                long accountNum = s.nextLong();
                double balance = s.nextDouble();
                int year = s.nextInt();
                int month = s.nextInt();
                int day = s.nextInt();
                int negativePoint = s.nextInt();
                int id = s.nextInt();
                String password = s.next();

                Person person = new Person(name, lastName, age, gender, nationalId, wallet);
                BankAccount bankAccount = new BankAccount(accountNum, person, balance, year, month, day,
                        negativePoint, id);

                helpBankAccounts.add(bankAccount);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //*************************************************************************
        File file5 = new File("C:\\Users\\Niazi\\IdeaProjects\\people.text");
        try(Scanner s5 = new Scanner(file5))
        {
            while (s5.hasNext())
            {
                int nationalId = s5.nextInt();
                int age = s5.nextInt();
                double wallet = s5.nextDouble();
                String name = s5.next();
                String lastName = s5.next();
                String gender = s5.next();

                helpPerson.add(new Person(name, lastName, age, gender, nationalId, wallet));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //*****************************************************************************
        File file6 = new File("C:\\Users\\Niazi\\IdeaProjects\\estate.text");
        try(Scanner s6 = new Scanner(file6))
        {
            while (s6.hasNext())
            {
                int nationalId = s6.nextInt();
                double value = s6.nextDouble();
                int code = s6.nextInt();
                String address = s6.next();
                String date = s6.next();

                helpEstate.add(new Estate(code, nationalId, address, date, value));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //****************************************************************************
        for (int i = 0; i < helpBankAccounts.size(); i++)
        {
            System.out.print("  " + helpBankAccounts.get(i).getPerson().getName()
                    + "  " + helpBankAccounts.get(i).getPerson().getLastName() +
                    "  national ID: " + helpBankAccounts.get(i).getPerson().getNationalId() +
                    "   gender: " + helpBankAccounts.get(i).getPerson().getGender() +
                    "  wallet: " + helpBankAccounts.get(i).getPerson().getWallet() +
                    "  age: " + helpBankAccounts.get(i).getPerson().getAge() + "   account number: " +
                    helpBankAccounts.get(i).getAccountNumber() + "    balance: " +
                    helpBankAccounts.get(i).getBalance());

            int nationalId = helpBankAccounts.get(i).getPerson().getNationalId();
            for (int j = 0; j < helpEstate.size(); j++)
            {
                if (helpEstate.get(j).getNationalId() == nationalId)
                {
                    System.out.println("  address: " + helpEstate.get(j).getEstateAddress());
                    break;
                }
            }
        }
        //**************************************************************
        for (int i = 0; i < helpBankAccounts.size(); i++) // واریز پول به کیف پول
        {
            double money = helpBankAccounts.get(i).getBalance();
            helpBankAccounts.get(i).getPerson().setWallet(helpBankAccounts.get(i).getPerson().getWallet()
                    + money);

            helpPerson.get(i).setWallet(helpPerson.get(i).getWallet() + money);

            helpBankAccounts.get(i).setBalance(0);
        }
        //***************************************************************

        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < helpBankAccounts.size(); i++)
        {
            System.out.print("  " + helpBankAccounts.get(i).getPerson().getName()
                    + "  " + helpBankAccounts.get(i).getPerson().getLastName() +
                    "  national ID: " + helpBankAccounts.get(i).getPerson().getNationalId() +
                    "   gender: " + helpBankAccounts.get(i).getPerson().getGender() +
                    "  wallet: " + helpBankAccounts.get(i).getPerson().getWallet() +
                    "  age: " + helpBankAccounts.get(i).getPerson().getAge() + "   account number: " +
                    helpBankAccounts.get(i).getAccountNumber() + "    balance: " +
                    helpBankAccounts.get(i).getBalance());

            int nationalId = helpBankAccounts.get(i).getPerson().getNationalId();
            for (int j = 0; j < helpEstate.size(); j++)
            {
                if (helpEstate.get(j).getNationalId() == nationalId)
                {
                    System.out.println("  address: " + helpEstate.get(j).getEstateAddress());
                    break;
                }
            }
        }

        // برگرداندن به فایل
        // فایل حساب های بانکی

        try(FileWriter file1 = new FileWriter("C:\\Users\\Niazi\\IdeaProjects\\bankAccount.text");
            Formatter f1 = new Formatter(file1))
        {
            for (int i = 0; i < helpBankAccounts.size(); i++)
            {
                // person
                f1.format("%d %d %f %s %s %s ", helpBankAccounts.get(i).getPerson().getAge(),
                        helpBankAccounts.get(i).getPerson().getNationalId(),
                        helpBankAccounts.get(i).getPerson().getWallet(),
                        helpBankAccounts.get(i).getPerson().getName(),helpBankAccounts
                                .get(i).getPerson().getLastName(), helpBankAccounts.get(i)
                                .getPerson().getGender());

                // bank account
                f1.format(" %d %f  %d %d %d  %d %d %s\n",
                        helpBankAccounts.get(i).getAccountNumber(), helpBankAccounts.get(i)
                                .getBalance(), helpBankAccounts.get(i).getYear(), helpBankAccounts.get(i).getMonth(),
                        helpBankAccounts.get(i).getDay(),
                        helpBankAccounts.get(i).getNegativePoint(), helpBankAccounts.get(i)
                                .getId(), helpBankAccounts.get(i).getPassword());
            }
            f1.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        // فایل ثبت احوال

        try(FileWriter file2 = new FileWriter("C:\\Users\\Niazi\\IdeaProjects\\people.text");
            Formatter f2 = new Formatter(file2))
        {
            for (int i = 0; i < helpPerson.size(); i++)
            {
                f2.format("%d  %d  %f  %s %s  %s\n",helpPerson.get(i).getNationalId(),helpPerson
                                .get(i).getAge(), helpPerson.get(i).getWallet(),helpPerson.get(i).getName(),
                        helpPerson.get(i).getLastName(), helpPerson.get(i).getGender());
            }
            f2.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        // فایل ثبت اسناد
        try(FileWriter file3 = new FileWriter("C:\\Users\\Niazi\\IdeaProjects\\estate.text");
            Formatter f3 = new Formatter(file3))
        {
            for (int i = 0; i < helpEstate.size(); i++)
            {
                f3.format("%d  %f  %d %s  %s\n", helpEstate.get(i).getNationalId(), helpEstate
                                .get(i).getValue(), helpEstate.get(i).getDocumentRegistrationCode(),
                        helpEstate.get(i).getEstateAddress(), helpEstate.get(i).getPurchaseDate());
            }
            f3.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        System.exit(0);



    }

}
