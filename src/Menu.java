import java.util.*;
public class Menu
{
    Scanner input = new Scanner(System.in);


    public int enter () // متد نوع ورود
    {
        System.out.println("-------------------------------------------------------------");
        System.out.println(" 1) sign in\n 2) log in\n 3) Bank information retrieval\n 4) back");
        System.out.print("\tEnter your choice ----> ");
        int choice = input.nextInt() ;
        return choice ;
    }

    public int bankMainMenu1()
    {
        System.out.println("\t****** welcome to  Bank system ******");
        System.out.println("-------------------------------------------------------------");
        System.out.println("\tWhat do you want to do?");
        System.out.println(" 1) open a bank account\n 2) Deposit money\n 3) withdrawal\n" +
                " 4) Get a bank card\n 5) Get a checkbook and write a check\n 6) cash a cheque\n" +
                " 7) Get a loan\n 8) Receive bank interest\n  9) Money transfer\n 10) log out");
        System.out.print("\tEnter your choice ----> ");
        int choice = input.nextInt() ;
        return choice ;
    }

    public int bankMainMenu2()
    {
        System.out.println("-------------------------------------------------------------");
        System.out.println("\tWhat do you want to do?");
        System.out.println(" 1) open a current account\n 2) open an interest-free account\n " +
                " 3) open a saving account\n 4) back");
        System.out.print("\tEnter your choice ----> ");
        int choice = input.nextInt() ;
        return choice ;
    }

    public int civilAndDocumentRegistrationMenu()
    {
        System.out.println("-------------------------------------------------------------");
        System.out.println("\tWhat do you want to do?");
        System.out.println(" 1) register\n 2) edit info\n 3) delete\n 4) information retrieval\n 5) log out");
        System.out.print("\tEnter your choice ----> ");
        int choice = input.nextInt() ;
        return choice ;
    }

    public int adminSystemMenu()
    {
        System.out.println("-------------------------------------------------------------");
        System.out.println("\tWhat do you want to do?");
        System.out.println(" 1) Manage days and Check the status of installments\n" +
                " 2) Check the security of the bank\n 3) log out");
        System.out.print("\tEnter your choice ----> ");
        int choice = input.nextInt() ;
        return choice ;
    }
}
