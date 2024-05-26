package cz.uun.companydatabase.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import cz.uun.companydatabase.dtoin.CompanyCreateDtoIn;
import cz.uun.companydatabase.model.CompanyModel;

@Repository
public class CompanyRepository {

    // @Value("${postgres.url}")
    // private String postgresUrl;
    private Connection conn;
    
    // public CompanyRepository(@Value("${postgres.url}") String postgresUrl) throws SQLException {
    public CompanyRepository() throws SQLException {
        this.conn = DriverManager.getConnection("");
    }

    public CompanyModel create(CompanyCreateDtoIn dtoIn) {
        // TODO
        return new CompanyModel();
    }
}
