package com.lego.care4you.service;

import com.lego.care4you.domain.Position;
import com.lego.care4you.dto.PositionRequestDTO;
import com.lego.care4you.repository.PositionRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PositionService extends GenericService<Position, PositionRequestDTO> {

    private PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
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
        position.setCode(dto.getCode());
        position.setName(dto.getName());
        position.setDescription(dto.getDescription());

        return position;
    }

    private void buildUpdatePosition(Position position, PositionRequestDTO dto) {
        position.setCode(dto.getCode());
        position.setName(dto.getName());
        position.setDescription(dto.getDescription());
    }
}
