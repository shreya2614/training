import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizationDemo {

	public static void main(String[] args) throws Exception{
		Employee e = new Employee(101,"Polo",3000.0);
		System.out.println(e);
		
		ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream("emp.dat"));
		e.writeExternal(ostream);
		ostream.close();
		
		Employee e2 = new Employee();
		ObjectInputStream istream = new ObjectInputStream(new FileInputStream("emp.dat"));
		e.readExternal(istream);
		istream.close();
		
		
		System.out.println(e2);

	}

}
