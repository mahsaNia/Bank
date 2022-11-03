import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class FileUpdate // برای ریختن آرایه ها در فایل
{
    public void bankAccountFile()
    {
        // فایل حساب های بانکی

        try(FileWriter file1 = new FileWriter("C:\\Users\\Niazi\\IdeaProjects\\bankAccount.text");
                          Formatter f1 = new Formatter(file1))
        {
            for (int i = 0; i < FinalProject.bankAccounts.size(); i++)
            {
                // person
                f1.format("%d %d %f %s %s %s ", FinalProject.bankAccounts.get(i).getPerson().getAge(),
                        FinalProject.bankAccounts.get(i).getPerson().getNationalId(),
                        FinalProject.bankAccounts.get(i).getPerson().getWallet(),
                        FinalProject.bankAccounts.get(i).getPerson().getName(),FinalProject.bankAccounts
                                .get(i).getPerson().getLastName(), FinalProject.bankAccounts.get(i)
                                .getPerson().getGender());

                // bank account
                f1.format(" %d %f  %d %d %d  %d %d %s\n",
                        FinalProject.bankAccounts.get(i).getAccountNumber(), FinalProject.bankAccounts.get(i)
                                .getBalance(), FinalProject.bankAccounts.get(i).getYear(), FinalProject
                                .bankAccounts.get(i).getMonth(), FinalProject.bankAccounts.get(i).getDay(),
                        FinalProject.bankAccounts.get(i).getNegativePoint(), FinalProject.bankAccounts.get(i)
                                .getId(), FinalProject.bankAccounts.get(i).getPassword());
            }
            f1.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void civilRegistrationFile()
    {
        // فایل ثبت احوال

        try(FileWriter file2 = new FileWriter("C:\\Users\\Niazi\\IdeaProjects\\people.text");
                Formatter f2 = new Formatter(file2))
        {
            for (int i = 0; i < FinalProject.people.size(); i++)
            {
                f2.format("%d  %d  %f  %s %s  %s\n",FinalProject.people.get(i).getNationalId(),FinalProject.people
                        .get(i).getAge(), FinalProject.people.get(i).getWallet(),FinalProject.people.get(i).getName(),
                        FinalProject.people.get(i).getLastName(), FinalProject.people.get(i).getGender());
            }
            f2.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void documentRegistrationFile()
    {
        // فایل ثبت اسناد
        try(FileWriter file3 = new FileWriter("C:\\Users\\Niazi\\IdeaProjects\\estate.text");
                Formatter f3 = new Formatter(file3))
        {
            for (int i = 0; i < FinalProject.estates.size(); i++)
            {
                f3.format("%d  %f  %d %s  %s\n", FinalProject.estates.get(i).getNationalId(), FinalProject.estates
                        .get(i).getValue(), FinalProject.estates.get(i).getDocumentRegistrationCode(),
                        FinalProject.estates.get(i).getEstateAddress(), FinalProject.estates.get(i).getPurchaseDate());
            }
            f3.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
