package StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingDiffWays {
    public static void main(String[] args) {

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
                new EmployeeBean(345, "John Brown", "Male", 98765.43, "Sales"));

        List<EmployeeBean> top4HighestPaidEmployees1 = employeeList.stream()
                .sorted((e1, e2) -> Double.compare(e2.getEmpSal(), e1.getEmpSal())) // compare() this methood is not from Comparator interfcae  but it is from Double class this method is static
                .limit(4)
                .collect(Collectors.toList());
        List<EmployeeBean> top4HighestPaidEmployees2 = employeeList.stream()
                .sorted((e1, e2) -> e2.getEmpSal().compareTo(e1.getEmpSal()))
                .limit(4)
                .collect(Collectors.toList());
        List<EmployeeBean> top4HighestPaidEmployees3 = employeeList.stream()
                .sorted(Comparator.comparingDouble(EmployeeBean::getEmpSal).reversed())
                .limit(4)
                .collect(Collectors.toList());

        System.out.println(top4HighestPaidEmployees1);
        System.out.println(top4HighestPaidEmployees2);
        System.out.println(top4HighestPaidEmployees3);




    }
}
