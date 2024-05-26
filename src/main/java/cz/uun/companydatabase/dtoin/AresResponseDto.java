package cz.uun.companydatabase.dtoin;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}
