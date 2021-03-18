package com.dheeraj.learning.af.lamda;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        UnaryOperator<SamplePojo> unaryOperator =
                (person) -> { person.name = "New Name"; return person; };
        Map<String, String> map = new HashMap<>();
        map.put("1","10");
        map.put("2","20");
        map.put("3","30");

        List<Employee> temp = new ArrayList<>();
        temp.add(new Employee("test",10));
        temp.add(new Employee("test1",20));
        temp.add(new Employee("test2",33));
        temp.add(new Employee("test3",40));

        Optional<Employee> emp = temp.stream().min(Comparator.comparing(Employee::getAge));
        System.out.println(emp);

        temp.stream().filter(e->e.getAge()%2==0).forEach(System.out::println);

    }
}

class Employee {
    String name;
    int age;

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
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
