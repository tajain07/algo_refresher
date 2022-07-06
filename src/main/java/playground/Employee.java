package playground;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    String name;
    int age;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(Employee o) {
        //final int age = o.getAge() - this.getAge();
        //System.out.println("o " + o + ", this " + this + ", age " + age);


        final int age = this.getAge() - o.getAge();
        System.out.println("this " + this + ", o " + o + ", age " + age);
        return age;
    }
}
