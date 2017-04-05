import java.io.*;
import java.util.*;
import java.lang.*;

public class schoolsearch {

	public static void main (String args[]) {
        System.out.println("~~~~~~~~~~~~~~~~~~~");

		Scanner scanner = new Scanner(System.in);
		readFileByLine("students.txt");

		String input = "";
		
		System.out.print("Type an instruction: ");
		System.out.println("\n");
		System.out.print("S[tudent]: <lastname> <bus (optional)>");
    	System.out.println("\n");
		System.out.print("T[eacher]: <lastname>");
		System.out.println("\n");
		System.out.print("B[us]: <number>");
		System.out.println("\n");   
		System.out.print("G[rade]: <number>");
		System.out.println("\n");
		System.out.print("A[verage]: <number>");
		System.out.println("\n");
		System.out.print("I[nfo]");
		System.out.println("\n");
		System.out.println("Q[uit]");

		//read user input and call associated function
		while (!input.equals("Q") || !input.equals("Quit")){
	        input = scanner.nextLine();
	        String[] inputArr = input.split(" ");

	        for (int i = 0; i < inputArr.length; i++) {
	 			System.out.print("input array: " + inputArr[i]);
	 			System.out.println();
    		}

	        switch (inputArr[0]) {
		        case "S:":
		       	case "Student:":
					studentCall(inputArr);
			            break;
		        case "T:":
		       	case "Teacher:":
		        	teacherCall(inputArr);
		            break;
		        case "B:":
		       	case "Bus:":
		         	busCall(inputArr);
		            break;
		        case "G:":
		       	case "Grade:":
		      		gradeCall(inputArr);
		            break;
		        case "A:":
		       	case "Average:":
		        	averageCall(inputArr);
		            break;
		        case "I:":
		       	case "Info:":
		        	infoCall(inputArr);
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

	//each student will be a row and each column is one piece of student info
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

 	//	Given students last name: find the students grade, classroom, teacher
 	//	Given students last name AND bus: find the students grade, classroom, teacher
 	//	if 2 students have the same last name, find info for all
 	public static void studentCall(String [] inputArr){
 		ArrayList<String> obj = new ArrayList<String>();

 		//search for student with given last name
 		for (int i = 0; i < 60; i++) {
 			if (inputArr[1].equals(studentInfo[i].lastname)) {

 			}
 		}

 		//if bus not given, for each entry found print last name, first name, grade, classroom, teacher last & first name

 		//if bus route given, for each entry found print last name, first name, bus route
 	}

 	//given teacher: find list of students in that class
 	public static void teacherCall(String [] inputArr){
 		//search for teacher with given last name 

 		//for each entry found, print last and first name of student
	}

	//given bus route: find all students who take it
 	public static void busCall(String [] inputArr){
 		//search for students who take this bus

 		//for each entry, print student first and last name, grade, classroom 
 	}

 	public static void gradeCall(String [] inputArr){

 	}

 	public static void averageCall(String [] inputArr){

 	}

 	public static void infoCall(String [] inputArr){

 	}
}