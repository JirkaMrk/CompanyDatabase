package cz.uun.companydatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.dtoin.CompanyUpdateDtoIn;
import cz.uun.companydatabase.dtoin.AresResponseDto;
import cz.uun.companydatabase.entity.Company;
import cz.uun.companydatabase.repository.CompanyRepository;

import java.util.Optional;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Company createCompany(CompanyCreateDtoIn dtoIn) {
        Company company = new Company();
        company.setName(dtoIn.getName());
        company.setAddress(dtoIn.getAddress());
        company.setPhoneNumber(dtoIn.getPhoneNumber());
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
            company.setPhoneNumber(dtoIn.getPhoneNumber());
            company.setIco(dtoIn.getIco());
            return companyRepository.save(company);
        }
        return null;
    }
    
    public Company getCompanyByIcoFromAres(String url){
        AresResponseDto aresResponse = restTemplate.getForObject(url, AresResponseDto.class);
        return null;
    } 
}
