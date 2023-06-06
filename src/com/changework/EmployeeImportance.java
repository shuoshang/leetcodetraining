package com.changework;

import sun.misc.Queue;

import java.util.*;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        int sum  = 0;
        Employee emp = null;
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        Deque<Employee> deque = new LinkedList<>();
        deque.addLast(map.get(id));
        while(!deque.isEmpty()){
            emp = deque.removeFirst();
            sum += emp.importance;
            for(int i : emp.subordinates){
                deque.addLast(map.get(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        // write your code here
        EmployeeImportance employeeImportance =  new EmployeeImportance();
        List<Employee> employees = new ArrayList<>();

        List<Integer> subordinates1 = new ArrayList<>();
        subordinates1.add(2);
        subordinates1.add(3);
        Employee employee1  = new Employee(1,5,subordinates1);
        employees.add(employee1);

        List<Integer> subordinates2 = new ArrayList<>();
        Employee employee2  = new Employee(2,3,subordinates2);
        employees.add(employee2);

        List<Integer> subordinates3 = new ArrayList<>();
        Employee employee3  = new Employee(3,3,subordinates3);
        employees.add(employee3);

        int n = employeeImportance.getImportance(employees,1);
        System.out.println(n);
    }
}
