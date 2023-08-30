
public class stringdemo {

	public static void main(String[] args) {
		
		String s1 = "Hello";                  // Created in stringpool
		String s2 = new String("Hello");     // Created in Heap memory area
		String s3 = "Hello";                // Created in stringpool
		
		System.out.println(s1);
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);

		// Comparing string values
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		
		s1 = s1 + "World";
		System.out.println(s1);
		System.out.println(s1 == s3);
		
		System.out.println(s1.length());
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		
		System.out.println(s1.indexOf('o'));
		System.out.println(s1.lastIndexOf('o'));
		System.out.println(s1.charAt(5));
		
		System.out.println(s1.substring(3));
		System.out.println(s1.substring(3, 7));
		System.out.println(s1.replace('o', 'e'));
		System.out.println(s1);
		
		String week = "sun-mon-tue-wed-thur-fri-sat";
		String[] days = week.split("-");
		for (String day : days) {
			System.out.println(day);
		}
		
		String num1 = "10";
		String num2 = "20";
		System.out.println(num1 + num2);
		System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
	

	}

}
