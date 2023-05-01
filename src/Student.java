public class Student extends Person{
    static int numOfStudents = 1;
    int studentId;
    String major;
    String minor;
    String classYear;
    String graduationDate;

    //Constructor
    Student(String firstName, String lastName, int age, int phoneNumber, String email, String major, String minor, int classYear, String graduationDate){
        super(firstName, lastName, age, phoneNumber, email);
        this.setStudentId(numOfStudents);
        this.setMajor(major);
        this.setMinor(minor);
        this.setYear(classYear);
        this.setGraduationDate(graduationDate);
        numOfStudents++;
        
    }
    
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public void setMinor(String minor){
        this.minor = minor;
    }


    public void setYear(int classYear){
        
        switch(classYear){
            case 1: 
                this.classYear = "Freshman";
                break;
            case 2: 
                this.classYear = "Sophmore";
                break;
            case 3:
                this.classYear = "Junior";
                break;
            case 4: 
                this.classYear = "Senior";
                break;
            default:
                this.classYear = "";
        }
        
    }

    public void setGraduationDate(String graduationDate){
        this.graduationDate = graduationDate;
    }
    
}
