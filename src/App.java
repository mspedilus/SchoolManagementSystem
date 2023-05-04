import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


//Main class for School Management System
public class App {
    public static void main(String[] args) throws Exception {

        //Initialized variables
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        int option;

        //Welcome message
        System.out.println("Welcome to the School Management System!");

        do{
            //Displays menu options
            System.out.println("\nReview and select an option: ");
            System.out.println("\t 0) Quit");
            System.out.println("\t 1) Create a new student record");
            System.out.println("\t 2) Create a new faculty record");
            System.out.println("\t 3) Edit a student record");
            System.out.println("\t 4) Edit a faculty record");
            System.out.println("\t 5) Delete a record");
            System.out.println("\t 6) Read in records from Records.txt file");
            System.out.println("\t 7) Save all records into a file");
            System.out.println("\t 8) Display all student records");
            System.out.println("\t 9) Display all faculty records");
            System.out.println("\t 10) Display all records");
            System.out.print("\nEntered: ");

            //Retrieves user choice
            option = isNumeric(scanner);
            
            //Chooses appropriate resposne
            if(option == 1){ //Creates a student record
                createStudentRecord(scanner, p);
            }
            else if(option == 2){
                createFacultyRecord(scanner, p);
            }
            else if(option == 3){ //Edits a student record
                editStudentRecord(scanner, p);
            }
            else if(option == 4){ //Edits a faculty record
                editFacultyRecord(scanner, p);
            }
            else if(option == 5){ //Deletes a record
                deleteRecord(scanner, p);
            }
            else if(option == 6){ //Saves all records into a file
                readFromFile(p);
            }
            else if(option == 7){ //Reads a file into program
                saveToFile(p);
            }
            else if(option == 8){ //Prints all student records
                printAllStudents(p);
            }
            else if(option == 9){ //Prints all faculty records
                printAllFaculties(p);
            }
            else if(option == 10){
                printAllRecords(p);
            }

        } while(option != 0); //Continues loop until user wants to quit

        System.out.println("\nThank you for using School Management System!");
        scanner.close();
    }



    //Prints all student records
    static public void printAllStudents(Program p){
        p.printAllStudents();
    }


    //Prints all faculty records
    static public void printAllFaculties (Program p){
        p.printAllFaculties();
    }


    //Prints both stuent and faculty records
    static public void printAllRecords(Program p){
        printAllStudents(p);
        printAllFaculties(p);
    }


    //Ensures input is a valid number
    public static int isNumeric(Scanner scanner){
        int response = -1;

        while (response == -1 || response < 0){
            try{
                response = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("\nInvalid input: Please provide positive numbers only");
            }
            finally{
                scanner.nextLine();
            }
        }

        return response; 
    }




    //Creates a new student record
    public static void createStudentRecord(Scanner scanner, Program p){

        //Variables needed to create new Student object
        String firstName;
        String lastName;
        int age;
        String phoneNumber;
        String email;
        String major;
        String minor;
        int classYear;
        String graduationDate;

        //Gathers information to create new student record
        System.out.println("\nPlease provide the student's first name, last name, age, phone number, email, major, minor, graduation date, and class year\n");
        
        System.out.print("First name: "); 
        firstName = scanner.nextLine(); //Retrieves first name
        System.out.print("Last name: "); 
        lastName = scanner.nextLine(); //Retrieves last name
        System.out.print("Age: ");
        age = isNumeric(scanner);  //Retrieves age
        System.out.print("Phone number: ");
        phoneNumber = scanner.nextLine();   //Retrieves phone number
        System.out.print("Email: ");  
        email = scanner.nextLine(); //Retrieves email
        System.out.print("Major: ");  
        major = scanner.nextLine(); //Retrieves major(s)
        System.out.print("Minor: ");  
        minor = scanner.nextLine(); //Retrieves minor(s)
        System.out.print("Graduation date: ");
        graduationDate = scanner.nextLine();  //Retrieves graduation year
        System.out.print("Class year (1 = Freshman, 2 = Sophmore, 3 = Junior, 4 = Senior): ");
        classYear = isNumeric(scanner);  //Retrieves class year

        //Validates classYear
        while(!(classYear >= 1 && classYear <= 4)){ 
            System.out.println("Please enter one of these options: 1 = Freshman, 2 = Sophmore, 3 = Junior, 4 = Senior) ");
            classYear = isNumeric(scanner);
        }

        //Creates new student record
        p.createNewStudent(firstName, lastName, age, phoneNumber, email, major, minor, classYear, graduationDate);

        System.out.println("\n----- New student record created -----");
    }





    //Creates a new faculty record (obj)
    public static void createFacultyRecord(Scanner scanner, Program p){

        //Variables needed to create new Faculty object
        String firstName;
        String lastName;
        int age;
        String phoneNumber;
        String email;
        String occupation;
        String department;
        int years;
        int salary;

        //Gathers information to create new faculty record
        System.out.println("\nPlease provide the faculty's first name, last name, age, phone number, email, occupation, department, years of employment, and salary\n");
        System.out.print("First name: "); 
        firstName = scanner.nextLine(); //Retrieves first name
        System.out.print("Last name: "); 
        lastName = scanner.nextLine(); //Retrieves last name
        System.out.print("Age: ");
        age = isNumeric(scanner);  //Retrieves age
        System.out.print("Phone number: ");
        phoneNumber = scanner.nextLine();   //Retrieves phone number
        System.out.print("Email: ");  
        email = scanner.nextLine(); //Retrieves email
        System.out.print("Occupation: ");  
        occupation = scanner.nextLine(); //Retrieves occupation
        System.out.print("Department: ");  
        department = scanner.nextLine(); //Retrieves department
        System.out.print("Years of employement: ");
        years = isNumeric(scanner);  //Retrieves years of employment
        System.out.print("Salary (Yearly): "); 
        salary = isNumeric(scanner); //Retrieves salary

        //Creates new faculty record
        p.createNewSFaculty(firstName, lastName, age, phoneNumber, email, occupation, department, years, salary);

        System.out.println("\n----- New faculty record created -----");
    }





    //Edits a student record by id
    static public void editStudentRecord(Scanner scanner, Program p){

        //Total number of students
        int numOfStudents = p.getNumOfStudents(); 

        //If there are no student records, exist function
        if (numOfStudents == 0){
            System.out.println("\n ***** No student record exist *****");
            return;
        }

        //Asks user which student record to edit
        printAllStudents(p);
        System.out.print("\nEnter student id: ");
        int id = isNumeric(scanner);
        int index = p.getStudentIndex(id);

        //Ensures id is valid
        while(index == -1){
            System.out.print("\nStudent ID not valid.\nEnter student id: ");
            id = isNumeric(scanner);
            index = p.getStudentIndex(id);
        }

        int option = 1;
        Student student = p.getStudent(index);

        //Loops through options until user wants to exit
        while(option  != 0){

            //Prompt to display options
            System.out.println("\nWhich option would you like to edit?");
            System.err.println("\t0) Back to main menu");
            System.out.println("\t1) First name: " + student.firstName);
            System.out.println("\t2) Last name: " + student.lastName);
            System.out.println("\t3) Age: " + student.age);
            System.out.println("\t4) Phone number: " + student.phoneNumber);
            System.out.println("\t5) Email: " + student.email);
            System.out.println("\t6) Major(s): " + student.major);
            System.out.println("\t7) Minor(s): " + student.minor);
            System.out.println("\t8) Class year: " + student.classYear);
            System.out.println("\t9) Graduation year: " + student.graduationDate);
    
            System.out.print("\nEntered: ");
            option = scanner.nextInt();
            scanner.nextLine();
        
            
            if(option == 0){ //Exits loop
                return;
            }
            else if (option == 3){ //Retrieves age
                System.out.print("New Input: ");
                int num = isNumeric(scanner);
                p.editStudentInfo(id, option, null, num);
    
            }
            else if(option == 8){ //Retrieves class year
                System.out.print("New Input: ");
                int classYear = isNumeric(scanner);  //Retrieves class year
    
                //Validates classYear
                while(!(classYear >= 1 && classYear <= 4)){ 
                    System.out.println("Please enter one of these options: 1 = Freshman, 2 = Sophmore, 3 = Junior, 4 = Senior) ");
                    classYear = isNumeric(scanner);
                }
                p.editStudentInfo(id, option, null, classYear);
    
            }
            else{ //Retrieves everything else
                System.out.print("New Input: ");
                String str = scanner.nextLine();
                p.editStudentInfo(id, option, str, -1);
            }
            
            System.out.println("\n----- Student (ID #" + id + ") record was edited -----");
        }
    }






    //Edits a faculty record by id
    static public void editFacultyRecord(Scanner scanner, Program p){

        //Total number of students
        int numOfFaculty = p.getNumOfFaculty(); 

        //If there are no faculty records, exist function
        if (numOfFaculty == 0){
            System.out.println("\n ***** No faculty record exist *****");
            return;
        }

        //Asks user which faculty record to edit
        printAllFaculties(p);
        System.out.print("\nEnter faculty id: ");
        int id = isNumeric(scanner);
        int index = p.getFacultyIndex(id);

        //Ensures id is valid
        while(index == -1){
            System.out.print("\nFaculty ID not found.\nEnter faculty id: ");
            id = isNumeric(scanner);
            index = p.getFacultyIndex(id);
        }

        int option = 1;
        Faculty faculty = p.getFaculty(index);

        //Loops through options until user wants to exit
        while(option  != 0){
            
            //Prompt to display options
            System.out.println("\nWhich option would you like to edit?");
            System.err.println("\t0) Back to main menu");
            System.out.println("\t1) First name: " + faculty.firstName);
            System.out.println("\t2) Last name: " + faculty.lastName);
            System.out.println("\t3) Age: " + faculty.age);
            System.out.println("\t4) Phone number: " + faculty.phoneNumber);
            System.out.println("\t5) Email: " + faculty.email);
            System.out.println("\t6) Occupation: " + faculty.occupation);
            System.out.println("\t7) Department: " + faculty.department);
            System.out.println("\t8) Years of Employement: " + faculty.yearsOfEmployement);
            System.out.println("\t9) Salary (Yearly): " + faculty.salary);
    
            System.out.print("\nEntered: ");
            option = scanner.nextInt();
            scanner.nextLine();
        
            
            if(option == 0){  //Exits loop
                return;
            }
            else if(option == 3 || option == 8 || option == 9){ //Retrieves age, years of employement, or salary
                System.out.print("New Input: ");
                int num = isNumeric(scanner);
                p.editFacultyInfo(id, option, null, num);
    
            }
            else{ //Retrieves everything else
                System.out.print("New Input: ");
                String str = scanner.nextLine();
                p.editFacultyInfo(id, option, str, -1);
            }
            
            System.out.println("\n----- faculty (ID #" + id + ") record was edited -----");
        }
    }

    

    

    //Decides which record (student or faculty) to delete based on user response
    static public void deleteRecord(Scanner scanner, Program p){

        int option = 1;
        do{
            //Prompt for selecting which type of record to delete
            System.err.println("\nReview and select an option:");
            System.out.println("\t0) Back to main menu");
            System.out.println("\t1) Delete a student record");
            System.out.println("\t2) Delete a faculty record");

            option = isNumeric(scanner); //Retrieves user input

            if(option == 1){ //Deletes a student record
                deleteStudentRecord(scanner, p);
            }
            else if(option == 2){ //Deletes a faculty record
                deleteFacultyRecord(scanner, p);
            }

        } while (option == 1 || option == 2); //Continues loop until user chooses to exit
    }





    //Deletes a student record
    static public void deleteStudentRecord(Scanner scanner, Program p){

        //Retrieves total number of students
        int numOfStudents = p.getNumOfStudents();

        //If there are no student records, exit function
        if (numOfStudents == 0){
            System.out.println("\n ***** No student record exist *****");
            return;
        }

        //Asks user which student record to delete
        printAllStudents(p);
        System.out.print("\nEnter student id or 0 to exit: ");
        int id = isNumeric(scanner);
        boolean isNotDeleted = p.deleteStudentRecord(id);

        //Ensures a valid id is retrieved then deletes record
        while(isNotDeleted == true){
            System.out.print("\nStudent ID not valid.\nEnter student id: ");
            id = scanner.nextInt();
            isNotDeleted = p.deleteStudentRecord(id);
        }

        System.out.println("\n----- Student (ID #" + id + ") record was deleted -----");
    }





    //Deletes a faculty record
    static public void deleteFacultyRecord(Scanner scanner, Program p){

        //Retrieves total number of faculty
        int faculty = p.getNumOfFaculty();

        //If there are no faculty records, exit function
        if (faculty == 0){
            System.out.println("\n ***** No faculty record exist *****");
            return;
        }

        //Asks user which faculty record to delete
        printAllFaculties(p);
        System.out.print("\nEnter faculty id: ");
        int id = isNumeric(scanner);
        boolean isNotDeleted = p.deleteFacultyRecord(id);

        //Ensures a valid id is retrieved then deletes record
        while(isNotDeleted == true){
            System.out.print("\nFaculty ID not valid.\nEnter faculty id: ");
            id = scanner.nextInt();
            isNotDeleted = p.deleteFacultyRecord(id);
        }

        System.out.println("\n----- Faculty (ID #" + id + ") record was deleted -----");
    }




    

    //Saves all records into a file
    static public void saveToFile(Program p) throws IOException{
        String titleStr;
        String recordStr;

        //Writes all student records to file
        String[] titles = {"First Name", "Last Name", "Age", "Phone Number", "Email", "Major", "Minor", "Class Year", "Graduation Date", "Student ID"};
        FileWriter writer = new FileWriter("Records.txt");
        writer.write("----- All Student Records -----");
        titleStr = String.format("\n%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-15s", titles[9], titles[0], titles[1], titles[2], titles[3], titles[4], titles[5], titles[6], titles[7], titles[8]);
        writer.write(titleStr);

        for(Student s : p.getAllStudents()){
            recordStr = String.format("\n%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-15s", s.studentId, s.firstName, s.lastName, s.age, s.phoneNumber, s.email, s.major, s.minor, s.classYear, s.graduationDate);
            writer.write(recordStr);
        }

        //Writes all faculty records to file
        String[] titles2 = {"First Name", "Last Name", "Age", "Phone Number", "Email", "Occupation", "Department", "Years of Employment", "Salary (Yearly)", "Faculty ID"};
        titleStr = String.format("\n%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-20s %-10s", titles2[9], titles2[0], titles2[1], titles2[2], titles2[3], titles2[4], titles2[5], titles2[6], titles2[7], titles2[8]);
        writer.write("\n\n\n\n----- All Faculty Records -----");
        writer.write(titleStr);
        
        for(Faculty f : p.getAllFaculties()){
            recordStr = String.format("\n%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-20s %-,10d", f.facultyId, f.firstName, f.lastName, f.age, f.phoneNumber, f.email, f.occupation, f.department, f.yearsOfEmployement, f.salary);
            writer.write(recordStr);
        }

        writer.close();
        System.out.println("\n----- All records saved in Records.txt file -----");
    }



    


    static public void readFromFile(Program p) {
        
    }

}

