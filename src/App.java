import java.util.InputMismatchException;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        //Initialized variables
        Scanner scanner = new Scanner(System.in);
        int choice;

        //Welcome message
        System.out.println("Welcome to the School Management System!");

        do{

            //Displays all options
            System.out.println("\nReview and select an option: ");
            System.out.println("\t 1) Create a new student record");
            System.out.println("\t 2) Create a new faculty record");
            System.out.println("\t 3) Edit a record");
            System.out.println("\t 4) Delete a record");
            System.out.println("\t 5) Read in a file containing records");
            System.out.println("\t 6) Save all records into a file");
            System.out.println("\t 7) Displaya all records");
            System.out.println("\t 8) Quit");
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
                createStudentRecord(scanner);
            }


        } while(choice != 8); //Continues loop until user wants to quit

        System.out.println("\nThank you for using School Management System!");
        scanner.close();
    }

    //Checks if string is numeric ** DOESN"T WORK **
    public static boolean isNumeric(String str){
        int num = Integer.parseInt(str);

        if(num >= 0 || num < 0){
            System.out.println("true");
            return true;
       }
       else{
        System.out.println("f");
            return false;
       }
    }


    //Creates a new student record
    public static void createStudentRecord(Scanner scanner){
        String firstName;
        String lastName;
        int age;
        int phoneNumber;
        String email;
        String major;
        String minor;
        String classYear;
        String graduationDate;

        System.out.println("\nPlease provide the student's firstName, lastName, age, phoneNumber, email, major, minor, class year, and graduation Date\n");
        System.out.print("First name: ");
        firstName = scanner.nextLine();
        System.out.print("Last name: ");
        lastName = scanner.nextLine();
        System.out.print("Age: ");
        age = scanner.nextInt();
        System.out.print("Phone number: ");
        phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Major: ");
        major = scanner.nextLine();
        System.out.print("Minor: ");
        minor = scanner.nextLine();
        System.out.print("Class year: ");
        classYear = scanner.nextLine();
        System.out.print("Graduation date: ");
        graduationDate = scanner.nextLine();

        System.out.println("\n" + firstName + " " + lastName + " " + age + " " + phoneNumber + " " + email + " " + major + " " + minor + " " + classYear + " " + graduationDate);

    }
}
