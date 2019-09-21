/*
 * For testing this file, users need to input the test data following inputDialog Pane;
 * The test data is shown as comments which are located at the start of the main method;
 */
//import java.util.HashSet;
//import java.util.Set;
//import javax.swing.JOptionPane;

public class Employee {
	// define private variables
	private String employeeName;
	private int employeeNo;
	private int employeeAge;
	private String state;
	private int zipCode; 
	private int[] advisors; 
	
	// set initial value of Employee
	public Employee() {
		employeeName = null;
		employeeNo = 0;
		employeeAge = 0;
		state = null;
		zipCode = 0; 
		advisors = null;
	}

	// constructor with parameters 
	public Employee(String employeeName, int employeeNo, int employeeAge, 
			String state, int zipCode, int[] advisors) {
		this.employeeName = new String(employeeName);
		this.employeeNo = employeeNo;
		this.employeeAge = employeeAge;
		this.state = new String(state);
		this.zipCode = zipCode;
//		this.advisors = advisors; using the same space and reference location
		this.advisors =new int [advisors.length];
		for (int i = 0; i < advisors.length; i++) {
			this.advisors[i] = advisors[i];
		}
	}
	
	// copy constructor
	// input Employee instance as parameter
	// return a new instance with the same variables
	public Employee(Object obj) {
		// the precondition
		if(obj != null && obj instanceof Employee) {
			Employee employee_temp = (Employee)obj; 
			// set method 
			this.employeeName = new String(employee_temp.getEmployeeName());
			this.employeeNo = employee_temp.getEmployeeNo();
			this.employeeAge = employee_temp.getEmployeeAge();
			this.state = new String(employee_temp.getState());
			this.zipCode = employee_temp.getZipCode();
			// copy obj advisors to this.advisors
			this.advisors = new int[employee_temp.advisors.length];
			for (int i = 0; i < employee_temp.advisors.length; i++) {
				this.advisors[i] = employee_temp.advisors[i];
			}
		}else {
			System.out.println("please input obj with appropriate parameters");
		}
	}
	
	
	//get and set methods for all of instance variables
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = new String(employeeName);
	}
	
	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = new String(state);
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int[] getAdvisors() {
		return advisors;
	}

	public void setAdvisors(int[] advisors) {
		this.advisors = advisors;
	}

	// toString method
	public String toString() {
		String tempStr = this.employeeName + "\t" + this.employeeNo + "\t" + this.employeeAge
				+ "\t" +this.state + "\t" + this.zipCode + "\t";
		// for loop to extract each element of advisors array
		for (int i = 0; i < advisors.length; i++) {
			tempStr += advisors[i]+",";
		}
		return tempStr;
	}

	// equals method
	public boolean equals(Object obj) {
		// define local variable result and default value
		boolean result = false;
		// the precondition
		if(obj != null && obj instanceof Employee) { 
			Employee tempObj = (Employee)obj;
			result = (this.employeeNo == tempObj.employeeNo);
		}
		return result;
	}
	
	// a static method getAllAdvisors
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		int[] e = null;
		int[] new_e = null;
		if(e1 !=null && e2 != null) {
			e = new int[e1.advisors.length + e2.advisors.length];
			//for loop to copy e1.advisors to e.advisors
			for (int i = 0; i < e1.advisors.length; i++) {
				e[i] = e1.advisors[i];
			}
			//for loop to copy e2.advisors to e.advisors
			int k;
			for (int j = 0; j < e2.advisors.length; j++) {
				//check duplicate element
				for( k = 0; (k < e1.advisors.length) && (e[k] != e2.advisors[j]);k++);
				if(k == e1.advisors.length) {
					e[e1.advisors.length+j] = e2.advisors[j];
				}
			}
			//find the amount of zero elements
			int cnt = 0;
			for (int i = 0; i < e.length; i++) {
				if(e[i] == 0) {
					cnt++;
				}
			}
			//create new int[e.length-cnt] and copy non-zero element to new_e
			new_e = new int [e.length - cnt];
			int n = 0;
			for (int i = 0; i < e.length; i++) {
				if(e[i] != 0) {
					new_e[n] = e[i];
					n++;
				}
			}
		
			//applying set method to merge two arrays and delete the duplicate elements
//		}	
//		int[] result = null; //local variable
//		//the precondition
//		if(e1 != null && e2 != null) {
//			// by using class set to save advisors of e1 & e2 without repeated value
//			Set<Integer> allAdvisors = new HashSet<Integer>();
//			for (int i = 0; i < e1.getAdvisors().length; i++) {
//				allAdvisors.add(e1.getAdvisors()[i]);
//			}
//			for (int i = 0; i < e2.getAdvisors().length; i++) {
//				allAdvisors.add(e2.getAdvisors()[i]);
//			}
//			// convert set<Integer> to int[]
//			result = new int[allAdvisors.size()];
//			int index = 0;
//			for(Integer i : allAdvisors) {
//				result[index++] = i;
//			}		
		}else {
			System.out.println("please input correct employees' parameters");
		}
//		return result;
		return new_e;
	}
	
	
	
	// main method
	public static void main(String[] args) {
		
		/* test data below could be input following inputDialog
		 * the amount of employees: 4
		 * EmployeeIndex	EmployeeName		EmployeeNo		Age		State		ZipCod		AdvisorsAmount		AdvisorsNo
		 * employee[1]		A					1				31	 	MA			101			2					11,12
		 * employee[2]		B  					2				32		MA			102			1					13
		 * employee[3]		C  					2				33		MB			103			2					11,14
		 * employee[4]		D					3				34		MB			104			3					12,13,15
		 */		
		
//		//input employees' basic information by keyboard
//		String population = JOptionPane.showInputDialog("please input the amount of employees:");
//		int[] counts = new int[Integer.parseInt(population)];
//		Employee[] employees = new Employee[counts.length];	
//		
//		//test constructors and set methods: input the basic information of each employee
//		for (int i = 0; i < employees.length; i++) {
//			employees[i] = new Employee();
//			String name = JOptionPane.showInputDialog("please input employee[" + (i+1)+ "] name:");
//			employees[i].setEmployeeName(name);
//			String No = JOptionPane.showInputDialog("please input employee[" + (i+1)+ "] No:");
//			employees[i].setEmployeeNo(Integer.parseInt(No));
//			String age = JOptionPane.showInputDialog("please input employee[" + (i+1)+ "] age:");
//			employees[i].setEmployeeAge(Integer.parseInt(age));
//			String state = JOptionPane.showInputDialog("please input employee[" + (i+1)+ "] state:");
//			employees[i].setState(state);
//			String zipCode = JOptionPane.showInputDialog("please input employee[" + (i+1)+ "] zipCode:");
//			employees[i].setZipCode(Integer.parseInt(zipCode));
//			
//			// input emloyee's advisors with int[]
//			String mStr =JOptionPane.showInputDialog("please input the amount of employee's advisors: ");
//			int m = Integer.parseInt(mStr);
//						
//			int[] number = null;
//			number = new int[m];
//			// for loop to create int[]
//			for (int j = 0; j < number.length; j++) {
//				String temp = JOptionPane.showInputDialog("please input employee advisor["+ (j+1) + "]");
//				number[j] = Integer.parseInt(temp);
//			}
//			// using set method to define employees' advisors
//			employees[i].setAdvisors(number);
//		}
//		
		
		/* test data below could be input following inputDialog
		 * the amount of employees: 4
		 * EmployeeIndex	EmployeeName		EmployeeNo		Age		State		ZipCod		AdvisorsAmount		AdvisorsNo
		 * employee[1]		A					1				31	 	MA			101			2					11,12
		 * employee[2]		B  					2				32		MA			102			1					13
		 * employee[3]		C  					2				33		MB			103			2					11,14
		 * employee[4]		D					3				34		MB			104			3					12,13,15
		 */	
		
		//input test data by constructor with parameters
		Employee[] employees = new Employee[4];
		int[] advisors1 = {11,12};
		int[] advisors2 = {11,12,13};
		int[] advisors3 = {11,13,14};
		int[] advisors4 = {12,13,14};
		
		employees[0] = new Employee("A",1,31,"MA",101,advisors1);
		employees[1] = new Employee("B",2,32,"MA",102,advisors2);
		employees[2] = new Employee("C",2,33,"MB",103,advisors3);
		employees[3] = new Employee("D",3,34,"MB",104,advisors4);
		
		
		
		// test get method
		System.out.println();
		System.out.println("<test get method>");
		System.out.println("get employee(A) name: " + employees[0].getEmployeeName());
		System.out.println("get employee(A) employeeNo: " + employees[0].getEmployeeNo());
		System.out.println("get employee(B) age: " + employees[1].getEmployeeAge());
		System.out.println("get employee(C) zipcode: " + employees[2].getZipCode());
		System.out.println("get employee(D) state: " + employees[3].getState());
		System.out.println("get employee(D) advisors: " + employees[3].getAdvisors());
		
		
		// test toString Method
		System.out.println();
		System.out.println("<test toString method>");
		System.out.println("the string of employee A is: " + employees[0].toString());
		System.out.println("the string of employee B is: " + employees[1].toString());
		System.out.println("the string of employee C is: " + employees[2].toString());
		System.out.println("the string of employee D is: " + employees[3].toString());

		
		// test equals method
		System.out.println();
		System.out.println("<test equals method>");
		System.out.println("the employeeNo of A equals that of B ?  " + employees[0].equals(employees[1]));
		System.out.println("the employeeNo of B equals that of C ?  " + employees[1].equals(employees[2]));
		System.out.println("the employeeNo of C equals that of D ?  " + employees[2].equals(employees[3]));
		
		// test getAllAdvisors method
		System.out.println();
		System.out.println("<test getAllAdvisors method>");
		System.out.print("get all the distinct advisors of A and B: ");
		for (int j = 0; j < Employee.getAllAdvisors(employees[0], employees[1]).length; j++) {
			System.out.print(Employee.getAllAdvisors(employees[0], employees[1])[j] + ",");
		}
		System.out.print("\n" + "get all the distinct advisors of C and D: ");
		for (int j = 0; j < Employee.getAllAdvisors(employees[2], employees[3]).length; j++) {
			System.out.print(Employee.getAllAdvisors(employees[2], employees[3])[j] + ",");
		}
		
		// test copy constructor
		System.out.println("\n");
		System.out.println("<test copy constructor>");
		Employee employee_copy = new Employee(employees[0]);
		System.out.println("employee[1] name is: " + employees[0].employeeName +"\t\t" +"employee_copy name is: " + employee_copy.employeeName);
		System.out.println("employee[1] No is: " + employees[0].employeeNo +"\t\t" +"employee_copy No is: " + employee_copy.employeeNo);
		System.out.println("employee[1] age is: " + employees[0].employeeAge +"\t\t" +"employee_copy age is: " + employee_copy.employeeAge);
		System.out.println("employee[1] zipCode is: " + employees[0].zipCode +"\t\t" +"employee_copy zipCode is: " + employee_copy.zipCode);
		System.out.println("......");
		
	}
	
}
