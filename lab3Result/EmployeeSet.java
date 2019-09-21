import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeSet {
	//create basic variables of collection
	private int manyitems;
	private Employee[] set;
	
	//no-argument constructor
	public EmployeeSet() {
		manyitems = 0;
		int initialCapacity = 10;
		set = new Employee[initialCapacity];
	}
	

	//copy constructor
	/*
	 * @precondition
	 * obj should not be null and should be an instance of employeeSet
	 */
	public EmployeeSet(Object obj) {
		if(obj != null && obj instanceof EmployeeSet) {
			EmployeeSet tempSet = (EmployeeSet) obj;
			this.manyitems = tempSet.manyitems;
			this.set = new Employee[tempSet.set.length];
			for (int i = 0; i < set.length; i++) {
				this.set[i] = tempSet.set[i];					
				}
			}
		else {
			System.out.println("please input the correct parameter");
		}
	}
	
	//get the size of EmployeeSet
	public int size() {
		manyitems = 0; 
		for (int i = 0; i < set.length; i++) {
			if(set[i] != null) {
				manyitems += 1;
			}
		}
		return manyitems;
	}
	
	//get the capacity of EmployeeSet
	public int capacity() {
		return set.length;
	}
	
	//add method
	/*
	 * @precondition
	 * the employee object a should not be null
	 */
	public void add(Employee a) {
		if( a != null) {
			if (this.size() >= this.capacity()) {
			this.ensureCapacity(2*this.capacity()); //ensureCapacity method defined below
			}
			set[this.size()] = a;
		}
	}
	
	//contains method
	public boolean contains(Employee a) {
		boolean result = false;
		if(a == null) {
			result = false;	
		}else {
			for (int i = 0; i < set.length; i++) {
				if(set[i] == a) {
					result = true;
					break;
				}else {
					result = false;
				}
			}
		}
		return result;
	}
	
	
	// remove method
	public boolean remove(int eno) {
		int i;
		for (i = 0; (i < this.size()) && (eno != this.set[i].getEmployeeNo()); i++);
		//the target was not found, so nothing is removed
		if( i == this.size() ) {
			return false;
		}else {//the target was found at set[i] and copy the last element onto set[i].
			set[i] = set[this.size()-1];
			set[this.size()-1] = null;// delete the last element
			return true;
		}
	}
			
	// emsureCapacity method
	/*@precondition
	 * minimumCapacity should be positive
	 */
	private void ensureCapacity(int minimumCapacity) {
		if(minimumCapacity > 0) {
			if(this.capacity() < minimumCapacity) {
				Employee[] newSet = new Employee[minimumCapacity];
				// for loop
				for (int i = 0; i < this.capacity(); i++) {
					newSet[i] = set[i];
				}
				set = newSet;
			}
		}else {
			System.out.println("minimumCapacity should be positive!");
		}
	}
	
	// 10 addOrdered method
	/*
	 * @precondition
	 * employee a should not be null, and
	 * the objects are already in ascending order of employee nos.
	 */
	public void addOrdered(Employee a) {
		if(a == null) {
			System.out.println("employee a should not be null");
		}else {//ascending order of employee nos
			for(int i = 0; i < this.size(); i++) {
				for(int j = 0; j < this.size()-1-i; j++) {
					if(this.set[j+1].getEmployeeNo() < this.set[j].getEmployeeNo()) {
						Employee temp = this.set[j+1];						
						this.set[j+1] = this.set[j];
						this.set[j] = temp;
					}
				}
			}
			// double space
			if(this.size() == this.capacity()) {
				this.ensureCapacity(2*this.capacity());
			}
			//for loop
			int index = this.size();
			for(int k=0; k < this.size(); k++) {
				if(this.set[k].getEmployeeNo() > a.getEmployeeNo()) {
					index = k;
					break;
				}
			}
			//insert employee a
			for(int n=this.size(); n > index; n--) {
				this.set[n] = this.set[n-1];
			}
			this.set[index] = a;
		}		
	}	
	
	//main method
	public static void main(String[] args) {
		//read information from data file and add to employeeset1
		String fname = "core_dataset.csv";
		int no = 0; //line index, first line
		String line = ""; // line = null;
		//test no-argument constructor, and create EmployeeSet named as 'set1'
		EmployeeSet set1 =new EmployeeSet();			
		try {
			FileReader fileReader = new FileReader(fname); //FileReader reads "fname" file
			BufferedReader br = new BufferedReader(fileReader);  //Always wrap fileReader in BufferedReader
			
			while ((line = br.readLine()) != null) {
				if(no > 0) {     //(no == 273, name = Jeremy Prater, without ","
					String lineReplace = line.replace("\"", "");
					String[] lineStr = lineReplace.split(",");
					Employee temp = new Employee();
					temp.setEmployeeName(lineStr[0] + lineStr[1]);
					temp.setEmployeeNo(Integer.parseInt(lineStr[2]));
					temp.setState(lineStr[3]);
					temp.setZipCode(Integer.parseInt(lineStr[4]));
					temp.setEmployeeAge(Integer.parseInt(lineStr[6]));
					temp.setAdvisors(null); //employee advisor information is empty
					set1.add(temp);
				}
					
				no++;	
		}
		br.close(); // Always close files
		}catch(FileNotFoundException ex) {
			System.out.println("Unable to found file '" + fname + "'");
		}catch(IOException ex) {
			System.out.println("Error reading file '" + fname + "'");
		}
		System.out.println("Finish reading file " + fname +"\n");  //finish reading file
		
		//test case1: read file and add to set1
		System.out.println("<test case1: read all employee information and add those employees to an employee set named as set1>");
		for (int i = 0; i < set1.size(); i++) {
			System.out.println(set1.set[i].getEmployeeName() + "\t" + set1.set[i].getEmployeeNo() + "\t" 
					+ set1.set[i].getState() + "\t" + set1.set[i].getZipCode() + "\t" + 
					set1.set[i].getEmployeeAge() + "\t" + set1.set[i].getAdvisors());
		}
		System.out.println("set1 contains " + set1.manyitems + " employees." + "\n");
		
		//test case2: copy set1 to set2
		System.out.println("<test case2: copy set1 to set2>");
		EmployeeSet set2 =new EmployeeSet(set1);
		System.out.println("set1.manyItems equals to set2.manyItems is " + (set1.manyitems == set2.manyitems) + "." + "\n");
		
		//test case3: size() and capacity() method
		System.out.println("<test case3: size() and capacity() method>");
		System.out.println("the size of set1 is " + set1.size() + ".");
		System.out.println("the capacity of set1 is " + set1.capacity() + "." + "\n");
		
		//test case4: add method
		System.out.println("<test case4: add method>");
		int[] advisora1 = {};
		Employee a1 = new Employee("a1",20000000,22,"NM",88001,advisora1);
		set1.add(a1);
		System.out.println("the total amount of set1 after adding employee a1 is " + set1.size() + ".");
		System.out.println("the name of the last employee in set1 is " + set1.set[set1.size()-1].getEmployeeName() + "." + "\n");
		
		//test case5: contains method
		System.out.println("<test case5: contains method>");
		int[] advisora2 = {};
		Employee a2 = new Employee("a2",800000000,22,"NM",88001,advisora2);
		System.out.println("set1 contains employee a1 is " + set1.contains(a1) + ".");
		System.out.println("set1 contains employee a2 is " + set1.contains(a2) + "\n");
		
		//test case6: remove method
		System.out.println("<test case6: remove method>");
		//remove two employees form set1
		System.out.println(" remove employee a1 is " + set1.remove(20000000) + ".");
		System.out.println(" remove employee a2 is " + set1.remove(800000000) + "." + "\n");
		
		//test case7: ensureCapacity method
		System.out.println("<test case7: ensureCapacity method");
		System.out.println("the current capacity of set1 is " + set1.capacity() + ".");
		set1.ensureCapacity(set1.capacity()+1);
		System.out.println("the new capacity of set1 whose minimumCapacity equals to current capacity plus 1) is " + set1.capacity() + "." + "\n");
		
		//test case8: addOdered method
		System.out.println("<test case8: addOdered method>");
		System.out.println("the total amount of set1 before addOdered method is " + set1.size() + ".");
		//create a new employee a3
		int[] advisora3 = {};
		Employee a3 = new Employee("a3",2000000000,22,"NM",88001,advisora3);
		set1.addOrdered(a1);
		set1.addOrdered(a2);
		set1.addOrdered(a3);
		System.out.println("the total amount of set1 after addOdered method (3 times) is " + set1.size() + ".");
		//printout all of employee numbers and employee names
		System.out.println("employeeNo" + "\t" + "employeeName");
		for (int i = 0; i < set1.size(); i++) {
			System.out.println(set1.set[i].getEmployeeNo() + "\t" +set1.set[i].getEmployeeName());		
		}
	}
}
