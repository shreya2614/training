import java.util.Scanner;

public class ConsoleDemo {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		String name = console.next();
		
		System.out.println("Your name: " + name);
		System.out.println("Enter age: ");
		int age = console.nextInt();
		System.out.println("age is: " + age);

	}

}
