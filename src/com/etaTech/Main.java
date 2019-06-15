package com.etaTech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface IUpperConcat {
    String upperAndConcat(String s1, String s2);
}

/****************************************************
 *** Created by Fady Fouad on 6/14/2019 at 00:09.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------------------------Lambdas-------------------\n");

        Employee employee3 = new Employee("Fady3", 27);
        Employee employee1 = new Employee("Fady1", 23);
        Employee employee2 = new Employee("Fady2", 25);

        List<Employee> employeeLis = new ArrayList<>();
        employeeLis.add(employee1);
        employeeLis.add(employee2);
        employeeLis.add(employee3);

        employeeLis.sort(Comparator.comparing(Employee::getName));

        for (Employee employee :
                employeeLis) {
            System.out.println(employee.getName());
            new Thread(()-> System.out.println(employee.getAge())).start();
        }
        System.out.println("----------------------------------");
//        Employee employee ;
        for (int i = 0; i < employeeLis.size(); i++) {
            Employee employee = employeeLis.get(i);
            System.out.println(employee.getName());
            new Thread(()-> System.out.println(employee.getAge())).start();

        }

        TestClass testClass = new TestClass();
        String str = testClass.doSomting();
        System.out.println(str);
        testClass.printValue();

    }

    static String doStringStuff(IUpperConcat concat) {
        return concat.upperAndConcat("S1", " S2");
    }
}

class Employee {
    private String name;
    private int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

}

class TestClass {
    String doSomting() {
        System.out.println("Test Class Name : " + getClass().getSimpleName());
        return Main.doStringStuff((String s1, String s2) -> {
            System.out.println("Anon Class Name : " + getClass().getSimpleName());
            return s1 + " " + s2;
        });
    }

    void printValue(){
        int i;
        i = 0;
        Runnable runnable = () -> {
            try{
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Value = "+i);
        };
        new Thread(runnable).start();
    }
}