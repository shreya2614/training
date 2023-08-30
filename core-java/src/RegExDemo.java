
public class RegExDemo {

	public static void main(String[] args) {
		
		String name = "Shreya";
		String mobile = "8431348568";
		String email = "shreya@gmail.com";
		
		String nameRegex = "[A-Z]{1}[a-z]{3,}";
		String mobileRegex = "[6-9]{1}[0-9]{9}";
		String emailRegex = "^(.+)@(\\S+)$";
		
		System.out.println(name.matches(nameRegex)?"Valid name":"Invalid name");
		System.out.println(mobile.matches(mobileRegex)?"valid Mobile":"Invalid Mobile");
		System.out.println(email.matches(emailRegex)?"valid Email":"Invalid Email");
		
		

	}

}
