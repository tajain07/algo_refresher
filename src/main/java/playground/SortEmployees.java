package playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortEmployees {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 31);
        Employee employee2 = new Employee("Pink", 39);
        //Employee employee2_1 = new Employee("Fred", 27);
        //Employee employee3 = new Employee("Morris", 27);
        Employee employee4 = new Employee("Jane", 27);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        //employees.add(employee2_1);
       // employees.add(employee3);
        employees.add(employee4);
        System.out.println(employees);

        Collections.sort(employees);
        System.out.println(employees);

    }
}
