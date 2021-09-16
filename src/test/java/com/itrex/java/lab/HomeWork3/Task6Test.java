package com.itrex.java.lab.HomeWork3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    private Employees employees1;
    private Employees employees2;
    private Employees employees3;
    private Department department1;
    private Department department2;
    private Department department3;

    @BeforeEach
    void createEnties() {
        employees1 = new Employees();
        employees1.setName("William");
        employees1.setSalary(20000);
        employees2 = new Employees();
        employees2.setName("Sophia");
        employees2.setSalary(10000);
        employees3 = new Employees();
        employees3.setName("John");
        employees3.setSalary(50000);

        department1 =new Department();
        department1.setCode("111-1");
        department1.setEmployees(List.of(employees1,employees2));
        department2 =new Department();
        department2.setCode("222-1");
        department2.setEmployees(List.of(employees3));
        department3 =new Department();
        department3.setCode("111-2");
        department3.setEmployees(List.of(employees1,employees2,employees3));
    }

    @Test
    void calcNumberOfEmployeesTest() {
        assertEquals(Task6.calcNumberOfEmployees(List.of(department1,department2,department3),20000L),3);
    }

    @Test
    void calcNumberOfEmployeesForNullDeportmentTest() {
        assertEquals(Task6.calcNumberOfEmployees(null,20000L),-1);
    }

    @Test
    void calcNumberOfEmployeesForThresholdNegativeTest() {
        assertEquals(Task6.calcNumberOfEmployees(List.of(department1,department2,department3),-20000L),-1);
    }

    @Test
    void calcNumberOfEmployeesForThresholdEmptyTest() {
        assertEquals(Task6.calcNumberOfEmployees(List.of(department1,department2,department3),0),5);
    }

    @Test
    void calcNumberOfEmployeesForWrongCodeTest() {
        assertEquals(Task6.calcNumberOfEmployees(List.of(department2),0),0);
    }

}