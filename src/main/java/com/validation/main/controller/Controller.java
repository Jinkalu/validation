package com.validation.main.controller;

import com.validation.main.service.Servicee;
import com.validation.main.vo.EmployeeRequest;
import com.validation.main.vo.EmployeeVO;
import com.validation.main.vo.ResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("emp/")
@RequiredArgsConstructor
public class Controller {
    private final Servicee servicee;

    @PostMapping("add")
    public ResponseEntity<ResponseVO> setEmployee(@RequestBody @Valid EmployeeVO employeeVO) {
        servicee.addEmpl(employeeVO);
        return ResponseEntity.accepted().body(ResponseVO.builder()
                .status("ACCEPTED")
                .message(List.of("ACCEPTED"))
                .build());
    }

    @PostMapping("get-all")
    public ResponseEntity<Map<String, Object>> getAllEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok().body(servicee.getAllEmployee(employeeRequest));
    }
}
