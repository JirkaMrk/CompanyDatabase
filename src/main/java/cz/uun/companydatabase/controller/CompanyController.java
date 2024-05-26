package cz.uun.companydatabase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<Company> create(@RequestBody CompanyCreateDtoIn dtoIn) {
        Company company = companyService.create(dtoIn);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }
}