package com.corejavaconcept.comparable;

import com.corejavaconcept.comparable.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTest {

    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(new Employee(22, "Name", 9789), new Employee(21, "Deepake", 876), new Employee(43, "jaspreet", 123));

        System.out.println("Before Sort By Id:"+list);

        Collections.sort(list);

        System.out.println("After Sort By Id:"+list);

    }
}
