package com.dheeraj.learning.orm.hibernate.domain;

/**
 * Created by dgopali on 8/23/2015.
 */
public class Employee {
    private String id;
    private String name;
    private int age;
    private int salary;

    public Employee() {}
    public Employee(String name, int age, int salary ) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
