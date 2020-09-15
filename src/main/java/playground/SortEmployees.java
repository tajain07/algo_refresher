package playground;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortEmployees {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 31);
        Employee employee2 = new Employee("Pink", 39);
        Employee employee3 = new Employee("Morris", 27);

        List <Employee> employees = Arrays.asList(employee1, employee2, employee3);
        System.out.println(employees);

        Collections.sort(employees, new ComparatorImpl());
        System.out.println(employees);

    }
}
