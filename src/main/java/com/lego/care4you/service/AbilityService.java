package com.lego.care4you.service;

import com.lego.care4you.domain.Ability;
import com.lego.care4you.dto.AbilityRequestDTO;
import com.lego.care4you.repository.AbilityRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AbilityService extends GenericService<Ability, AbilityRequestDTO> {

    private AbilityRepository abilityRepository;

    public AbilityService(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    @Override
    public List<Ability> findAll() {
        return abilityRepository.findAll();
    }

    @Override
    public Ability findById(String id) {
        return abilityRepository.findOne(id);
    }

    @Override
    public Ability delete(String id) {
        Ability ability = findById(id);
        abilityRepository.delete(ability);
        return ability;
    }

    @Override
    public Ability insert(AbilityRequestDTO dto) {
        Ability ability = buildCreateAbility(dto);
        ability = abilityRepository.insert(ability);
        return ability;
    }

    @Override
    public Ability update(String id, AbilityRequestDTO dto) {
        Ability ability = findById(id);
        buildUpdateAbility(ability, dto);
        ability = abilityRepository.save(ability);
        return ability;
    }

    private Ability buildCreateAbility(AbilityRequestDTO dto) {
        Ability ability = new Ability();
        setAbilityInformation(dto, ability);

        return ability;
    }

    private void buildUpdateAbility(Ability ability, AbilityRequestDTO dto) {
        setAbilityInformation(dto, ability);
    }

    private void setAbilityInformation(AbilityRequestDTO dto, Ability ability) {
        ability.setName(dto.getName());
        ability.setDescription(dto.getDescription());
    }
}
