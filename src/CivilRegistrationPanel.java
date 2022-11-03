import java.util.Scanner;
public class CivilRegistrationPanel // پنل سامانه ثبت احوال
{
    Scanner input = new Scanner(System.in);
    Menu menu = new Menu();

    public void civilRegistrationMenu1()
    {
        System.out.println("\t*****Log in*****");
        System.out.println(" Enter your information :");
        System.out.print(" 1) ID : ");
        String id = input.next() ;
        System.out.print(" 2) Password : ");
        String password = input.next() ;

        CivilRegistrationManager.getCivilRegistrationManager().logIn(id, password);
        civilRegistrationMenu2();
    }

    public void civilRegistrationMenu2()
    {
        int choice = menu.civilAndDocumentRegistrationMenu();

        switch (choice)
        {
            case 1 : // register
            {
                register();
                civilRegistrationMenu2();
                break;
            }

            case 2 : // edit info
            {
                editInfo();
                break;
            }

            case 3 : // delete
            {
                delete();
                break;
            }

            case 4 : // information retrieval
            {
                informationRetrieval();
                civilRegistrationMenu2();
                break;
            }

            case 5 : // log out
            {
                break;
            }
        }

    }

    public void register()
    {
        System.out.println("\t***** register people *****");
        System.out.println(" Enter the information :");
        System.out.print(" 1) Name : ");
        String name = input.next() ;
        System.out.print(" 2) Last name : ");
        String lastName = input.next() ;
        System.out.print(" 3) age : ");
        int age = input.nextInt();
        System.out.print(" 4) gender : ");
        String gender = input.next() ;
        System.out.print(" 5) national id : ");
        int nationalId  = input.nextInt();
        System.out.print(" 6) wallet : ");
        double wallet = input.nextDouble();
        System.out.println();

        CivilRegistrationManager.getCivilRegistrationManager().register(name, lastName, age, gender,
                nationalId, wallet);

        System.out.println(" Choose one :\n 1) Add more    2) End");
        int num = input.nextInt() ;
        while (num == 1)
        {
            System.out.println("-------------------------------------------------------------");
            System.out.println(" Enter the information :");
            System.out.print(" 1) Name : ");
            String name1 = input.next() ;
            System.out.print(" 2) Last name : ");
            String lastName1 = input.next() ;
            System.out.print(" 3) age : ");
            int age1 = input.nextInt();
            System.out.print(" 4) gender : ");
            String gender1 = input.next() ;
            System.out.print(" 5) national id : ");
            int nationalId1  = input.nextInt();
            System.out.println(" 6) wallet : ");
            double wallet1 = input.nextDouble();
            System.out.println();

            CivilRegistrationManager.getCivilRegistrationManager().register(name1, lastName1, age1, gender1,
                    nationalId1, wallet1);

            System.out.println(" Choose one :\n 1) Add more    2) End");
            num = input.nextInt() ;
        }
    }

    public void editInfo()
    {
        System.out.println("\t*****Edit Info*****");
        System.out.println(" Enter the information :");
        System.out.print(" Enter the national id : ");
        int nationalId  = input.nextInt();
        System.out.print(" 1) new name : ");
        String newName = input.next() ;
        System.out.print(" 2) new last name : ");
        String newLastName = input.next() ;
        System.out.print(" 3) new age : ");
        int newAge = input.nextInt();
        System.out.print(" 4) new gender : ");
        String newGender = input.next() ;
        System.out.println(" 5) new wallet : ");
        double newWallet = input.nextDouble();
        System.out.println();

        boolean found = CivilRegistrationManager.getCivilRegistrationManager().editInfo(nationalId, newName,
                newLastName, newAge, newGender, newWallet);

        if(found)
        {
            System.out.println(" Edit successfully !");
            System.out.println("-------------------------------------------------------------");
            civilRegistrationMenu2();
        }
        else
        {
            System.out.println(" national id  not found !!");
            System.out.println("-------------------------------------------------------------");
            civilRegistrationMenu2();
        }
    }

    public void delete()
    {
        System.out.println("\t***** delete people information *****");
        System.out.print(" Enter the national id : ");
        int nationalId  = input.nextInt();

        boolean found = CivilRegistrationManager.getCivilRegistrationManager().delete(nationalId);
        if(found)
        {
            System.out.println(" delete successfully !");
            System.out.println("-------------------------------------------------------------");
            civilRegistrationMenu2();
        }
        else
        {
            System.out.println(" national id  not found !!");
            System.out.println("-------------------------------------------------------------");
            civilRegistrationMenu2();
        }
    }

    public void informationRetrieval()
    {
        CivilRegistrationManager.getCivilRegistrationManager().informationRetrieval();
        System.out.println(" Data retrieved. You can see the list: ");
        for (int i = 0; i < FinalProject.people.size(); i++)
        {
            System.out.println(" national id : " + FinalProject.people.get(i).getNationalId()
                    + "   name : " + FinalProject.people.get(i).getName() + "  "
            + FinalProject.people.get(i).getLastName() + "   gender: " + FinalProject.people.get(i)
                    .getGender() + "   age: " + FinalProject.people.get(i).getAge() +
                    "   wallet : " + FinalProject.people.get(i).getWallet());
            System.out.println("--------------------------------------------------------");
        }
    }


}
