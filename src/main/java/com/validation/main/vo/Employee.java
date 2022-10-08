package com.validation.main.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @NotEmpty
    @Pattern(message = "invalid format : format must be name@accountNumber ",
            regexp = "^[a-zA-Z(\\d)_.+-]+@(\\d)*$")
    private String name;
    @Email(message = "invalid email",
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z(\\d)-]+\\.[a-zA-Z(\\d)-.]+$")
    private String email;
}
