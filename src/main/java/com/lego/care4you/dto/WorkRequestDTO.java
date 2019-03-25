package com.lego.care4you.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class WorkRequestDTO {
    private String workAmount;
    private String workCode;
    private String paymentType;

    private String positionId;
    private String employeeId;
}