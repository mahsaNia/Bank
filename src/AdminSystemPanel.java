import java.util.Scanner;

public class AdminSystemPanel
{
    Scanner input = new Scanner(System.in);
    Menu menu = new Menu();

    public void adminSystemMenu1()
    {
        System.out.println("\t*****Log in*****");
        System.out.println(" Enter your information :");
        System.out.print(" 1) ID : ");
        String id = input.next() ;
        System.out.print(" 2) Password : ");
        String password = input.next() ;
        System.out.println();

        boolean found = FinalProject.adminSystemManager.logIn(id, password);

        if(found)
        {
            System.out.println("log in Successfully !");
            System.out.println("-------------------------------------------------------------");
            adminSystemMenu2();
        }
        else
        {
            System.out.println("ID not found !");
            adminSystemMenu1();
        }
    }

    public void adminSystemMenu2()
    {
        int choice = menu.adminSystemMenu();

        switch (choice)
        {
            case 1 : // manage days and Check the status of installments
            {
                manageDays();
                adminSystemMenu2();
                break;
            }

            case 2 : // Check the security of the bank
            {
                FinalProject.adminSystemManager.findRobber(); // بازگردانی پول ها
                adminSystemMenu2();
                break;
            }

            case 3 : // log out
            {
                break;
            }

        }


    }

    public void manageDays()
    {
        // بررسی قسط
        for (int i = 0; i < FinalProject.loans.size(); i++)
        {
            try
            {
                FinalProject.adminSystemManager.payLoanInstallment(i);

            }catch (NotEnoughMoney e)
            {
                e.printStackTrace();
                System.out.println(" This user did not have enough money and got one negative point !");
                System.out.println("---------------------------------------------------------------------");
            }
        }

        // Date update
        System.out.println();
        System.out.println("\tDate update : ");
        System.out.println(" yesterday : " + "   " + MyDate.year + "/" + MyDate.month + "/" + MyDate.day);
        FinalProject.adminSystemManager.manageDays();
        System.out.println(" today : " + "   " + MyDate.year + "/" + MyDate.month + "/" + MyDate.day);
    }

}
