package stream.problem.given.by.Aadi;

import jdk.jshell.execution.Util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestData {

    public static void main(String[] args) {

        // Employees
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Naveen", "IT", 80000, "Bangalore"),
                new Employee(2, "Rahul", "HR", 50000, "Mumbai"),
                new Employee(3, "Amit", "IT", 90000, "Bangalore"),
                new Employee(4, "Priya", "Finance", 70000, "Delhi"),
                new Employee(5, "Sneha", "HR", 60000, "Mumbai"),
                new Employee(6, "Kiran", "IT", 85000, "Hyderabad")
        );

        // Products
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 70000),
                new Product(2, "Mobile", 30000),
                new Product(3, "TV", 80000),
                new Product(4, "Keyboard", 2000)
        );

        // Numbers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Transactions
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, "Food", 200),
                new Transaction(2, "Shopping", 1500),
                new Transaction(3, "Food", 300),
                new Transaction(4, "Bills", 1000),
                new Transaction(5, "Shopping", 2000)
        );

        // Books
        List<Book> books = Arrays.asList(
                new Book("Book1", "Fiction", 4.5),
                new Book("Book2", "Fiction", 4.8),
                new Book("Book3", "Fiction", 4.2),
                new Book("Book4", "Fiction", 4.9),
                new Book("Book5", "Science", 4.7),
                new Book("Book6", "Science", 4.1),
                new Book("Book7", "Science", 4.9)
        );

        // Students
        List<Student> students = Arrays.asList(
                new Student("A", "A", 85),
                new Student("B", "A", 92),
                new Student("C", "B", 78),
                new Student("D", "B", 88),
                new Student("E", "C", 95)
        );

        List<String> words = Arrays.asList("Java", "Stream", "API", "Java");

        // Paragraph
        String paragraph = "Java is great. Java is powerful! Streams are great.";


      /*

Java Streams & Collectors Practice – Problem Set

1️⃣ Group employees by department and find average salary per department
You are given a List<Employee> where each employee has id, name, department, and salary.
Using Streams and Collectors, produce a Map<String, Double> where each key is a department name and the value is the average salary of employees in that department.
*/

       Map<String,Double> empGroup =  employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
       System.out.println(empGroup);


        /*
2️⃣ Partition numbers into primes and non-primes
Write a method that takes a List<Integer> and splits it into two groups: prime numbers and non-prime numbers.
Return a Map<Boolean, List<Integer>> such that true → primes, false → non-primes. Use Collectors.partitioningBy.
*/

      Map<Boolean,List<Integer>> primeandNon =   numbers.stream().filter(x -> x != 1).
              collect(Collectors.partitioningBy(x->IntStream.rangeClosed(2,(int)Math.sqrt(x)).noneMatch(i-> x % i ==0)));


        System.out.println(primeandNon.get(true));
        System.out.println(primeandNon.get(false));
/*
3️⃣ Build a comma-separated string of product names priced above 100
Given a list of Product objects (id, name, price), filter out the products with price > 50000.
Concatenate their names into a single comma-separated String.

*/

       String str =  products.stream().filter(x->x.getPrice()>=70000).map(x->x.getName())
                     .collect(Collectors.joining(","));

        System.out.println(str);
 /*
4️⃣ Create a map of city → number of employees in that city
Suppose you have a list of employees, each with a city field.
Build a Map<String, Long> that shows how many employees are located in each city.
*/

       Map<String,Long> empCount =  employees.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.counting()));
       System.out.println(empCount);
/*
5️⃣ Collect all distinct letters from a list of words into a sorted set
Given a List<String> of words, extract all unique characters (letters only), ignoring case, and collect them into a TreeSet so they’re alphabetically ordered.
*/

      TreeSet set = words.stream().flatMap(w->Arrays.stream( w.split(""))).collect(Collectors.toCollection(TreeSet::new));

        System.out.println(set);
/*
6️⃣ From transactions, build a map of type → total amount
You are given a List<Transaction> where each transaction has id, type (String), and amount (double).
Use a collector to produce a Map<String, Double> representing the total amount spent for each transaction type.
*/


/*
7️⃣ Given a list of books, map genre → list of top 3 books by rating
For a list of Book objects (title, genre, rating), group books by genre.
For each genre, collect the top 3 highest-rated books into a list.

⸻

8️⃣ Count frequency of words in a paragraph (case-insensitive)
Given a String paragraph, split it into words (ignore punctuation, normalize to lower case).
Use streams to create a Map<String, Long> of each word and its occurrence count.

⸻

9️⃣ Given student list, group by grade and find highest score per grade
A List<Student> contains name, grade, and score.
Group students by grade and, for each group, find the student with the highest score.

⸻

🔟 Collect elements into an immutable list
Take any List<String> and use Collectors.toUnmodifiableList() to create an immutable list of its elements after some transformation (e.g., uppercase).

⸻

If you plan to share this with someone, this format is clean and interview-ready.
       */
    }
}