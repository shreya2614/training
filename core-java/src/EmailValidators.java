
public class EmailValidators {

	public static void main(String[] args) {
		String email="shre@gmail.com";
		int iat = email.indexOf('@');
		int idot = email.indexOf('.');
		
		if(iat == email.lastIndexOf('@')&& idot == email.lastIndexOf('.') &&
				iat >= 4 && (idot - iat) >=3 && (email.length() - idot) >=2)
			System.out.println("valid Email");
		else
			System.out.println("invalid Email");
	



	}

}
