package com.validation.main.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @NotEmpty(message = "name can not be empty")
    private String name;
    @Email(message = "invalid email",regexp = ".*.@...*")
    private String email;
}