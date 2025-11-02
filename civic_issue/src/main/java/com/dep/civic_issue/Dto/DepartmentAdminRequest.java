package com.dep.civic_issue.Dto;

public class DepartmentAdminRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private Long departmentId;
//    private String Department;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDepartment() {
//        return Department;
//    }
//
//    public void setDepartment(String department) {
//        this.Department = department;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
