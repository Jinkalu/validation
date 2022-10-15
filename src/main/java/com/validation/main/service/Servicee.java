package com.validation.main.service;

import com.validation.main.vo.EmployeeRequest;
import com.validation.main.vo.EmployeeVO;


import java.util.Map;

public interface Servicee {
    void addEmpl(EmployeeVO employeeVO);
    Map<String,Object> getAllEmployee(EmployeeRequest employeeRequest);
}
