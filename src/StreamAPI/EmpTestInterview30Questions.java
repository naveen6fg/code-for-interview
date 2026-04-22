package StreamAPI;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmpTestInterview30Questions {    //To deal with (map) 1-"Collectors.groupingBy()"  2-"Collectors.toMap()"

	public static void main(String[] args) {

		// List of employee data initialization
		List<EmployeeBean> employeeList = Arrays.asList(
				new EmployeeBean(12221, "Naveen k", "Male", 10000000.99, "IT"),
				new EmployeeBean(67, "John Martinez", "Male", 156789.23, "IT"),
				new EmployeeBean(23, "Emily Brown", "Female", 98765.43, "HR"),
				new EmployeeBean(34, "David Johnson", "Male", 123456.78, "Finance"),
				new EmployeeBean(45, "Sarah Garcia", "Female", 87654.32, "Marketing"),
				new EmployeeBean(56, "Mike Smith", "Male", 134567.89, "Sales"),
				new EmployeeBean(78, "Lisa Williams", "Female", 76543.21, "Operations"),
				new EmployeeBean(89, "Tom Davis", "Male", 109876.54, "IT"),
				new EmployeeBean(90, "Anna Rodriguez", "Female", 143210.98, "HR"),
				new EmployeeBean(12, "Chris Miller", "Male", 87654.32, "Finance"),
				new EmployeeBean(231, "Jane Jones", "Female", 132109.87, "Marketing"),
				new EmployeeBean(345, "John Brown", "Male", 98765.43, "Sales"),
				new EmployeeBean(456, "Emily Martinez", "Female", 154321.09, "Operations"),
				new EmployeeBean(569, "David Garcia", "Male", 2435456.21, "IT"),
				new EmployeeBean(890, "Sarah Smith", "Female", 121098.76, "HR"),
				new EmployeeBean(901, "Mike Johnson", "Male", 87654.32, "Finance"),
				new EmployeeBean(812, "Lisa Williams", "Female", 143210.98, "Marketing"),
				new EmployeeBean(923, "Tom Davis", "Male", 98765.43, "Sales"),
				new EmployeeBean(145, "Anna Miller", "Female", 132109.87, "Operations"),
				new EmployeeBean(236, "Chris Rodriguez", "Male", 76543.21, "IT"),
				new EmployeeBean(567, "Jane Brown", "Female", 154321.09, "HR")
		);

		// Dummy Data for number list
		List<Integer> numberList = Arrays.asList(3, 4, 7, 9, 22, 13, 99, 28, 4, 45, 22, 18, 11, 24, 62, 14);

		// Dummy Data for string list
		List<String> nameList = Arrays.asList("Ram", "Shyam", "Radha", "Rani", "Ghanshyam");

		// Filter employees who belong to the 'IT' department and have a non-null department
		employeeList.stream()
				.filter(x -> x.getEmpDept() != null)
				.filter(x -> x.getEmpDept().equals("IT"))
				.forEach(x -> System.err.println(x));
		System.err.println();

		// Filter employees who belong to the 'Sales' department with a non-null department
		employeeList.stream()
				.filter(x -> x.getEmpDept() != null && x.getEmpDept().equalsIgnoreCase("Sales"))
				.forEach(x -> System.out.println(x));
		System.err.println();

		// Collect employee names and IDs as a Map where the key is the Employee ID and value is the Employee Name
		Map<Long, String> id_AND_dept = employeeList.stream()
				.filter(x -> x.getEmpDept() != null && x.getEmpDept().equalsIgnoreCase("Sales"))
				.collect(Collectors.toMap(x -> x.getEmpId(), x -> x.getEmpName())); // Collect as a Map

		// Display the entries of the map where the employee's name starts with "J"
		id_AND_dept.entrySet().stream()
				.filter(x -> x.getValue().startsWith("J"))
				.forEach(x -> System.out.println(x.getKey() + "==" + x.getValue()));
		System.err.println();

		// Print the entire map of employee IDs and names
		id_AND_dept.forEach((x, y) -> System.err.println((x + "==" + y)));
		System.err.println();

		// Convert the entry set of the map back to a map and display it
		id_AND_dept.entrySet().stream()
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()))
				.forEach((x, y) -> System.out.println(x + "==" + y));
		System.err.println();

		// Sort the map entries by employee name (value of the map) and display them
		id_AND_dept.entrySet().stream()
				.sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
				.forEach(x -> System.err.println(x.getKey() + "==" + x.getValue()));
		System.err.println();

		// Sort the map entries by employee ID (key of the map) and display them
		id_AND_dept.entrySet().stream()
				.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
				.forEach(x -> System.err.println(x.getKey() + "==" + x.getValue()));


		// Q1: How many male and female employees are there in the organization?
		Map<String, Long> genderCountMap = employeeList.stream().collect(Collectors.groupingBy(EmployeeBean::getEmpGender, Collectors.counting()));
		System.out.println("Q1: Gender count of employees in the organization: " + genderCountMap);
		System.out.println();

		// Q2: What is the average salary for male and female employees?
		Map<String, Double> averageSalaryByGender = employeeList.stream().collect(Collectors.groupingBy(EmployeeBean::getEmpGender, Collectors.averagingDouble(EmployeeBean::getEmpSal)));
		System.out.println("Q2: Average salary of employees grouped by gender: " + averageSalaryByGender);
		System.out.println();

		// Q28: List the top 3 highest-paid employees?
		List<EmployeeBean> top3HighestPaidEmployees = employeeList.stream()
				.sorted((e1, e2) -> Double.compare(e2.getEmpSal(), e1.getEmpSal()))
				.limit(3)
				.collect(Collectors.toList());
		System.out.println("Q28: Top 3 highest paid employees: " + top3HighestPaidEmployees);
		System.out.println();

		// Q22: Sorting Employee List based on Employee Name?
		List<EmployeeBean> sortedByName = employeeList.stream().sorted(Comparator.comparing(EmployeeBean::getEmpName))
				.collect(Collectors.toList());
		System.out.println("Q22: Employees sorted by name: " + sortedByName);
		System.out.println();

		// Q16: Find the first name of the oldest person in a list of Employee objects?
		Optional<EmployeeBean> oldestEmployee = employeeList.stream().max((e1, e2) -> Double.compare(e1.getEmpSal(), e2.getEmpSal()));
		System.out.println("Q16: Employee with the highest salary (indicating the oldest): " + oldestEmployee.get());
		System.out.println();

		// Q10: Find the employee with the highest salary?
		EmployeeBean highestSalaryEmployee = employeeList.stream()
				.max(Comparator.comparingDouble(EmployeeBean::getEmpSal))
				.get();
		System.out.println("Q10: Employee with the highest salary: " + highestSalaryEmployee);
		System.out.println();

		// Q3: Find occurrence of each element in a given integers list?
		Map<Integer, Long> elementOccurrence = numberList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Q3: Element occurrences in the list: " + elementOccurrence);
		System.out.println();

		// Q4: Find duplicate elements in the given integers list?
		List<Entry<Integer, Long>> duplicatedKeyValue = numberList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.collect(Collectors.toList());
		List<Integer> duplicatedNumbers = numberList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(Entry::getKey)
				.collect(Collectors.toList());
		System.out.println("Q4: Duplicated elements with counts: " + duplicatedKeyValue);
		System.out.println("Q4: List of duplicated numbers: " + duplicatedNumbers);
		System.out.println();

		// Q5: Find the sum of even numbers in the given list?
		int evenSum = numberList.stream().mapToInt(Integer::intValue).filter(num -> num % 2 == 0).sum();
		System.out.println("Q5: Sum of even numbers in the list: " + evenSum);
		System.out.println();

		// Q6: Find the sum of odd numbers in the given list?
		int oddSum = numberList.stream().mapToInt(Integer::intValue).filter(num -> num % 2 != 0).sum();
		System.out.println("Q6: Sum of odd numbers in the list: " + oddSum);
		System.out.println();

		// Q7: Remove all the occurrences of a given character from a string?
		String str1 = "Java Interview classes";
		char removeChar = 'a';
		String resultAfterRemoval = str1.chars().filter(c -> c != removeChar)
				.mapToObj(c -> String.valueOf((char)c))
				.collect(Collectors.joining());
		System.out.println("Q7: String after removing character 'a': " + resultAfterRemoval);
		System.out.println();

		// Q8: Find special characters in a string?
		String str2 = "Jav!a ^Inte#rview @cla)sses";
		String specialChars = str2.chars().filter(c -> !Character.isLetterOrDigit(c))
				.mapToObj(c -> String.valueOf((char)c))
				.collect(Collectors.joining(""));
		System.out.println("Q8: Special characters in the string: " + specialChars);
		System.out.println();

		// Q9: Find all numbers starting with '1' from the integer list?
		List<Integer> numbersStartingWithOne = numberList.stream()
				.filter(n -> String.valueOf(n).startsWith("1"))
				.collect(Collectors.toList());
		System.out.println("Q9: Numbers starting with '1': " + numbersStartingWithOne);
		System.out.println();

		// Q11: Concatenate a list of strings into a single string, separated by commas?
		String concatenatedString = nameList.stream().collect(Collectors.joining(", "));
		System.out.println("Q11: Concatenated string from name list: " + concatenatedString);
		System.out.println();

		// Q12: Find the first non-repeating character in a string?
		String str3 = "nandhnia";
		Character firstNonRepeatingChar = str3.chars()
				.mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream()
				.filter(entry -> entry.getValue() == 1)
				.map(Entry::getKey)
				.findFirst()
				.get();
		System.out.println("Q12: First non-repeating character: " + firstNonRepeatingChar);
		System.out.println();

		// Q13: Find frequency of characters in a string?
		String str4 = "nandhnia 77 asknjlhs";
		Map<Character, Long> charFrequencyMap = str4.chars()
				.mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println("Q13: Frequency of characters in the string: " + charFrequencyMap);
		System.out.println();

		// Q14: Group a list of strings by their length?
		String str5 = "My name is Kamlesh Kumar and another";
		Map<Integer, List<String>> groupedByLength = Arrays.asList(str5.split(" ")).stream()
				.collect(Collectors.groupingBy(String::length));
		System.out.println("Q14: Strings grouped by their length: " + groupedByLength);
		System.out.println();

		// Q15: Flatten a list of lists of integers into a single list of integers?
		List<List<Integer>> intList = Arrays.asList(Arrays.asList(73, 3, 5, 6, 7, 8),
				Arrays.asList(2, 3, 5, 6, 7, 9),
				Arrays.asList(73, 5, 5, 6, 7, 1));
		List<Integer> flattenedList = intList.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println("Q15: Flattened list of integers: " + flattenedList);
		System.out.println();


		// Q17: Skip the first 5 elements in a list and then print the rest?
		List<Integer> skippedFirstFive = numberList.stream().skip(5).collect(Collectors.toList());
		System.out.println("Q17: List after skipping the first 5 elements: " + skippedFirstFive);
		System.out.println();

		// Q18: Collect all unique words from a list of sentences?
		String str6 = "My name is Kamlesh Kumar and another name";
		List<String> uniqueWords = Arrays.stream(str6.split(" "))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()))
				.entrySet().stream()
				.filter(entry -> entry.getValue() == 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println("Q18: List of unique words: " + uniqueWords);
		System.out.println();

		// Q19: Filter out null values from a list of strings using streams?
		List<String> stringListWithNull = Arrays.asList("Naveen", null, "Aadi", "Sagar", null, "Punit");
		List<String> listWithoutNulls = stringListWithNull.stream().filter(e -> e != null).collect(Collectors.toList());
		System.out.println("Q19: List after removing null values: " + listWithoutNulls);
		System.out.println();

		// Q20: Partition a list of integers into even and odd numbers?
		Map<Boolean, List<Integer>> partitionedByEvenOdd = numberList.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("Q20: Even numbers: " + partitionedByEvenOdd.get(true));
		System.out.println("Q20: Odd numbers: " + partitionedByEvenOdd.get(false));
		System.out.println();

		// Q21: Generate an infinite sequence of random numbers and print the first 10?
		Random random = new Random();
		System.out.println("Q21: First 10 random numbers using Math.random:");
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		System.out.println("Q21: First 10 random integers using Random.nextInt:");
		Stream.generate(random::nextInt).limit(10).forEach(System.out::println);
		System.out.println();

		// Q23: Find the sum of the squares of a list of integers?
		int sumOfSquares = numberList.stream().mapToInt(e -> e * e).sum();
		System.out.println("Q23: Sum of squares of numbers in the list: " + sumOfSquares);
		System.out.println();

		// Q24: Convert a list of strings to a list of their respective lengths using streams?
		List<String> fruitNames = Arrays.asList("Banana", "Papaya", "Cherry", "GooseBerry");
		List<Integer> fruitNameLengths = fruitNames.stream().map(String::length).collect(Collectors.toList());
		System.out.println("Q24: Lengths of fruit names: " + fruitNameLengths);
		System.out.println();

		// Q25: Find the product of all elements in a list of integers?
		OptionalInt product = IntStream.of(2, 4, 9, 3, 8, 9).reduce((a, b) -> a * b);
		System.out.println("Q25: Product of all elements in the list: " + product.getAsInt());
		System.out.println();

		// Q26: Merge two lists of integers and remove duplicates?
		List<Integer> list1 = Arrays.asList(1, 3, 6, 7);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
		List<Integer> mergedListWithoutDuplicates = Stream.concat(list1.stream(), list2.stream())
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Q26: Merged list without duplicates: " + mergedListWithoutDuplicates);
		System.out.println();

		// Q27: Check if any string in a list starts with a specific prefix?
		List<String> fruits = Arrays.asList("Banana", "Papaya", "Cherry", "GooseBerry");
		List<String> fruitsStartingWithCh = fruits.stream().filter(x -> x.startsWith("Ch")).collect(Collectors.toList());
		System.out.println("Q27: Fruits starting with 'Ch': " + fruitsStartingWithCh);
		System.out.println();

		// Q29: Find the second highest number from the array?
		Optional<Integer> secondHighest = numberList.stream()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst();
		System.out.println("Q29: Second highest number: " + secondHighest.orElseThrow(() -> new RuntimeException("No second highest number")));
		System.out.println();


		//Twice
		List<EmployeeBean> list = employeeList.stream().sorted(Comparator.comparingDouble(EmployeeBean::getEmpSal).reversed().thenComparing(EmployeeBean::getEmpId).reversed()).toList();

		System.out.println(list);
	}

}
