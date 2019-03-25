package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class Company extends GenericDomain {

    private String name;
    private String vision;
    private String mission;
    private String address;
    private String phone;
    private String email;
}
