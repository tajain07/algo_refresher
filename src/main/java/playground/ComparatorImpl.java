package playground;

import java.util.Comparator;

public class ComparatorImpl implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        /*if (o1.getAge() > o2.getAge())
            return -1;

        return +1;*/
        final int age = o1.getAge() - o2.getAge();
        System.out.println("o1.getAge() " + o1 + ", o2.getAge() " + o2 + ", age " + age);
        return age;
    }
}
