package com.dep.civic_issue.Controller;

import com.dep.civic_issue.Entity.IssueReport;
import com.dep.civic_issue.Service.IssueService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/issue")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<IssueReport> createIssue(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam long department_id,
            @RequestParam long user_id,
            @RequestParam MultipartFile imgfile
            ){
        IssueReport issueReport  = issueService.saveIssue(title,description,latitude,longitude,department_id,user_id,imgfile);
        return ResponseEntity.ok(issueReport);

    }
}
