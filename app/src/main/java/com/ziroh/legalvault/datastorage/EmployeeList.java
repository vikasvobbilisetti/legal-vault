package com.ziroh.legalvault.datastorage;

import com.ziroh.legalvault.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    public static List<Employee> employeeList = new ArrayList<>();;

    public static void addEmployee(String name, String email) {
        employeeList.add(new Employee(name, email, R.drawable.delete_symbol));
    }

    public static int getNumberOfEmployees() {
        return employeeList.size();
    }

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static String get_id(String employee){
        for(Employee emp : employeeList) {
            if(emp.getEmployeeName().compareTo(employee)==0) {
                return emp.getEmployeeEmailID();
            }
        }
        return null;
    }
}

