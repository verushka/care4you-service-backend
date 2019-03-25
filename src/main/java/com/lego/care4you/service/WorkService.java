package com.lego.care4you.service;

import com.lego.care4you.domain.Work;
import com.lego.care4you.dto.WorkRequestDTO;
import com.lego.care4you.repository.EmployeeRepository;
import com.lego.care4you.repository.PositionRepository;
import com.lego.care4you.repository.WorkRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



@Service
public class WorkService extends GenericService<Work, WorkRequestDTO> {

    private WorkRepository workRepository;

    private EmployeeRepository employeeRepository;

    private PositionRepository positionRepository;

    public WorkService(WorkRepository workRepository, EmployeeRepository employeeRepository, PositionRepository positionRepository) {
        this.workRepository = workRepository;
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Work> findAll() {
        return workRepository.findAll();
    }

    @Override
    public Work findById(String id) {
        return workRepository.findOne(id);
    }

    @Override
    public Work delete(String id) {
        Work work = workRepository.findOne(id);

        workRepository.delete(work);

        return work;
    }

    @Override
    public Work insert(WorkRequestDTO dto) {
        Work work = buildCreateWork(dto);

        workRepository.insert(work);

        return work;
    }

    @Override
    public Work update(String id, WorkRequestDTO dto) {
        Work work = findById(id);

        buildUpdateWork(work, dto);
        workRepository.save(work);

        return work;
    }

    private Work buildCreateWork(WorkRequestDTO dto) {
        Work work = new Work();
        work.setWorkAmount(dto.getWorkAmount());
        work.setWorkCode(dto.getWorkCode());
        work.setEndDate(new Date());
        work.setInitDate(new Date());
        work.setPaymentType(dto.getPaymentType());

        work.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
        work.setPosition(positionRepository.findOne(dto.getPositionId()));

        return work;
    }

    private void buildUpdateWork(Work work, WorkRequestDTO dto) {
        work.setWorkAmount(dto.getWorkAmount());
        work.setWorkCode(dto.getWorkCode());
        work.setPaymentType(dto.getPaymentType());

        work.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
        work.setPosition(positionRepository.findOne(dto.getPositionId()));
    }
}
