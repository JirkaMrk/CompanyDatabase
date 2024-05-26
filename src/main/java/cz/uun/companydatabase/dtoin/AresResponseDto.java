package cz.uun.companydatabase.dtoin;

import com.fasterxml.jackson.annotation.JsonProperty;

import cz.uun.companydatabase.entity.Company;

public class AresResponseDto {
    
    @JsonProperty("ico")
    private String ico;

    // Getters and setters
    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }
    public Company getCompany() {
        Company company = new Company();
        company.setIco(this.getIco());
        return company;
    }
}
