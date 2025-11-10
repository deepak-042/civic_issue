package com.dep.civic_issue.Repositories;

import com.dep.civic_issue.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {

}
