package com.ziroh.legalvault.datastorage;

public class Employee {

    private String employeeName;
    private String employeeEmailID;
    private int employeeDeleteSymbol;

    public Employee(String name, String email_id, int delete) {
        this.employeeName = name;
        this.employeeEmailID = email_id;
        this.employeeDeleteSymbol = delete;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmailID() {
        return employeeEmailID;
    }

    public void setEmployeeEmailID(String employeeEmailID) {
        this.employeeEmailID = employeeEmailID;
    }

    public int getEmployeeDeleteSymbol() {
        return employeeDeleteSymbol;
    }

    public void setEmployeeDeleteSymbol(int employeeDeleteSymbol) {
        this.employeeDeleteSymbol = employeeDeleteSymbol;
    }

}
