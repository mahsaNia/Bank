import java.util.*;
public class DocumentRegistrationPanel // پنل سامانه ثبت اسناد
{
    Scanner input = new Scanner(System.in);
    Menu menu = new Menu();

    public void documentMenu1()
    {
        System.out.println("\t*****Log in*****");
        System.out.println(" Enter your information :");
        System.out.print(" 1) ID : ");
        String id = input.next() ;
        System.out.print(" 2) Password : ");
        String password = input.next() ;

        DocumentRegistrationManager.getDocumentRegistrationManager().logIn(id, password);
        documentMenu2();
    }

    public void documentMenu2()
    {
        int choice = menu.civilAndDocumentRegistrationMenu();

        switch (choice)
        {
            case 1 : // register
            {
                register();
                documentMenu2();
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
                documentMenu2();
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
        System.out.println("\t***** Document Registration *****");
        System.out.println(" Enter the information :");
        System.out.print(" 1) national id : ");
        int nationalId = input.nextInt() ;
        System.out.print(" 2) estate address : ");
        String estateAddress = input.next() ;
        System.out.print(" 3) purchase date : ");
        String purchaseDate = input.next() ;
        System.out.print(" 4) value : ");
        double value = input.nextDouble();
        System.out.println();

        int code = DocumentRegistrationManager.getDocumentRegistrationManager().registry(nationalId, estateAddress,
                purchaseDate, value);
        System.out.println(" the document registration code is : " + code);

        System.out.println(" Choose one :\n 1) Add more    2) End");
        int num = input.nextInt() ;
        while (num == 1)
        {
            System.out.println("-------------------------------------------------------------");
            System.out.println(" Enter the information :");
            System.out.print(" 1) national id : ");
            int nationalId1 = input.nextInt() ;
            System.out.print(" 2) estate address : ");
            String estateAddress1 = input.next() ;
            System.out.print(" 3) purchase date : ");
            String purchaseDate1 = input.next() ;
            System.out.print(" 4) value : ");
            double value1 = input.nextDouble();
            System.out.println();

            int code1 = DocumentRegistrationManager.getDocumentRegistrationManager().registry(nationalId1,
                    estateAddress1, purchaseDate1, value1);
            System.out.println(" the document registration code is : " + code1);

            System.out.println(" Choose one :\n 1) Add more    2) End");
            num = input.nextInt() ;
        }
    }

    public void editInfo()
    {
        System.out.println("\t*****Edit Info*****");
        System.out.println(" Enter the information :");
        System.out.print(" Enter the document registration code : ");
        int code = input.nextInt();
        System.out.print( " 1) new national id : ");
        int newNationalId = input.nextInt();
        System.out.print(" 2) new estate address : ");
        String newEstateAddress = input.next() ;
        System.out.print(" 3) new purchase date : ");
        String newPurchaseDate = input.next() ;
        System.out.print(" 4) new value : ");
        double newValue = input.nextDouble();
        System.out.println();




        boolean found = DocumentRegistrationManager.getDocumentRegistrationManager().editInfo(newNationalId,
                newEstateAddress, newPurchaseDate, newValue, code);

        if(found)
        {
            System.out.println(" Edit successfully !");
            System.out.println("-------------------------------------------------------------");
            documentMenu2();
        }
        else
        {
            System.out.println(" document registration code not found !!");
            System.out.println("-------------------------------------------------------------");
            documentMenu2();
        }
    }

    public void delete()
    {
        System.out.println("\t***** delete document information *****");
        System.out.print(" Enter the document registration code : ");
        int code  = input.nextInt();

        boolean found = DocumentRegistrationManager.getDocumentRegistrationManager().delete(code);
        if(found)
        {
            System.out.println(" sale successfully !");
            System.out.println(" The money was transferred to the wallet." +
                    " If you want to go to the bank and deposit it in your account.");
            System.out.println("-------------------------------------------------------------");
            documentMenu2();
        }
        else
        {
            System.out.println(" document registration code not found  !!");
            System.out.println("-------------------------------------------------------------");
            documentMenu2();
        }
    }

    public void informationRetrieval()
    {
       DocumentRegistrationManager.getDocumentRegistrationManager().assetRetrieval();
        System.out.println(" Data retrieved. You can see the list: ");
        for (int i = 0; i < FinalProject.estates.size(); i++)
        {
            System.out.println(" national ID : " + FinalProject.estates.get(i).getNationalId()
            + "   Document Registration Code : " + FinalProject.estates.get(i).getDocumentRegistrationCode()
            + "   address : " + FinalProject.estates.get(i).getEstateAddress()
            + "   value : " + FinalProject.estates.get(i).getValue());
            System.out.println("-------------------------------------------------------------");
        }
    }

}
