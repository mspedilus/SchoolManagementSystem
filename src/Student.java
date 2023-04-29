public class Student extends Person{
    static int numOfStudents;
     // ArrayList<String> major;
    // ArrayList<String> minor;
    String major;
    String minor;
    String classYear;
    String graduationDate;

    
    Student(String firstName, String lastName, int age, int phoneNumber, String email, String major, String minor, String classYear, String graduationDate){
        super(firstName, lastName, age, phoneNumber, email);
        numOfStudents++;
        this.major = major;
        this.minor = minor;
        this.classYear = classYear;
        this.graduationDate = graduationDate;
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

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + age + " " + phoneNumber + " " + email + "\n" + major + " " + minor + " " + classYear + " " + graduationDate;
    }
    
}
