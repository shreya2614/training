
public class cmdLineDemo {

	public static void main(String[] args) {
		
		for (String a : args) {
			System.out.println(a);
			
		}
		int x = 5;
		Integer xo = x;  //Boxing
		int z = xo; //unboxing
		
		System.out.println(x + xo * z);
		// Java takes care of boxing and unboxing hence called Auto-boxing
		System.out.println(Integer.parseInt(null));

	}

}
