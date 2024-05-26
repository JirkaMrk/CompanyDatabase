package cz.uun.companydatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.dtoin.CompanyUpdateDtoIn;
import cz.uun.companydatabase.entity.Company;
import cz.uun.companydatabase.repository.CompanyRepository;

import java.util.Optional;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(CompanyCreateDtoIn dtoIn) {
        Company company = new Company();
        company.setName(dtoIn.getName());
        company.setAddress(dtoIn.getAddress());
        company.setIco(dtoIn.getIco());
        return companyRepository.save(company);
    }

    public Company getCompanyByIco(String ico) {
        Optional<Company> companyOptional = companyRepository.findByIco(ico);
        return companyOptional.orElse(null);
    }

    public Company deleteCompanyByIco(String ico) {
        Optional<Company> companyOptional = companyRepository.findByIco(ico);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            companyRepository.delete(company);
            return company;
        }
        return null;
    }

    public Company updateCompanyByIco(CompanyUpdateDtoIn dtoIn) {
        Optional<Company> companyOptional = companyRepository.findByIco(dtoIn.getIco());
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setName(dtoIn.getName());
            company.setAddress(dtoIn.getAddress());
            company.setIco(dtoIn.getIco());
            return companyRepository.save(company);
        }
        return null;
    }
}
