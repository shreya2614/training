import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public  class Employee implements Externalizable {
	private int empNo;
	private String ename;
	private double salary;
	
	
	public Employee() {
		
	}
	public Employee(int empNo,String ename,double salary) {
		this.empNo = empNo;
		this.ename = ename;
		this.salary = salary;
		
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", ename=" + ename + ", salary=" + salary + "]";
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(empNo);
		out.writeUTF(ename);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		empNo = in.readInt();
		ename = in.readUTF();
		
	}
	
	
	

}
