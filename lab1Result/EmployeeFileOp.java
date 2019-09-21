/**
 * 
 * @author yangjian
 *
 */


import java.io.*;

//create mypair class
class mypair{
	String employeeName;
	String employeeNumber;
	String State,Zip,DOB,Sex;
	String MaritalDesc,CitizenDesc,Hispanic$Latino;
	String RaceDesc,DateOfHire,DateOfTermination,ReasonForTerm;
	String employmentStatus,Department,Position,PayRate,managerName;
	String employeeSource,performanceScore;
	String Age;
}

//create EnployeeFileOp class
public class EmployeeFileOp {
	private static mypair[] numberpairs = null;  //???
	
	//read function*****
	public static void read(String fname) {
//		int no = 0; //line index, first line
		String line = ""; // line = null;
		
		try {
			FileReader fileReader = new FileReader(fname); //FileReader reads "fname" file
			BufferedReader br = new BufferedReader(fileReader);  //Always wrap fileReader in BufferedReader
			
			LineNumberReader lnr = new LineNumberReader(new FileReader(fname)); // get total row number
			lnr.skip(Long.MAX_VALUE);
			int lineNo = lnr.getLineNumber();
//			System.out.println("total lines: " + lineNo); //print the number of total lines
			numberpairs = new mypair[lineNo-1]; // the last line is empty
			
//			while ((line = br.readLine()) != null) {
			for (int no = 0; no < numberpairs.length; no++) {
				line = br.readLine();
				if(no == 0 || no == 273) {     //(no == 273, name = Jeremy Prater, without ","
					String[] line1Str = line.split(",");
					
					numberpairs[no] = new mypair();
					numberpairs[no].employeeName = line1Str[0];
					numberpairs[no].employeeNumber = line1Str[1];
					numberpairs[no].State = line1Str[2];
					numberpairs[no].Zip = line1Str[3];
					numberpairs[no].DOB = line1Str[4];
					numberpairs[no].Age = line1Str[5];   //Integer.parseInt(line1Str[5]);
					numberpairs[no].Sex = line1Str[6];
					numberpairs[no].MaritalDesc = line1Str[7];
					numberpairs[no].CitizenDesc = line1Str[8];
					numberpairs[no].Hispanic$Latino = line1Str[9];
					numberpairs[no].RaceDesc = line1Str[10];
					numberpairs[no].DateOfHire = line1Str[11];
					numberpairs[no].DateOfTermination = line1Str[12];
					numberpairs[no].ReasonForTerm = line1Str[13];
					numberpairs[no].employmentStatus = line1Str[14];
					numberpairs[no].Department = line1Str[15];
					numberpairs[no].Position = line1Str[16];
					numberpairs[no].PayRate = line1Str[17];
					numberpairs[no].managerName = line1Str[18];
					numberpairs[no].employeeSource = line1Str[19];
					numberpairs[no].performanceScore = line1Str[20];
				}else {			
					String lineReplace = line.replace("\"", "");
					String[] lineStr = lineReplace.split(",");
	//				System.out.println(lineStr[0] + "\t" + lineStr);
					numberpairs[no] = new mypair();
					numberpairs[no].employeeName = lineStr[0] + lineStr[1];
					numberpairs[no].employeeNumber = lineStr[2];
					numberpairs[no].State = lineStr[3];
					numberpairs[no].Zip = lineStr[4];
					numberpairs[no].DOB = lineStr[5];
					numberpairs[no].Age = lineStr[6];     //Integer.parseInt(lineStr[6]);
					numberpairs[no].Sex = lineStr[7];
					numberpairs[no].MaritalDesc = lineStr[8];
					numberpairs[no].CitizenDesc = lineStr[9];
					numberpairs[no].Hispanic$Latino = lineStr[10];
					numberpairs[no].RaceDesc = lineStr[11];
					numberpairs[no].DateOfHire = lineStr[12];
					numberpairs[no].DateOfTermination = lineStr[13];
					numberpairs[no].ReasonForTerm = lineStr[14];
					numberpairs[no].employmentStatus = lineStr[15];
					numberpairs[no].Department = lineStr[16];
					numberpairs[no].Position = lineStr[17];
					numberpairs[no].PayRate = lineStr[18];
					numberpairs[no].managerName = lineStr[19];
					numberpairs[no].employeeSource = lineStr[20];
					numberpairs[no].performanceScore = lineStr[21];
			}
//			no++;	
		}

		br.close(); // Always close files
		}catch(FileNotFoundException ex) {
			System.out.println("Unable to found file '" + fname + "'");
		}catch(IOException ex) {
			System.out.println("Error reading file '" + fname + "'");
		}
		System.out.println("Finish reading file " + fname +"\n");  //finish reading file
		
		//extract useful information of each employee
		for (int i = 0; i < numberpairs.length; i++) {
			System.out.println(numberpairs[i].employeeName + "\t" + numberpairs[i].employeeNumber + "\t" 
					+ numberpairs[i].State + "\t" + numberpairs[i].Zip + "\t" + 
					numberpairs[i].Age + "\t" + numberpairs[i].Sex);
		}			
	}
	
	
	//write function******
	public static void write(String fname) {
		try {
			File file = new File(fname);
			
			FileWriter fw =new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(numberpairs[0].employeeName + "," + numberpairs[0].employeeNumber + "," 
					+ numberpairs[0].State + "," + numberpairs[0].Zip + "," + 
					numberpairs[0].Age + "," + numberpairs[0].Sex + "\n");
			for (int i = 1; i < numberpairs.length-150; i++) {
				int intAge = Integer.parseInt(numberpairs[i].Age);
				if(intAge <= 30) {
					bw.write(numberpairs[i].employeeName + "," + numberpairs[i].employeeNumber + "," 
							+ numberpairs[i].State + "," + numberpairs[i].Zip + "," + 
							numberpairs[i].Age + "," + numberpairs[i].Sex + "\n");
				}
			}
			bw.close();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n" + "Finish writing pairs to file " + fname);
	}
	
	
	//main function******
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numberpairs = null;
		read("core_dataset.csv");
		write("young_employee.csv");

	}

}
