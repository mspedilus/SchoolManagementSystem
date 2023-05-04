import java.util.ArrayList;

public class Program {
    private ArrayList<Student> allStudents = new ArrayList<Student>();
    private ArrayList<Faculty> allFaculties  = new ArrayList<Faculty>();
    


    //Returns allStudents 
    public ArrayList<Student> getAllStudents(){
        return allStudents;
    }


    //Returns allFaculties
    public ArrayList<Faculty> getAllFaculties(){
        return allFaculties;
    }


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
        String[] titles = {"First Name", "Last Name", "Age", "Phone Number", "Email", "Occupation", "Department", "Years of Employment", "Salary (Yearly)", "Faculty ID"};
        System.out.println("\n----- All Faculty Records -----");
        x = String.format("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-20s %-10s", titles[9], titles[0], titles[1], titles[2], titles[3], titles[4], titles[5], titles[6], titles[7], titles[8]);
        System.out.println(x);

        for(Faculty f : allFaculties){
            x = String.format("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-20s %-,10d", f.facultyId, f.firstName, f.lastName, f.age, f.phoneNumber, f.email, f.occupation, f.department, f.yearsOfEmployement, f.salary);
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


        //Edits a faculty object attribute
        public void editFacultyInfo(int id, int option, String str, int num){
            id -= 1;
            Faculty faculty = allFaculties.get(id);
    
            switch(option){
                case 1: 
                    faculty.setFirstName(str); //Changes first name
                    break;
                case 2: 
                    faculty.setLastName(str); //Changes last name
                    break;
                case 3: 
                    faculty.setAge(num); //Changes age
                    break;            
                case 4: 
                    faculty.setPhoneNumber(str); //Changes phone number
                    break;  
                case 5: 
                    faculty.setEmail(str); //Changes email
                    break;            
                case 6: 
                    faculty.setOccupation(str); //Changes occupation
                    break;            
                case 7: 
                    faculty.setDepartment(str);//Changes department
                    break;         
                case 8: 
                    faculty.setYearsOfEmployement(num); //Changes years of employment
                    break;           
                case 9: 
                    faculty.setSalary(num); //Changes salary
                    break;    
            }
    
            return;
        }


    //Returns an index of allStudents or -1 if matching id is not found
    public int getStudentIndex(int id){
        for(int i = 0; i < allStudents.size(); i++){
            if (allStudents.get(i).studentId == id){
                return i;
            }
        }
        return -1;
    }

    //Returns an index of allFaculties or -1 if matching id is not found
    public int getFacultyIndex(int id){
        for(int i = 0; i < allFaculties.size(); i++){
            if (allFaculties.get(i).facultyId == id){
                return i;
            }
        }
        return -1;
    }

    //Retrieves a student object
    public Student getStudent(int i){
        return allStudents.get(i);
    }

    //Retrieves a faculty object
    public Faculty getFaculty(int i){
        return allFaculties.get(i);
    }

    //Returns length of allStudents
    public int getNumOfStudents(){
        int length = allStudents.size();
        return length;
    }

    //Returns length of allFaculties
    public int getNumOfFaculty(){
        int length = allFaculties.size();
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

    //Removes faculty from array list
    public boolean deleteFacultyRecord (int id){

        //Iterates through allFaculties and removes faculty from arraylist if match was found
        for(int i = 0; i < allFaculties.size(); i ++){
            if (allFaculties.get(i).facultyId == id){ //checks if id matches faculty id
                allFaculties.remove(i);
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
