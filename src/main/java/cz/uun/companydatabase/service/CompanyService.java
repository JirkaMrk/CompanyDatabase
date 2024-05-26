package cz.uun.companydatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.dtoin.CompanyUpdateDtoIn;
import cz.uun.companydatabase.entity.Company;
import cz.uun.companydatabase.repository.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(CompanyCreateDtoIn dtoIn) {
        Company company = companyRepository.save(new Company());
        return company;
    }
    //TODO: Fix
    public Company getCompanyByIco(String ico) {
        return companyRepository.findByIco(ico);
    }

    public Company deleteCompanyByIco(String ico) {
        Company company = companyRepository.findByIco(ico);
        companyRepository.delete(company);
        return company;
    }

    public Company updateCompanyByIco(CompanyUpdateDtoIn dtoIn) {
        Company company = companyRepository.findByIco(dtoIn.getIco());
        company.setIco(dtoIn.getIco());
        company.setName(dtoIn.getName());
        companyRepository.save(company);
        return company;
    }
}
