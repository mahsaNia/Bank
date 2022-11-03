public class Estate // ملک
{
   private int documentRegistrationCode; // کد ثبت اسناد
   public static int code = 123 ;
   private int nationalId; // کد ملی صاحب
   private String estateAddress; // آدرس ملک
   private String purchaseDate; // تاریخ خرید
   private double value; // ارزش

   public Estate(int documentRegistrationCode, int nationalId, String estateAddress,
                 String purchaseDate, double value)
   {
      code++ ;
      this.documentRegistrationCode = documentRegistrationCode;
      this.nationalId = nationalId;
      this.estateAddress = estateAddress;
      this.purchaseDate = purchaseDate;
      this.value = value;
   }

   public void setDocumentRegistrationCode(int documentRegistrationCode) {
      this.documentRegistrationCode = documentRegistrationCode;
   }

   public void setEstateAddress(String estateAddress) {
      this.estateAddress = estateAddress;
   }

   public void setPurchaseDate(String purchaseDate) {
      this.purchaseDate = purchaseDate;
   }

   public void setValue(double value) {
      this.value = value;
   }

   public int getNationalId() {
      return nationalId;
   }

   public int getDocumentRegistrationCode() {
      return documentRegistrationCode;
   }

   public void setNationalId(int nationalId) {
      this.nationalId = nationalId;
   }

   public String getEstateAddress() {
      return estateAddress;
   }

   public String getPurchaseDate() {
      return purchaseDate;
   }

   public double getValue() {
      return value;
   }


}
