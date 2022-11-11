package com.validation.main.repo;

import com.validation.main.model.Employee;
import com.validation.main.vo.EmployeeVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    boolean existsByEmail(String email);

    @Query("select new com.validation.main.vo.EmployeeVO(e.name,e.email) from Employee e")
    Page<EmployeeVO> findAllEmployee(Pageable pageable);
}
