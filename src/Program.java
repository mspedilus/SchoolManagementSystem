import java.util.ArrayList;

public class Program {
    ArrayList<Student> allStudents = new ArrayList<Student>();
    
    //Creates a new Student
    public void createNewStudent(String firstName, String lastName, int age, int phoneNumber, String email, String major, String minor, int classYear, String graduationDate){
        allStudents.add(new Student(firstName, lastName, age, phoneNumber, email, major, minor, classYear, graduationDate));
    }

    //Prints all students
    public void printAllStudents(){
        String x;
        String[] titles = {"First Name", "Last Name", "Age", "Phone Number", "Email", "Major", "Minor", "Class Year", "Graduation Date", "Student ID"};
        System.out.println("\n----- All Student records -----");
        x = String.format("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-15s", titles[9], titles[0], titles[1], titles[2], titles[3], titles[4], titles[5], titles[6], titles[7], titles[8]);
        System.out.println(x);

        for(Student s : allStudents){
            x = String.format("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-15s", s.studentId, s.firstName, s.lastName, s.age, s.phoneNumber, s.email, s.major, s.minor, s.classYear, s.graduationDate);
            System.out.println(x);
        }
    }

}
