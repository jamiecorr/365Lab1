import java.io.*;
import java.util.*;
import java.lang.*;

public class schoolsearch {

	public static void main (String args[]) {
        System.out.println("~~~~~~~~~~~~~~~~~~~");


		Scanner scanner = new Scanner(System.in);

		readFileByLine("students.txt");
		String input = "Z";
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.print("Type an instruction: ");
		System.out.println("\n");
		System.out.print("S: [lastname]");
    	System.out.println("\n");
		System.out.print("T: teacher ");
		System.out.println("\n");
		System.out.print("B: bus ");
		System.out.println("\n");   
		System.out.print("G: grade");
		System.out.println("\n");
		System.out.print("A: average ");
		System.out.println("\n");
		System.out.print("I: info");
		System.out.println("\n");
		System.out.println("Q: Quit ");

		while (!input.equals("Q") || !input.equals("Quit")){
			
	        input = scanner.nextLine();
	        String[] inputArr = input.split(" ");

	        for (int i = 0; i < inputArr.length; i++) {
	 			System.out.println("input array: " + inputArr[i]);
    		}


	        switch (inputArr[0]) {
		        case "S:":
		       	case "Student":
					studentCall(inputArr);
			            break;
		        case "T:":
		       	case "Teacher:":
		        	teacherCall();
		            break;
		        case "B:":
		       	case "Bus:":
		         	busCall();
		            break;
		        case "G:":
		       	case "Grade:":
		      		gradeCall();
		            break;
		        case "A:":
		       	case "Average:":
		        	averageCall();
		            break;
		        case "I:":
		       	case "Info:":
		        	infoCall();
		            break;
		       	case "Q:":
		       	case "Quit:":
		      		System.exit(0);
		      		   break;
		        default:
		            System.out.println("Invalid selection");
		            break;
	        }

		}
        
	}

	public static void readFileByLine(String fileName) {
		String [][] studentInfo = new String [60][8];
  		try {
  			File file = new File(fileName);
   			Scanner scanner = new Scanner(file);
   		
   			for (int k = 0; k < 60; k++) {
    			String line = scanner.next();
    			String [] temp = line.split(",");
    			for (int i = 0; i < temp.length; i++) {
    				studentInfo[k] = temp;
    			}

   			}
  			 scanner.close();
 	 	} 
 	 	catch (FileNotFoundException e) {
   			e.printStackTrace();
  		}
 	}

 	public static void studentCall(String [] inputArr){
 		String param = inputArr[1];

 		for (int i = 0; i < inputArr.length; i++) {
 			System.out.println(inputArr[i]);
    	}
 	}
 	



}