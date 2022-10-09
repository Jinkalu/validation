package com.validation.main;

import com.validation.main.model.Employee;
import com.validation.main.vo.EmployeeVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    boolean existsByNameAndEmail(String name, String email);
}
