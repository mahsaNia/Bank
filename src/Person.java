public class Person
{
    private String name;
    private String lastName;
    private int age;
    private String gender;
    private int nationalId; // کد ملی
    private double wallet; // کیف پول

    public Person(String name, String lastName, int age, String gender, int nationalId, double wallet)
    {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.nationalId = nationalId;
        this.wallet = wallet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public int getNationalId() {
        return nationalId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getWallet() {
        return wallet;
    }
}
