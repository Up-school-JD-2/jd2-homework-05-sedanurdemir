
class SystemNotWorkingException extends Exception {
    public SystemNotWorkingException(String errorMessage) {
        super(errorMessage);
    }
}

public class CreditCard {
	
	private double amount;
	private String cardNumber;
	private String expirationDate;
	private  String  securityCode;
	
	
	public CreditCard(double amount, String cardNumber, String expirationDate, String securityCode) {
		
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
	}





	public CreditCard() {
		// TODO Auto-generated constructor stub
	}





	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getSecurityCode() {
		return securityCode;
	}


	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}





	public void pay() throws SystemNotWorkingException{
		
			
		
		int randomNumber=(int)(Math.random()*100);
//		System.out.println(randomNumber);
		if(randomNumber>75) {
			throw new SystemNotWorkingException("sistemde bir sorun oluştu tekrar deneyin");
		}
		System.out.println("işlem başarılı");
	
}
}
