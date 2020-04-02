package org.example;

import org.example.db.EmployeeDb;
import org.example.entity.Employee;

import java.util.List;
import java.util.stream.Stream;

public class  App
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        Employee employee = new Employee("Kevin",38);
        Employee employee1 = new Employee("Tom",34);
        Employee employee2 = new Employee("Jek",43);

        //EmployeeDb.create(employee);
        //EmployeeDb.create(employee1);
        //EmployeeDb.create(employee2);


        EmployeeDb.getAll().stream().forEach(x -> System.out.println(x)); //1sposob
//        List<Employee> employees = EmployeeDb.getAll();
//        for (Employee e : employees){            //2sposob выводит все записи
//            System.out.println(e);
//        }

//        Stream<Employee> employeeStream = employees.stream();
//        employeeStream.filter(x -> x.getName().contains("e")).forEach(x-> System.out.println(x));

        Employee employee3 = new Employee();
        employee3.setId(1);
        employee3.setName("Bob");
        employee3.setAge(33);
//
        EmployeeDb.update(employee3);

//        EmployeeDb.delete(7);
//        EmployeeDb.delete(8);
        //EmployeeDb.delete(5);
    }

}
