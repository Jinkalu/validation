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
public class EmployeeVO {
    @NotEmpty(message = "name can not be empty")
    private String name;
    @Email(message = "invalid email id",
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z(\\d)-]+\\.[a-zA-Z(\\d)-.]+$")
    private String email;
}
