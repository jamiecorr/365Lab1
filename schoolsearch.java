import java.io.*;
import java.util.*;

public class schoolsearch {
  public static ArrayList<Student> studentList = new ArrayList<Student>(); 
  public static ArrayList<Student> newStudentList = new ArrayList<Student>(); 
  public static ArrayList<Teacher> teacherList = new ArrayList<Teacher>(); 
  public static ArrayList<Integer> roomList = new ArrayList<Integer>(); 

  
  // Traceability: implements requirements R1, E1
	public static void main (String args[]) {
		readFileByLine("src/list.csv");
    readFileByLine("src/teachers.csv");
    readFileByLine("src/students.txt"); 

//		try {
		  promptInput();
//		} catch (Exception e) {
//      System.out.println("Invalid selection");
//      promptInput();
//		}
		  
		  
	}
	
  // Traceability: implements requirements R1, R2, R3, R12, E1
  // read user input and call associated function
	public static void promptInput() {
    Scanner scan = new Scanner(System.in);

    String input = "";
    String prompt = "Type an instruction: \n S[tudent]: <lastname> [B[us]] \n T[eacher]: <lastname> \n TeachersInGrade: <number> \n B[us]: "
        + "<number> \n G[rade]: <number> [H[igh]] [L[ow]] \n A[verage]: <number> \n I[nfo] \n E[nrollment] \n Q[uit]";
    System.out.println("\n" + prompt + "\n");
    while (true){
        System.out.print("\n");
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
            case "TeachersInGrade:":
              teachersInGrade(inputArr);
                break;
            case "A:":
            case "Average:":
              averageCall(inputArr);
                break;
            case "I":
            case "Info":
              infoCall();
                break;
            case "E":
            case "Enrollment":
              allStudentsByRoom();
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
	
	// Traceability: implements requirements R2, R13, E1
	//initialize each line in file to Student object
	public static void readFileByLine(String fileName) {		
  	try {
  			File file = new File(fileName);
   			Scanner scanner = new Scanner(file);
   		
   			if (fileName.equals("src/students.txt")) {
     			for (int k = 0; k < 60; k++) {
      			String line = scanner.next();
      			String [] temp = line.split(",");
            studentList.add(new Student(temp[0], temp[1], (Integer.parseInt(temp[2])), (Integer.parseInt(temp[3])), (Integer.parseInt(temp[4])),
                (Double.parseDouble(temp[5])), temp[6], temp[7]));
     			}
   			} else if (fileName.equals("src/list.csv")) {
   			 String line = scanner.nextLine();
         for (int k = 0; k < 60; k++) {
           line = scanner.nextLine();
           String [] temp = line.split(",");
           newStudentList.add(new Student(temp[0], temp[1], (Integer.parseInt(temp[2].trim())),(Integer.parseInt(temp[3].trim())),0,0,"",""));
         }
   			} else if (fileName.equals("src/teachers.csv")) {
          String line = scanner.nextLine();
   			 for (int k = 0; k < 12; k++) {
           line = scanner.nextLine();
           String [] temp = line.split(",");
           teacherList.add(new Teacher(temp[0], temp[1], (Integer.parseInt(temp[2].trim()))));
           if (!roomList.contains(teacherList.get(k).classroom)) {
             roomList.add(teacherList.get(k).classroom);
           }
          }
   			}
  			 scanner.close();
 	 	} 
 	 	catch (FileNotFoundException e) {
      System.out.println("File not found, exiting.");
 	 	    System.exit(0);
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

 	// Traceability: implements requirement R7, R9
 	// for each student that matches the grade level given, print name
 	// if H keyword is given, find student with highest GPA in given grade level
 	// if L keyword is given, find student with lowest GPA in given grade level
 	public static void gradeCall(String [] inputArr){
    float highestGPA = 0;
    float lowestGPA = 10;
    int studentNumberHigh = 0;
    int studentNumberLow = 0;

    if (inputArr.length == 2) {
       for (int i = 0; i < 60; i++) {
          if (inputArr[1].equals(Integer.toString(studentList.get(i).grade))) {
             System.out.println(studentList.get(i).stFirstName + "," + studentList.get(i).stLastName);
          }
       }
    }
    else if (inputArr[2].equals("H") || inputArr[2].equals("High")) {
       for (int i = 0; i < 60; i++) {
          if (inputArr[1].equals(Integer.toString(studentList.get(i).grade))) {
             if (studentList.get(i).GPA > highestGPA) {
                highestGPA = (float) studentList.get(i).GPA;
                studentNumberHigh = i;
             }
          }
       }
       System.out.println(studentList.get(studentNumberHigh).stFirstName + "," + studentList.get(studentNumberHigh).stLastName  + "," + studentList.get(studentNumberHigh).GPA  + "," + studentList.get(studentNumberHigh).tFirstName  + "," + studentList.get(studentNumberHigh).tLastName  + "," + Integer.toString(studentList.get(studentNumberHigh).bus));
    }
    else if (inputArr[2].equals("L") || inputArr[2].equals("Low")) {
       for (int i = 0; i < 60; i++) {
          if (inputArr[1].equals(Integer.toString(studentList.get(i).grade))) {
             if (studentList.get(i).GPA < lowestGPA) {
                lowestGPA = (float) studentList.get(i).GPA;
                studentNumberLow = i;
             }
          }
       }
       System.out.println(studentList.get(studentNumberLow).stFirstName + "," + studentList.get(studentNumberLow).stLastName  + "," + studentList.get(studentNumberLow).GPA  + "," + studentList.get(studentNumberLow).tFirstName  + "," + studentList.get(studentNumberLow).tLastName  + "," + Integer.toString(studentList.get(studentNumberLow).bus));
    }
 }

 	// Traceability: implements requirements R10
 	// finds the average GPA of all students in given grade level
 	public static void averageCall(String [] inputArr){
       float averageTotal = 0;
       int numStudents = 0;
       float averageGPA = 0;
      
       for (int i = 0; i < 60; i++) {
          if (inputArr[1].equals(Integer.toString(studentList.get(i).grade))) {
             numStudents++;
             averageTotal += studentList.get(i).GPA;
          }
       }
       averageGPA = (float)averageTotal/numStudents;
       System.out.println(inputArr[1] + " " + Double.toString(averageGPA).substring(0, 4));
 	}

 	// Traceability: implements requirements R11
 	// for each grade, print number of students in that grade
 	public static void infoCall(){
    int total0, total1, total2, total3, total4, total5, total6;
    total0 = total1 = total2 = total3 = total4 = total5 = total6 = 0;

       for (int i = 0; i < 60; i++) {
          if ((studentList.get(i).grade) == 0) {
              total0++;
          }
          else if ((studentList.get(i).grade) == 1) {
              total1++;
          }
          else if ((studentList.get(i).grade) == 2) {
              total2++;
          }
          else if ((studentList.get(i).grade) == 3) {
              total3++;
          }
          else if ((studentList.get(i).grade) == 4) {
              total4++;
          }
          else if ((studentList.get(i).grade) == 5) {
              total5++;
          }
          else if ((studentList.get(i).grade) == 6) {
              total6++;
          }
       }

    System.out.println("0: " + total0);
    System.out.println("1: " + total1);
    System.out.println("2: " + total2);
    System.out.println("3: " + total3);
    System.out.println("4: " + total4);
    System.out.println("5: " + total5);
    System.out.println("6: " + total6);
 	}
 	
  // Traceability: implements requirements NR1
 	// given classroom, list all students in that room
  public static void studentsInRoom(String [] inputArr){
  }
  
  // Traceability: implements requirements NR2
  // given classroom, list all teachers in that room
  public static void teachersInRoom(String [] inputArr){
  }
  
  // Traceability: implements requirements NR3
  // given grade, list all teachers in that grade
  public static void teachersInGrade(String [] inputArr){
    ArrayList<Integer> tempRoomList = new ArrayList<Integer>();
    ArrayList<Teacher> printList = new ArrayList<Teacher>();

    for (int i = 0; i < 60; i++) {
      if (inputArr[1].equals(Integer.toString(newStudentList.get(i).grade).trim())) {
        tempRoomList.add(newStudentList.get(i).classroom);
      }
    }
    
    for (int i = 0; i < tempRoomList.size(); i++) {
      for (int j = 0; j < teacherList.size(); j++) {
        if (tempRoomList.get(i) == teacherList.get(j).classroom && !printList.contains(teacherList.get(j))) {
          printList.add(teacherList.get(j));
        }
      }
    }
    
    if (printList.size() < 1) { 
      System.out.println("Not found.");
    } else {
      for (Teacher tea : printList) {
        System.out.println(tea.tLastName + "," + tea.tFirstName); 
      }
    }
  }
  
  // Traceability: implements requirements NR4
  // output number of students for each classroom
  public static void allStudentsByRoom(){
    int[] totals = new int[12];
    
    //for each room, add a corresponding total and increment when a student matches with that room
    for (int x = 0; x < roomList.size(); x++) {
      for (int i = 0; i < 60; i++) {
        if (roomList.get(x) == newStudentList.get(i).classroom) {
          totals[x]++;
        }
      }
    }

    for (int i = 0; i < roomList.size(); i++) {
      System.out.println(roomList.get(i) + ": " + totals[i]); 
    }
  }
  
  // Traceability: implements requirements NR5
  //output number of students in each classroom
  public static void newMethodNR5(String [] inputArr){
  }
  
}