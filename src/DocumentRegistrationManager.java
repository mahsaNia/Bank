import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DocumentRegistrationManager // سامانه ثبت اسناد
{
    private static DocumentRegistrationManager documentRegistrationManager = new DocumentRegistrationManager();
    public static DocumentRegistrationManager getDocumentRegistrationManager()
    {
        return documentRegistrationManager;
    }

    // admin log in
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

    // ثبت اسناد
    public int registry(int nationalId, String estateAddress, String purchaseDate, double value)
    {
        int code = Estate.code;
        Estate estate = new Estate(code, nationalId, estateAddress, purchaseDate, value);
        FinalProject.estates.add(estate);
        return code;
    }

    // ویرایش
    public boolean editInfo(int newNationalId, String newEstateAddress, String newPurchaseDate,
                            double newValue, int code)
    {
        boolean found = false ;
        for(int i = 0; i < FinalProject.estates.size(); i++)
        {
            if(FinalProject.estates.get(i).getDocumentRegistrationCode() == code)
            {
                FinalProject.estates.get(i).setNationalId(newNationalId);
                FinalProject.estates.get(i).setEstateAddress(newEstateAddress);
                FinalProject.estates.get(i).setPurchaseDate(newPurchaseDate);
                FinalProject.estates.get(i).setValue(newValue);
                found = true ;
                break;
            }
        }
        return found ;
    }

    // delete
    public boolean delete(int code)
    {
        boolean found = false ;
        for(int i = 0; i < FinalProject.estates.size(); i++)
        {
            if(FinalProject.estates.get(i).getDocumentRegistrationCode() == code)
            {
                int nationalId = FinalProject.estates.get(i).getNationalId();
                for (int j = 0; j < FinalProject.bankAccounts.size(); j++)
                {
                    if (FinalProject.bankAccounts.get(j).getPerson().getNationalId() == nationalId)
                    {
                        FinalProject.bankAccounts.get(j).getPerson().setWallet(FinalProject.bankAccounts
                                .get(j).getPerson().getWallet() + FinalProject.estates.get(i).getValue());
                        break;
                    }
                }
                FinalProject.estates.remove(FinalProject.estates.get(i));
                found = true ;
                break;
            }
        }
        return found ;
    }

    // بازیابی دارایی
    public void assetRetrieval()
    {
        File file3 = new File("C:\\Users\\Niazi\\IdeaProjects\\estate.text");
        try(Scanner s3 = new Scanner(file3))
        {
            while (s3.hasNext())
            {
                int nationalId = s3.nextInt();
                double value = s3.nextDouble();
                int code = s3.nextInt();
                String address = s3.next();
                String date = s3.next();

                FinalProject.estates.add(new Estate(code, nationalId, address, date, value));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
