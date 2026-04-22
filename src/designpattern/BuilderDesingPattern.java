package designpattern;

public class BuilderDesingPattern {

    //mendatory field
    private String firstName;
    private String lastName;

    //optional field
    private int age ;
    private String address ;
    private String phNo ;

    // Private constructor so only Builder can instantiate
    private BuilderDesingPattern(BuilderClass builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
        this.phNo = builder.phNo;
    }

    // Getters (No setters to ensure immutability)
    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhNo() {
        return phNo;
    }

    public static class BuilderClass{

        // Required fields
        private final String firstName;
        private final String lastName;

        // Optional fields (initialize with default values)
        private int age = 0;
        private String address = "";
        private String phNo = "";

        public BuilderClass(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public BuilderClass setAge(int age) {
            this.age = age;
            return this;
        }

        public BuilderClass setAddress(String address) {
            this.address = address;
            return this;
        }

        public BuilderClass setPhoneNumber(String phNo) {
            this.phNo = phNo;
            return this;
        }
        // Build method to create a Person object
        public BuilderDesingPattern build() {
            return new BuilderDesingPattern(this); // pass the builder to the private constructor
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phNo + '\'' +
                '}';
    }


    // Main method for testing
    public static void main(String[] args) {
        // Using the builder to create an object
        BuilderDesingPattern person = new BuilderDesingPattern.BuilderClass("John", "Doe")
                .setAge(30)
                .setAddress("123 Main St")
                .setPhoneNumber("123-456-7890")
                .build();

        // Printing the object
        System.out.println(person);
    }
}
//The Builder Design Pattern is a creational pattern used to simplify the construction of complex objects.
// When an object has many parameters, especially optional ones,
// the Builder pattern allows you to construct the object step-by-step by specifying only the necessary parameters.