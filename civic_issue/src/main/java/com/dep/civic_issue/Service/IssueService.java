package com.dep.civic_issue.Service;

import com.dep.civic_issue.Entity.Department;
import com.dep.civic_issue.Entity.IssueReport;
import com.dep.civic_issue.Entity.User;
import com.dep.civic_issue.Repositories.DepartmentRepo;
import com.dep.civic_issue.Repositories.IssueReportRepo;
import com.dep.civic_issue.Repositories.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class IssueService {
    private final IssueReportRepo issueReportRepo;
    private final DepartmentRepo departmentRepo;
    private final UserRepo userRepo;

    public IssueService(IssueReportRepo issueReportRepo, DepartmentRepo departmentRepo, UserRepo userRepo) {
        this.issueReportRepo = issueReportRepo;
        this.departmentRepo = departmentRepo;
        this.userRepo = userRepo;
    }
    private final Path root = Paths.get("uploads");
    public IssueReport saveIssue(String title , String description , double latitude , double longitude ,
                                 long department_id , long user_id , MultipartFile img_file){
        try{
            if (!Files.exists(root)){
                Files.createDirectories(root);
            }
            String filename = img_file.getOriginalFilename();
            Path filepath = root.resolve(filename);
            Files.copy(img_file.getInputStream() , filepath , StandardCopyOption.REPLACE_EXISTING);
            Department department = departmentRepo.findById(department_id).
                    orElseThrow(() -> new RuntimeException("dept not found"));
            User user = userRepo.findById(user_id).orElseThrow(() -> new RuntimeException("user not found"));
            IssueReport issueReport = new IssueReport();
            issueReport.setTitle(title);
            issueReport.setDepartment(department);
            issueReport.setLatitude(latitude);
            issueReport.setLongitude(longitude);
            issueReport.setUser(user);
            issueReport.setDescription(description);
            issueReport.setImagePath(filepath.toString());

            return issueReportRepo.save(issueReport);

        } catch (IOException e) {
            throw new RuntimeException("file not uploaded" + e);
        }
    }
}
