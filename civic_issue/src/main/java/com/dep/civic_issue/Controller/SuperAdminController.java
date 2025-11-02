package com.dep.civic_issue.Controller;

import com.dep.civic_issue.Dto.DepartmentAdminRequest;
import com.dep.civic_issue.Entity.Department;
import com.dep.civic_issue.Entity.Role;
import com.dep.civic_issue.Entity.User;
import com.dep.civic_issue.Repositories.DepartmentRepo;
import com.dep.civic_issue.Repositories.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/super-admin")
public class SuperAdminController {

    private final UserRepo userRepo;
    private final DepartmentRepo departmentRepo;
    private final PasswordEncoder passwordEncoder;

    public SuperAdminController(UserRepo userRepo, DepartmentRepo departmentRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.departmentRepo = departmentRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/create-dept-admin")
    public String showAdminForm(Model model){
        model.addAttribute("request" , new DepartmentAdminRequest());
        model.addAttribute("departments" , departmentRepo.findAll());
        return "create-dept-admin";
    }

    @PostMapping(value = "/create-dept-admin" )
    public ResponseEntity<?> createDepartmentAdmin(@ModelAttribute DepartmentAdminRequest deptAdminRequest,
                                                Model model){
//        User superAdmin = userRepo.findByUsername(authentication.getName())
//                .orElseThrow(() -> new RuntimeException("user not found"));
//        if (superAdmin.getRole() != Role.Super_admin){
//            return ResponseEntity.status(HttpStatus.FORBIDDEN)
//                    .body("authentication failed super admin not recognised");
//        }
        Department dept = departmentRepo.findById(deptAdminRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));


//        User deptAdmin = new User();
//        deptAdmin.setName(request.getName());
//        deptAdmin.setUsername(request.getUsername());
//        deptAdmin.setEmail(request.getEmail());
//        deptAdmin.setPassword(passwordEncoder.encode(request.getPassword()));
//        deptAdmin.setRole(Role.Dept_admin);
//        deptAdmin.setDepartment(dept);

        User deptAdmin = new User();
        deptAdmin.setName(deptAdminRequest.getName());
        deptAdmin.setUsername(deptAdminRequest.getUsername());
        deptAdmin.setEmail(deptAdminRequest.getEmail());
        deptAdmin.setPassword(passwordEncoder.encode(deptAdminRequest.getPassword()));
        deptAdmin.setRole(Role.Dept_admin);
        deptAdmin.setDepartment(dept);
        userRepo.save(deptAdmin);

        model.addAttribute("departments", departmentRepo.findAll());
        model.addAttribute("successMessage", "Department admin created successfully!");
        model.addAttribute("request", new DepartmentAdminRequest());
        return ResponseEntity.ok("dept admin added");
    }



}
