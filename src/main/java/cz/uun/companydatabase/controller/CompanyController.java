package cz.uun.companydatabase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.entity.Company;
import cz.uun.companydatabase.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;
    
    public CompanyController() {
        this.companyService = new CompanyService();
    }

    @PostMapping("")
    public ResponseEntity<Company> createCompany(@RequestBody CompanyCreateDtoIn dtoIn) {
        Company company = companyService.createCompany(dtoIn);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @GetMapping("/{ico}")
    public ResponseEntity<Company> getCompanyByIco(@RequestBody String ico) {
        Company company = companyService.getCompanyByIco(ico);
        return company != null ? new ResponseEntity<>(company, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{ico}")
    public ResponseEntity<Company> deleteCompanyByIco(@RequestBody String ico) {
        Company company = companyService.deleteCompanyByIco(ico);
        return company != null ? new ResponseEntity<>(company, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //TODO: Fix
    @PutMapping("/{ico}")
    public ResponseEntity<Company> updateCompanyByIco(@RequestBody CompanyCreateDtoIn dtoIn) {
        Company company = companyService.updateCompanyByIco(dtoIn);
        return company != null ? new ResponseEntity<>(company, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
