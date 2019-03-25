package com.lego.care4you.service;

import com.lego.care4you.domain.Rule;
import com.lego.care4you.dto.RulesRequestDTO;
import com.lego.care4you.repository.CompanyRepository;
import com.lego.care4you.repository.RuleRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RuleService extends GenericService<Rule, RulesRequestDTO> {

    private RuleRepository ruleRepository;

    private CompanyRepository companyRepository;

    public RuleService(RuleRepository ruleRepository, CompanyRepository companyRepository) {
        this.ruleRepository = ruleRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Rule> findAll() {
        return ruleRepository.findAll();
    }

    @Override
    public Rule findById(String id) {
        return ruleRepository.findOne(id);
    }

    @Override
    public Rule delete(String id) {
        Rule rule = findById(id);
        ruleRepository.delete(rule);
        return rule;
    }

    @Override
    public Rule insert(RulesRequestDTO dto) {
        Rule rule = buildCreateRules(dto);
        rule = ruleRepository.insert(rule);

        return rule;
    }

    @Override
    public Rule update(String id, RulesRequestDTO dto) {
        Rule rule = findById(id);
        buildUpdateRules(rule, dto);
        ruleRepository.save(rule);

        return rule;
    }

    private Rule buildCreateRules(RulesRequestDTO dto) {
        Rule rule = new Rule();
        rule.setName(dto.getName());
        rule.setDescription(dto.getDescription());
        rule.setCompany(companyRepository.findOne(dto.getCompanyId()));

        return rule;
    }

    private void buildUpdateRules(Rule rule, RulesRequestDTO dto) {
        rule.setName(dto.getName());
        rule.setDescription(dto.getDescription());
        rule.setCompany(companyRepository.findOne(dto.getCompanyId()));
    }
}
