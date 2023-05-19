
import java.util.Scanner;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidCardNumberException extends Exception {
    public InvalidCardNumberException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidExpirationDateException extends Exception {
    public InvalidExpirationDateException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidSecurityCodeException extends Exception {
    public InvalidSecurityCodeException(String errorMessage) {
        super(errorMessage);
    }
}



public class Main {

	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		CreditCard creditCard = new CreditCard();
        
		
		try {
			System.out.println("ödeme tutarını giriniz: ");
			String amountString=sc.nextLine();
			double amount;
			
			try {
				amount=Double.parseDouble(amountString);
			}catch (NumberFormatException e) {
				System.out.println("Girdiğiniz değer rakamlardan oluşmalıdır");
			return;
			}
			
			if(amount <=0 || amount%1 !=0 ) {
				throw new InvalidAmountException("Geçersiz tutar");
			}
//			sc.nextLine();
			System.out.println("kart numarasını giriniz: ");
			String cardNumber=sc.nextLine();
			
			if (cardNumber.length()!=16 || !cardNumber.matches("[0-9]+")) {
				throw new InvalidCardNumberException("geçersiz kart numarası");
			}
			
			System.out.println("son kullanma tarihini girin (MM/YYYY): ");
            String expirationDate = sc.nextLine();

            if (!expirationDate.matches("^(0[1-9]|1[0-2])/20[2-9][0-9]$")) {
                throw new InvalidExpirationDateException("geçersiz son kullanma tarihi!");
            }

            int month = Integer.parseInt(expirationDate.split("/")[0]);
            int year = Integer.parseInt(expirationDate.split("/")[1]);

            if (year < 2023 || month < 1 || month > 12) {
                throw new InvalidExpirationDateException("geçersiz son kullanma tarihi!");
            }

            System.out.println("Güvenlik kodunu girin: ");
            String securityCode = sc.nextLine();

            if (securityCode.length() != 3 || !securityCode.matches("[0-9]+")) {
                throw new InvalidSecurityCodeException("geçersiz güvenlik kodu!");
            }

           creditCard.setAmount(amount);
           creditCard.setCardNumber(cardNumber);
           creditCard.setExpirationDate(expirationDate);
           creditCard.setSecurityCode(securityCode);
           creditCard.pay();
          

        } catch (InvalidAmountException | InvalidCardNumberException |
                InvalidExpirationDateException | InvalidSecurityCodeException |NumberFormatException e) {
        	
        	
            System.out.println(e.getMessage());
          
		}catch (SystemNotWorkingException e) {
			System.out.println(e.getMessage() +" işlem tekrar denecek");
		
			try {
				System.out.println("ödeme tutarını giriniz: ");
				double amount=sc.nextDouble();
				
				if(amount <=0 || amount%1 !=0 ) {
					throw new InvalidAmountException("Geçersiz tutar. Tekrar deneme başarısız");
				}
				sc.nextLine();
				System.out.println("kart numarasını giriniz: ");
				String cardNumber=sc.nextLine();
				
				if (cardNumber.length()!=16 || !cardNumber.matches("[0-9]+")) {
					throw new InvalidCardNumberException("geçersiz kart numarası. Tekrar deneme başarısız");
				}
				
				System.out.println("son kullanma tarihini girin (MM/YYYY): ");
	            String expirationDate = sc.nextLine();

	            if (!expirationDate.matches("^(0[1-9]|1[0-2])/20[2-9][0-9]$")) {
	                throw new InvalidExpirationDateException("geçersiz son kullanma tarihi. Tekrar deneme başarısız");
	            }

	            int month = Integer.parseInt(expirationDate.split("/")[0]);
	            int year = Integer.parseInt(expirationDate.split("/")[1]);

	            if (year < 2023 || month < 1 || month > 12) {
	                throw new InvalidExpirationDateException("geçersiz son kullanma tarihi. Tekrar deneme başarısız");
	            }

	            System.out.println("Güvenlik kodunu girin: ");
	            String securityCode = sc.nextLine();

	            if (securityCode.length() != 3 || !securityCode.matches("[0-9]+")) {
	                throw new InvalidSecurityCodeException("geçersiz güvenlik kodu. Tekrar deneme başarısız. ");
	            }

	           creditCard.setAmount(amount);
	           creditCard.setCardNumber(cardNumber);
	           creditCard.setExpirationDate(expirationDate);
	           creditCard.setSecurityCode(securityCode);
	           creditCard.pay();
	          

//	        } catch (InvalidAmountException | InvalidCardNumberException |
//	                InvalidExpirationDateException | InvalidSecurityCodeException e2) {
//	        	
//	        	
//	            System.out.println(e2.getMessage());
//	          
			}catch (Exception e3) {
				System.out.println("tekrar deneme başarısız");
			}
		}
		
		
        }
		 
		
       
}