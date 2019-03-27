package com.lego.care4you.service;

import com.lego.care4you.domain.Ability;
import com.lego.care4you.domain.Position;
import com.lego.care4you.domain.SafetyEquipment;
import com.lego.care4you.dto.PositionRequestDTO;
import com.lego.care4you.repository.AbilityRepository;
import com.lego.care4you.repository.PositionRepository;
import com.lego.care4you.repository.SafetyEquipmentRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PositionService extends GenericService<Position, PositionRequestDTO> {

    private PositionRepository positionRepository;

    private AbilityRepository abilityRepository;

    private SafetyEquipmentRepository safetyEquipmentRepository;

    public PositionService(PositionRepository positionRepository, AbilityRepository abilityRepository, SafetyEquipmentRepository safetyEquipmentRepository) {
        this.positionRepository = positionRepository;
        this.abilityRepository = abilityRepository;
        this.safetyEquipmentRepository = safetyEquipmentRepository;
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(String id) {
        return positionRepository.findOne(id);
    }

    @Override
    public Position delete(String id) {
        Position position = findById(id);
        positionRepository.delete(position);

        return position;
    }

    @Override
    public Position insert(PositionRequestDTO dto) {
        Position position = buildCreatePosition(dto);
        position = positionRepository.insert(position);

        return position;
    }

    @Override
    public Position update(String id, PositionRequestDTO dto) {
        Position position = findById(id);
        buildUpdatePosition(position, dto);

        positionRepository.save(position);
        return position;
    }

    private Position buildCreatePosition(PositionRequestDTO dto) {
        Position position = new Position();
        setPositionInformation(dto, position);

        return position;
    }

    private void buildUpdatePosition(Position position, PositionRequestDTO dto) {
        setPositionInformation(dto, position);
    }

    private void setPositionInformation(PositionRequestDTO dto, Position position) {
        position.setCode(dto.getCode());
        position.setName(dto.getName());
        position.setDescription(dto.getDescription());
        position.setAbilities(getAbilities(dto.getAbilitiesId()));
        position.setEquipments(getEquipments(dto.getEquipmentsId()));
    }

    private List<Ability> getAbilities(List<String> abilities) {
        List<Ability> response = new ArrayList<>();

        for (String abilityId : abilities) {
            response.add(abilityRepository.findOne(abilityId));
        }
        return response;
    }

    private List<SafetyEquipment> getEquipments(List<String> equipments) {
        List<SafetyEquipment> response = new ArrayList<>();

        for (String equipmentId : equipments) {
            response.add(safetyEquipmentRepository.findOne(equipmentId));
        }
        return response;
    }
}
