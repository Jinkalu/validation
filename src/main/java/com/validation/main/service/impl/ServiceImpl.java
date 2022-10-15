package com.validation.main.service.impl;

import com.validation.main.EmployeeRepo;
import com.validation.main.exception.ApiExceptionHandler;
import com.validation.main.model.Employee;
import com.validation.main.service.Servicee;
import com.validation.main.vo.EmployeeRequest;
import com.validation.main.vo.EmployeeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    private void requestValidation(EmployeeVO employeeVO) {
        if (employeeRepo.existsByEmail(employeeVO.getEmail())) {
            throw new ApiExceptionHandler("invalid.email",
                    "an employee exists with given email id : " + employeeVO.getEmail());
        }
    }
    @Override
    public Map<String, Object> getAllEmployee(EmployeeRequest employeeRequest) {
        Pageable pageable;
        if (Objects.nonNull(employeeRequest.getSortProperty()) && !(employeeRequest.getSortProperty().isEmpty())) {
            pageable = PageRequest.of(employeeRequest.getPageNumber() - 1, employeeRequest.getPageSize(),
                    Sort.by(Sort.Direction.fromString(employeeRequest.getSortOrder()), employeeRequest.getSortProperty()));
        } else {
            pageable = PageRequest.of(employeeRequest.getPageNumber() - 1, employeeRequest.getPageSize(), Sort.Direction.ASC, "name");
        }
        Page<EmployeeVO> employeeVOPage = employeeRepo.findAllEmployee(pageable);
        Map<String, Object> details = new HashMap<>();
        details.put("employees", employeeVOPage.getContent());
        details.put("pageNumber", employeeVOPage.getNumber() + 1);
        details.put("totalPages", employeeVOPage.getTotalPages());
        return details;
    }
}
