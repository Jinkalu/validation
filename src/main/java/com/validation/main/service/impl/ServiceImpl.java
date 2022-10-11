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
        requestValidation(employeeVO);
        employeeRepo.save(Employee.builder()
                            .name(employeeVO.getName())
                            .email(employeeVO.getEmail())
                    .build());
    }
    private void requestValidation(EmployeeVO employeeVO){
        if(employeeRepo.existsByEmail(employeeVO.getEmail())){
            throw new ApiExceptionHandler("invalid.email",
                    "an employee exists with given email id : "+employeeVO.getEmail());
        }
    }
}
