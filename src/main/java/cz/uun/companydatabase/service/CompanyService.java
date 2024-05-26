package cz.uun.companydatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;

import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.dtoin.CompanyUpdateDtoIn;
import cz.uun.companydatabase.dtoin.AresResponseDto;
import cz.uun.companydatabase.entity.Company;
import cz.uun.companydatabase.repository.CompanyRepository;

import java.util.List;
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
        company.setIco(dtoIn.getIco());
        return companyRepository.save(company);
    }

    public Company getCompanyByIco(String ico) {
        Optional<Company> companyOptional = companyRepository.findByIco(ico);
        return companyOptional.orElse(null);
    }

    public List<Company> searchCompanyByName(String name) {
        List<Company> companyList = companyRepository.findByNameContaining(name);
        return companyList;
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
    
    public Company getCompanyByIcoFromAres(String ico) {
        String url = UriComponentsBuilder.fromHttpUrl("https://ares.gov.cz/ekonomicke-subjekty-v-be/rest/ekonomicke-subjekty-vr/{ico}")
                .buildAndExpand(ico)
                .toUriString();
        ResponseEntity<AresResponseDto> response = restTemplate.getForEntity(url, AresResponseDto.class);
        if (response != null && response.getBody() != null) {
            AresResponseDto aresData = response.getBody();
            Company company = new Company();
            company.setIco(aresData.getIco());
            return company;
        }
        return null;
    }
}
