package com.validation.main.controller;

import com.validation.main.service.Servicee;
import com.validation.main.vo.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

//@Validated
@RestController
@RequiredArgsConstructor
public class Controller {
    private final Servicee servicee;

    @PostMapping("/add")
  public ResponseEntity<List<String>> setEmployee(@RequestBody @Valid  Employee employee){
      return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
}
