package com.lego.care4you.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PositionRequestDTO {

    private String code;
    private String name;
    private String description;

    private List<String> abilitiesId;
    private List<String> equipmentsId;
}
