package com.validation.main.mapper;

import com.validation.main.model.Employee;
import com.validation.main.vo.EmployeeVO;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

public class ServiceMapper {
    public static Map<String, Object> employeeListMapper(Page<EmployeeVO> employeeVOPage){
        Map<String, Object> details = new HashMap<>();
        details.put("employees", employeeVOPage.getContent());
        details.put("pageNumber", employeeVOPage.getNumber() + 1);
        details.put("totalPages", employeeVOPage.getTotalPages());
        return details;
    }
    public static Employee employeeSaveMapper(EmployeeVO employeeVO){
        return Employee.builder()
                .name(employeeVO.getName())
                .email(employeeVO.getEmail())
                .build();
    }

    private ServiceMapper() {
    }
}
