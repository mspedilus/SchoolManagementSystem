public abstract class Person {
    static int numOfPeople;
    String firstName;
    String lastName;
    int age;
    int phoneNumber;
    String email;


    Person(String firstName, String lastName, int age, int phoneNumber, String email){
        numOfPeople++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

