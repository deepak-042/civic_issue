package com.dep.civic_issue.Repositories;

import com.dep.civic_issue.Entity.IssueReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueReportRepo extends JpaRepository<IssueReport,Long> {
}
