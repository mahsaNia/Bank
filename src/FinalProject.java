import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FinalProject
{
    public static Administrator administrator = new Administrator() ;
    public static ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    public static ArrayList<Person> people = new ArrayList<>();
    public static ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();
    public static ArrayList<InterestFreeAccount> interestFreeAccounts = new ArrayList<>();
    public static ArrayList<Estate> estates = new ArrayList<>();
    public static ArrayList<Check> checks = new ArrayList<>();
    public static AdminSystemManager adminSystemManager = new AdminSystemManager();
    public static ArrayList<Loan> loans = new ArrayList<>();
    public static ArrayList<Loan> helpLoans = new ArrayList<>(); // ارایه کمکی
    public static ArrayList<SavingAccount> savingAccounts = new ArrayList<>();


    public static void main(String[] args)
    {
        DocumentRegistrationPanel documentRegistrationPanel = new DocumentRegistrationPanel();
        CivilRegistrationPanel civilRegistrationPanel = new CivilRegistrationPanel();
        BankPanel bankPanel = new BankPanel();
        FileUpdate fileUpdate = new FileUpdate();
        AdminSystemPanel adminSystemPanel = new AdminSystemPanel();

        Scanner input = new Scanner(System.in);
        int user_type ;
            do
            {
                System.out.println("-------------------------------------------------------------");
                System.out.println("\tMenu");
                System.out.println(" 1) Civil registration system\n 2) Document registration system\n" +
                        " 3) Bank system\n 4) Admin system\n 5) Exit");
                System.out.print("\tEnter your choice ----> ");
                user_type = input.nextInt() ;

                switch (user_type)
                {
                    case 1 :  // Civil registration system
                    {
                        civilRegistrationPanel.civilRegistrationMenu1();
                        break;
                    }

                    case 2 : // Document registration system
                    {
                        documentRegistrationPanel.documentMenu1();
                        break;
                    }

                    case 3 : // Bank system
                    {
                        bankPanel.bankMenu1();
                        break;
                    }

                    case 4 : // Admin system
                    {
                        adminSystemPanel.adminSystemMenu1();
                        break;
                    }

                }
            }while (user_type != 5) ; // Exit

        fileUpdate.bankAccountFile();
        fileUpdate.civilRegistrationFile();
        fileUpdate.documentRegistrationFile();
    }
}
