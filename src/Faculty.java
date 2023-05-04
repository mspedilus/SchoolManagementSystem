public class Faculty extends Person{

    static int numOfEmployees = 1;
    String occupation;
    String department;
    int yearsOfEmployement;
    int salary;  
    int facultyId;

    Faculty(String firstName, String lastName, int age, String phoneNumber, String email, String occupation, String department, int years, int salary) {
        super(firstName, lastName, age, phoneNumber, email);
        this.facultyId = numOfEmployees;
        this.setOccupation(occupation);
        this.setDepartment(department);
        this.setYearsOfEmployement(years);
        this.setSalary(salary);
        numOfEmployees++;
    }

    public void setOccupation(String occupation){
        this.occupation = occupation;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public void setYearsOfEmployement(int years){
        this.yearsOfEmployement = years;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }
}
