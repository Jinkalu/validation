package com.validation.main.data;

import com.github.javafaker.Faker;
import com.validation.main.model.Employee;
import com.validation.main.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class SampleData implements CommandLineRunner {

    private final EmployeeRepo employeeRepo;
    private final Logger logger= LoggerFactory.getLogger(SampleData.class);
    private final Faker faker;

    @Override
    public void run(String... args) {
        // 50 employee
       List<Employee> employees= IntStream.rangeClosed(1,50)
                .mapToObj(e-> Employee.builder()
                        .name(faker.name().name())
                        .email(faker.internet().emailAddress())
                        .build()).collect(Collectors.toList());

       employeeRepo.saveAll(employees);
    }

}
