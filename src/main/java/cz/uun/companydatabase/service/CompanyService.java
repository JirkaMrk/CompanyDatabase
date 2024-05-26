package cz.uun.companydatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.entity.Company;
import cz.uun.companydatabase.repository.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    public Company create(CompanyCreateDtoIn dtoIn) {
        Company company = companyRepository.save(new Company());
        return company;
    }
}
