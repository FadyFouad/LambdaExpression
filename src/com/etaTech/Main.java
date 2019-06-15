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

//        new Thread(()-> System.out.println("\nOne Line Lambda "+Thread.currentThread().getName())).start();
//
//        new Thread(()-> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("Lambda Thread ");
//            System.out.println("Lambda Thread again");
//         }).start();



        Employee employee3 = new Employee("Fady3",27);
        Employee employee1 = new Employee("Fady1",23);
        Employee employee2 = new Employee("Fady2",25);

        List<Employee> employeeLis = new ArrayList<>();
        employeeLis.add(employee1);
        employeeLis.add(employee2);
        employeeLis.add(employee3);

        employeeLis.sort(Comparator.comparing(Employee::getName));


        for (Employee employee :
                employeeLis) {
            System.out.println(employee.getAge());
        }
//        String s = doStringStuff(((s1,s2)->{
//            String s3 = s1.toUpperCase()+", "+s2.toUpperCase();
//            return s3;
//        }),employeeLis.get(0).getName(),employeeLis.get(1).getName());
//
//        System.out.println(s);

        TestClass testClass = new TestClass();
        String str = testClass.doSomting();
        System.out.println(str);

    }
    static String doStringStuff(IUpperConcat concat, String s1, String s2){
        return concat.upperAndConcat(s1,s2);
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

interface IUpperConcat{
    String upperAndConcat(String s1 , String s2);
}

class TestClass{
    String doSomting(){
//        return Main.doStringStuff((String s1, String s2)->s1+" "+s2,"S1"," S2");
        System.out.println("Test Class Name : "+getClass().getSimpleName());
        return Main.doStringStuff((String s1, String s2)->{
            System.out.println("Anon Class Name : "+getClass().getSimpleName());
            return s1+" "+s2;
        },"S1"," S2");

//        return Main.doStringStuff(new IUpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("Anon Class Name : "+getClass().getSimpleName());
//                return s1+" "+s2;
//            }
//        },"s1 ","s2");

    }
}