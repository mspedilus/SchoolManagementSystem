import java.util.InputMismatchException;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        //Initialized variables
        Program p = new Program();
        Scanner scanner = new Scanner(System.in);
        int choice;

        //Welcome message
        System.out.println("Welcome to the School Management System!");

        do{

            //Displays all options
            System.out.println("\nReview and select an option: ");
            System.out.println("\t 0) Quit");
            System.out.println("\t 1) Create a new student record");
            System.out.println("\t 2) Create a new faculty record");
            System.out.println("\t 3) Edit a record");
            System.out.println("\t 4) Delete a record");
            System.out.println("\t 5) Read in a file containing records");
            System.out.println("\t 6) Save all records into a file");
            System.out.println("\t 7) Display all student records");
            System.out.println("\t 8) Display all faculty records");
            System.out.println("\t 9) Display all instructor records");
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
            finally{
                scanner.nextLine();
            }

            if(choice == 1){
                createStudentRecord(scanner, p);
            }
            else if(choice == 7){
                printAllStudents(p);
            }


        } while(choice != 8); //Continues loop until user wants to quit

        System.out.println("\nThank you for using School Management System!");
        scanner.close();
    }

    //Ensures input is a valid number **Doesn't work properly with phone numbers***
    public static int isNumeric(Scanner scanner){
        int response = -1;

        while (response == -1 || response <= 0){
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
        int phoneNumber;
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
        phoneNumber = isNumeric(scanner);  //Retrieves phone number
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

    static public void printAllStudents(Program p){
        p.printAllStudents();
    }
}
