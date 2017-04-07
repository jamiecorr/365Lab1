public class Student {
	String stLastName, stFirstName, tLastName, tFirstName;
	int bus, grade, classroom;
  double GPA;
 
	public Student(String stLastName, String stFirstName, int grade,
      int classroom, int bus, double GPA, String tLastName, String tFirstName) {
    super();
    this.stLastName = stLastName;
    this.stFirstName = stFirstName;
    this.grade = grade;
    this.classroom = classroom;
    this.bus = bus;
    this.GPA = GPA;
    this.tLastName = tLastName;
    this.tFirstName = tFirstName;
  }
}