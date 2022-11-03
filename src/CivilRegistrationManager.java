import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CivilRegistrationManager // سامانه ثبت احوال
{

    private static CivilRegistrationManager civilRegistrationManager = new CivilRegistrationManager();
    public static CivilRegistrationManager getCivilRegistrationManager()
    {
        return civilRegistrationManager;
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

    // ثبت نام
    public void register(String name, String lastName, int age, String gender, int nationalId, double wallet)
    {
        Person person = new Person(name, lastName, age, gender, nationalId, wallet);
        FinalProject.people.add(person);
    }

    // ویرایش
    public boolean editInfo(int nationalId ,String newName, String newLastName, int newAge, String newGender,
                            double newWallet)
    {
        boolean found = false ;
        for(int i = 0; i < FinalProject.people.size(); i++)
        {
            if(FinalProject.people.get(i).getNationalId() == nationalId)
            {
                FinalProject.people.get(i).setName(newName);
                FinalProject.people.get(i).setLastName(newLastName); ;
                FinalProject.people.get(i).setAge(newAge);
                FinalProject.people.get(i).setGender(newGender);
                FinalProject.people.get(i).setWallet(newWallet);
                found = true ;
                break;
            }
        }
        return found ;
    }

    // delete
    public boolean delete(int nationalId)
    {
        boolean found = false ;
        for(int i = 0; i < FinalProject.people.size(); i++)
        {
            if(FinalProject.people.get(i).getNationalId() == nationalId)
            {
                FinalProject.people.remove(FinalProject.people.get(i));
                found = true ;
                break;
            }
        }
        return found ;
    }

    // بازیابی اطلاعات ثبت احوال
    public void informationRetrieval()
    {
        File file2 = new File("C:\\Users\\Niazi\\IdeaProjects\\people.text");
        try(Scanner s2 = new Scanner(file2))
        {
            while (s2.hasNext())
            {
                int nationalId = s2.nextInt();
                int age = s2.nextInt();
                double wallet = s2.nextDouble();
                String name = s2.next();
                String lastName = s2.next();
                String gender = s2.next();

                FinalProject.people.add(new Person(name, lastName, age, gender, nationalId, wallet));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
