package com.lego.care4you.repository;

import com.lego.care4you.domain.SafetyEquipment;
import com.lego.care4you.repository.bootstrap.GenericRepository;

import java.util.Date;
import java.util.List;


public interface SafetyEquipmentRepository extends GenericRepository<SafetyEquipment> {

    List<SafetyEquipment> findSafetyEquipmentsByCreatedDateOrderByCreatedDateDesc(Date createdDate);
}
