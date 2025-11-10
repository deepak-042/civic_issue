package com.dep.civic_issue.Controller;

import com.dep.civic_issue.Repositories.DepartmentRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class PageController {
    private final DepartmentRepo departmentRepo;

    public PageController(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @GetMapping("/report-issue")
    public String showReportIssue(Model model){
        model.addAttribute("departments",departmentRepo.findAll());
        return "report-issue";
    }

}
