package cz.uun.companydatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.dtoin.CompanyUpdateDtoIn;
import cz.uun.companydatabase.entity.Company;
import cz.uun.companydatabase.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("")
    public ResponseEntity<Company> createCompany(@RequestBody CompanyCreateDtoIn dtoIn) {
        Company company = companyService.createCompany(dtoIn);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @GetMapping("/{ico}")
    public ResponseEntity<Company> getCompanyByIco(@PathVariable String ico) {
        Company company = companyService.getCompanyByIco(ico);
        return company != null ? new ResponseEntity<>(company, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{ico}")
    public ResponseEntity<Company> deleteCompanyByIco(@PathVariable String ico) {
        Company company = companyService.deleteCompanyByIco(ico);
        return company != null ? new ResponseEntity<>(company, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{ico}")
    public ResponseEntity<Company> updateCompanyByIco(@RequestBody CompanyUpdateDtoIn dtoIn) {
        Company company = companyService.updateCompanyByIco(dtoIn);
        return company != null ? new ResponseEntity<>(company, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
