import java.util.InputMismatchException;
import java.util.Scanner;

//Main class for School Management System
public class App {
    public static void main(String[] args) throws Exception {

        //Initialized variables
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        int choice;

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
            System.out.println("\t 6) Read in a file containing records");
            System.out.println("\t 7) Save all records into a file");
            System.out.println("\t 8) Display all student records");
            System.out.println("\t 9) Display all faculty records");
            System.out.println("\t 10) Display all records");
            System.out.print("\nEntered: ");

            //Choice validation
            try{
                choice = scanner.nextInt();
            }
            catch(InputMismatchException e){ // If user does not enter a valid option
                System.out.println("\n***** Option selected is invalid. Please try again. *****");
                choice = -1;
            }
            catch(Exception e){ //Catches all other unexpected errors
                System.out.println("Something went wrong. Please try again later.");
                choice = 8;
            }
            finally{ //Clears input stream
                scanner.nextLine();
            }

            //Chooses appropriate resposne
            if(choice == 1){ //Creates a student record
                createStudentRecord(scanner, p);
            }
            else if(choice == 2){
                createFacultyRecord(scanner, p);
            }
            else if(choice == 3){ //Edits a student record
                editStudentInfo(scanner, p);
            }
            else if(choice == 5){ //Deletes a student record
                deleteStudentRecord(scanner, p);
            }
            else if(choice == 8){ //Prints all student records
                printAllStudents(p);
            }
            else if(choice == 9){ //Prints all faculty records
                printAllFaculties(p);
            }
            else if(choice == 10){
                printAllRecords(p);
            }

        } while(choice != 0); //Continues loop until user wants to quit

        System.out.println("\nThank you for using School Management System!");
        scanner.close();
    }



    //Ensures input is a valid number
    public static int isNumeric(Scanner scanner){
        int response = -1;

        while (response == -1 || response < 0){
            try{
                response = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input: Please provide positive numbers only");
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

    //Prints all student records
    static public void printAllStudents(Program p){
        p.printAllStudents();
    }

    //Prints all faculty records
    static public void printAllFaculties (Program p){
        p.printAllFaculties();
    }

    //Edits a student record by id
    static public void editStudentInfo(Scanner scanner, Program p){

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
        int id = scanner.nextInt();
        int index = p.getIndex(id);

        //Ensures id is valid
        while(index == -1){
            System.out.print("\nStudent ID not valid.\nEnter student id: ");
            id = scanner.nextInt();
            index = p.getIndex(id);
        }

        int option = 1;
        Student student = p.getStudent(index);

        //Loops through options until user wants to exit
        while(option  != 0){

            //Prompt to display options
            System.out.println("\nWhich option would you like to edit?");
            System.err.println("\t0) Back  to main menu");
            System.out.println("\t1) First name: " + student.firstName);
            System.out.println("\t2) Last name: " + student.lastName);
            System.out.println("\t3) Age: " + student.age);
            System.out.println("\t4) Phone number: " + student.phoneNumber);
            System.out.println("\t5) Email: " + student.email);
            System.out.println("\t6) Major: " + student.major);
            System.out.println("\t7) Minor: " + student.minor);
            System.out.println("\t8) Class year: " + student.classYear);
            System.out.println("\t9) Graduation year: " + student.graduationDate);
    
            System.out.print("\nEntered: ");
            option = scanner.nextInt();
            scanner.nextLine();
        
            //Exits loop
            if(option == 0){
                return;
            }

            if (option == 3){ //Retrieves age
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
            else{ 
                System.out.print("New Input: ");
                String str = scanner.nextLine();
                p.editStudentInfo(id, option, str, -1);
            }
            
            System.out.println("\n----- Student (ID #" + id + ") record was edited -----");

        }
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
        int id = scanner.nextInt();
        boolean isNotDeleted = p.deleteStudentRecord(id);

        //Ensures a valid id is retrieved then deletes record
        while(isNotDeleted == true){
            System.out.print("\nStudent ID not valid.\nEnter student id: ");
            id = scanner.nextInt();
            isNotDeleted= p.deleteStudentRecord(id);
        }

        System.out.println("\n----- Student (ID #" + id + ") record was deleted -----");

    }


    //Creates a new faculty record
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
        years = scanner.nextInt();  //Retrieves years of employment
        System.out.print("Salary: "); 
        salary = scanner.nextInt(); //Retrieves salary

        //Creates new faculty record
        p.createNewSFaculty(firstName, lastName, age, phoneNumber, email, occupation, department, years, salary);

        System.out.println("\n----- New faculty record created -----");
    }

    static public void printAllRecords(Program p){
        printAllStudents(p);
        printAllFaculties(p);
    }


}

