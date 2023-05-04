import java.util.ArrayList;

public class Program {
    private ArrayList<Student> allStudents = new ArrayList<Student>();
    private ArrayList<Faculty> allFaculties  = new ArrayList<Faculty>();
    
    //Creates a new Student
    public void createNewStudent(String firstName, String lastName, int age, String phoneNumber, String email, String major, String minor, int classYear, String graduationDate){
        allStudents.add(new Student(firstName, lastName, age, phoneNumber, email, major, minor, classYear, graduationDate));
        return;
    }

    //Prints all students
    public void printAllStudents(){
        String x;
        String[] titles = {"First Name", "Last Name", "Age", "Phone Number", "Email", "Major", "Minor", "Class Year", "Graduation Date", "Student ID"};
        System.out.println("\n----- All Student Records -----");
        x = String.format("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-15s", titles[9], titles[0], titles[1], titles[2], titles[3], titles[4], titles[5], titles[6], titles[7], titles[8]);
        System.out.println(x);

        for(Student s : allStudents){
            x = String.format("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-15s", s.studentId, s.firstName, s.lastName, s.age, s.phoneNumber, s.email, s.major, s.minor, s.classYear, s.graduationDate);
            System.out.println(x);
        }
        return;
    }
    
    //Prints all faculties
    public void printAllFaculties(){
        String x;
        String[] titles = {"First Name", "Last Name", "Age", "Phone Number", "Email", "occupation", "department", "years", "salary", "Faculty ID"};
        System.out.println("\n----- All Faculty Records -----");
        x = String.format("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-10s", titles[9], titles[0], titles[1], titles[2], titles[3], titles[4], titles[5], titles[6], titles[7], titles[8]);
        System.out.println(x);

        for(Faculty f : allFaculties){
            x = String.format("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-,10d", f.facultyId, f.firstName, f.lastName, f.age, f.phoneNumber, f.email, f.occupation, f.department, f.yearsOfEmployement, f.salary);
            System.out.println(x);
        }
        return;
    }

    //Edits a Student object attribute
    public void editStudentInfo(int id, int option, String str, int num){
        id -= 1;
        Student student = allStudents.get(id);

        switch(option){
            case 1: 
                student.setFirstName(str); //Changes first name
                break;
            case 2: 
                student.setLastName(str); //Changes last name
                break;
            case 3: 
                student.setAge(num); //Changes age
                break;            
            case 4: 
                student.setPhoneNumber(str); //Changes phone number
                break;  
            case 5: 
                student.setEmail(str); //Changes email
                break;            
            case 6: 
                student.setMajor(str); //Changes major
                break;            
            case 7: 
                student.setMinor(str); //Changes minor
                break;         
            case 8: 
                student.setClassYear(num); //Changes class year
                break;           
            case 9: 
                student.setGraduationDate(str); //Changes graduation date
                break;    
        }

        return;

    }

    //Returns an index of allStudents or -1 if matching id is not found
    public int getIndex(int id){
        for(int i = 0; i < allStudents.size(); i++){
            if (allStudents.get(i).studentId == id){
                return i;
            }
        }
        return -1;
    }

    //Retrieves a student object
    public Student getStudent(int i){
        return allStudents.get(i);
    }

    //Returns length of allStudents
    public int getNumOfStudents(){
        int length = allStudents.size();
        return length;
    }

    //Removes student from array list
    public boolean deleteStudentRecord (int id){

        //Iterates through allStudents and removes student from arraylist if match was found
        for(int i = 0; i < allStudents.size(); i ++){
            if (allStudents.get(i).studentId == id){ //checks if id matches student id
                allStudents.remove(i);
                return false;
            }
        }

        return true;
    }

    //Creates a new faculty
    public void createNewSFaculty(String firstName, String lastName, int age, String phoneNumber, String email, String occupation, String department, int years, int salary){
        allFaculties.add(new Faculty(firstName, lastName, age, phoneNumber, email, occupation, department, years, salary));
        return;
    }

}
