package com.etaTech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/****************************************************
 *** Created by Fady Fouad on 6/14/2019 at 00:09.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------------------------Lambdas-------------------\n");

        new Thread(()-> {
            System.out.println("Lambda Thread ");
            System.out.println("Lambda Thread again");
         }).start();

        Employee employee3 = new Employee("Fady3",27);
        Employee employee1 = new Employee("Fady1",23);
        Employee employee2 = new Employee("Fady2",25);

        List<Employee> employeeLis = new ArrayList<>();
        employeeLis.add(employee1);
        employeeLis.add(employee2);
        employeeLis.add(employee3);

//        employeeLis.sort(Comparator.comparing(Employee::getName));
        employeeLis.sort(Comparator.comparing(Employee::getAge));

        for (Employee employee :
                employeeLis) {
            System.out.println(employee.getName());
        }

    }
}
class Employee{
    private String name;
    private int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

//    void setName(String name) {
//        this.name = name;
//    }
//
    int getAge() {
        return age;
    }
//
//    void setAge(int age) {
//        this.age = age;
//    }
}