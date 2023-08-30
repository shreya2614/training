
public class Person {
	private String name;
	private int age;
	
	public void setState(String n, int a) {
		name = n;
		age = a;
	}
    public void print() {
    	System.out.println("+Name: " + name + "\tAge: " + age);
    }
}
