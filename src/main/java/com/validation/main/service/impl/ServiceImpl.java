package com.validation.main.service.impl;

import com.validation.main.EmployeeRepo;
import com.validation.main.exception.ApiExceptionHandler;
import com.validation.main.model.Employee;
import com.validation.main.service.Servicee;
import com.validation.main.vo.EmployeeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements Servicee {
    private final EmployeeRepo employeeRepo;
    @Override
    public void addEmpl(EmployeeVO employeeVO) {
        if(employeeRepo.existsByNameAndEmail(employeeVO.getName(),employeeVO.getEmail())){
            throw new ApiExceptionHandler("employee exists");
        }else {
            employeeRepo.save(Employee.builder()
                            .name(employeeVO.getName())
                            .email(employeeVO.getEmail())
                    .build());
        }
    }
}
