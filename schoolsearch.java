import java.io.*;
import java.util.*;

public class schoolsearch {
  public static ArrayList<Student> studentList = new ArrayList<Student>();
  
	public static void main (String args[]) {
	  
		Scanner scan = new Scanner(System.in);
		readFileByLine("src/students.txt");

		String input = "";
    System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.print("Type an instruction: ");
		System.out.println("\n");
		System.out.print("S[tudent]: <lastname> [B[us]]");
    System.out.println("\n");
		System.out.print("T[eacher]: <lastname>");
		System.out.println("\n");
		System.out.print("B[us]: <number>");
		System.out.println("\n");   
		System.out.print("G[rade]: <number> [H[igh]] [L[ow]]");
		System.out.println("\n");
		System.out.print("A[verage]: <number>");
		System.out.println("\n");
		System.out.print("I[nfo]");
		System.out.println("\n");
		System.out.println("Q[uit]");

		//read user input and call associated function
		while (true){
	        System.out.println("\n");

	        input = scan.nextLine();
	        String[] inputArr = input.split(" ");

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
		        case "I":
		       	case "Info":
		        	infoCall(inputArr);
		            break;
		       	case "Q":
		       	case "Quit":
		       	  System.out.println("Quitting...");
		       	  scan.close();
		      		System.exit(0);
		      		   break;
		        default:
		            System.out.println("Invalid selection");
		            break;
	        }
		}

	}

	//initialize each line in file to Student object
	public static void readFileByLine(String fileName) {		
  	try {
  			File file = new File(fileName);
   			Scanner scanner = new Scanner(file);
   		
   			for (int k = 0; k < 60; k++) {
    			String line = scanner.next();
    			String [] temp = line.split(",");
          studentList.add(new Student(temp[0], temp[1], (Integer.parseInt(temp[2])), (Integer.parseInt(temp[3])), (Integer.parseInt(temp[4])),
              (Double.parseDouble(temp[5])), temp[6], temp[7]));
   			}
  			 scanner.close();
 	 	} 
 	 	catch (FileNotFoundException e) {
   			e.printStackTrace();
  		}
 	}

	// Traceability: implements requirements R4, R5
  // Given students last name: 
  //    if bus not given, for each entry found print last name, first name, grade, classroom, teacher last & first name
  //    if bus route given, for each entry found print last name, first name, bus route
 	//    if 2 students have the same last name, find info for all
 	public static void studentCall(String [] inputArr){
 		ArrayList<Student> printList = new ArrayList<Student>();

 		for (int i = 0; i < 60; i++) {
 			if (inputArr[1].equals(studentList.get(i).stLastName)) {
 			  printList.add(studentList.get(i));
 			}
 		}
 		
 		//printing rules
 		if(inputArr.length > 2) {
   		if (inputArr[2].equals("B") || inputArr[2].equals("Bus")) {
   		  for (Student stu : printList) {
   		    System.out.println(stu.stLastName + "," + stu.stFirstName + "," + stu.bus);
   		  }
   		}
 		} else {
      for (Student stu : printList) {
        System.out.println(stu.stLastName + "," + stu.stFirstName + "," + stu.grade  + 
         "," + stu.classroom  + "," + stu.tLastName  + "," + stu.tFirstName);
       }
 		}
 		
 		if (printList.size() < 1) { 
 		  System.out.println("No students found.");
 		}
 	}

  // Traceability: implements requirements R6
 	// given teacher: find list of students in that class
  // search for teacher with given last name 
  // for each entry found, print last and first name of student
 	public static void teacherCall(String [] inputArr){
 	 ArrayList<Student> printList = new ArrayList<Student>();

 	 for (int i = 0; i < 60; i++) {
     if (inputArr[1].equals(studentList.get(i).tLastName)) {
       printList.add(studentList.get(i));
     }
   }
   
   for (Student stu : printList) {
     System.out.println(stu.stLastName + "," + stu.stFirstName); 
   }
   
   if (printList.size() < 1) { 
     System.out.println("No students found.");
   }
	}

  // Traceability: implements requirements R8
	// given bus route: find all students who take it
 	// for each entry, print student first and last name, grade, classroom 
 	public static void busCall(String [] inputArr){
 	 ArrayList<Student> printList = new ArrayList<Student>();

   for (int i = 0; i < 60; i++) {
     if (inputArr[1].equals(Integer.toString(studentList.get(i).bus))) {
       printList.add(studentList.get(i));
     }
   }
   
   for (Student stu : printList) {
     System.out.println(stu.stLastName + "," + stu.stFirstName + "," + stu.grade + "," + stu.classroom); 
   }
   
   if (printList.size() < 1) { 
     System.out.println("No bus found.");
   }
 	}

 	public static void gradeCall(String [] inputArr){

 	}

 	public static void averageCall(String [] inputArr){

 	}

 	public static void infoCall(String [] inputArr){

 	}
}
