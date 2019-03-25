package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class Assignment extends GenericDomain {

    @DBRef
    private OrganizationChart organizationChart;

    @DBRef
    private Department department;

    @DBRef
    private Position position;
}
