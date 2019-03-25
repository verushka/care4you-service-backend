package com.lego.care4you.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DepartmentRequestDTO {

    private String code;
    private String name;
    private String description;

    private String companyId;
}
