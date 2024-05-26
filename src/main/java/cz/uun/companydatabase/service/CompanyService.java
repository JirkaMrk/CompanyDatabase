package cz.uun.companydatabase.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.model.CompanyModel;
import cz.uun.companydatabase.repository.CompanyRepository;

@Service
public class CompanyService {
    
    private CompanyRepository companyRepository;

    public CompanyService() {
        // try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
        //     this.companyRepository = context.getBean(CompanyRepository.class);
        // }
        try {
            this.companyRepository = new CompanyRepository();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CompanyModel create(CompanyCreateDtoIn dtoIn) {
        CompanyModel company = companyRepository.create(dtoIn);
        return company;
    }
}
