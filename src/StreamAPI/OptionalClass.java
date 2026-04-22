package StreamAPI;

import java.util.Optional;

public class OptionalClass {


    private final String value;

    OptionalClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public class Main {
        public static void main(String[] args) {
            // Example 1: String
            String name = "John Doe";
            Optional<String> optionalName = Optional.ofNullable(name);
            optionalName.ifPresent(n -> System.out.println("Name: " + n));

            // Example 2: Integer
            Integer number = 42;
            Optional<Integer> optionalNumber = Optional.ofNullable(number);
            optionalNumber.ifPresent(n -> System.out.println("Number: " + n));

            // Example 3: Custom Object
            OptionalClass obj = new OptionalClass("Custom Object");
            Optional<OptionalClass> optionalObject = Optional.ofNullable(obj);
            optionalObject.ifPresent(o -> System.out.println("Custom Object Value: " + o.getValue()));

            // Example 4: Handling null value
            String nullValue = null;
            Optional<String> optionalNull = Optional.ofNullable(nullValue);
            if (optionalNull.isEmpty()) {
                System.out.println("The optional is empty.");
            }

            // Example 5: Using Optional.empty()
            Optional<String> emptyOptional = Optional.empty();
            emptyOptional.ifPresentOrElse(
                    value -> System.out.println("This won't be printed because the optional is empty."),
                    () -> System.out.println("Optional is explicitly empty.")
            );
        }
    }
}
