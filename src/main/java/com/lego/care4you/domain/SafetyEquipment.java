package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class SafetyEquipment extends GenericDomain {

    private String code;
    private String name;
    private String description;
    private Integer stock;

    private Byte[] image;
}
