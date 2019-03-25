package com.lego.care4you.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeRequestDTO {

    private String CI;
    private String firstName;
    private String lastName;
    private String address;
    private long phone;
    private String email;
}