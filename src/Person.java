public abstract class Person {
    static int numOfPeople;
    String firstName;
    String lastName;
    int age;
    String phoneNumber;
    String email;


    Person(String firstName, String lastName, int age, String phoneNumber, String email){
        numOfPeople++;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }
}

