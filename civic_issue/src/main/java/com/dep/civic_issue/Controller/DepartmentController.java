package com.dep.civic_issue.Controller;

import com.dep.civic_issue.Entity.Department;
import com.dep.civic_issue.Repositories.DepartmentRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {

    private final DepartmentRepo departmentRepo;

    public DepartmentController( DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;

    }
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> departments = departmentRepo.findAll();
        return ResponseEntity.ok(departments);
    }
}
