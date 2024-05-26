package cz.uun.companydatabase.dtoin;

public class CompanyCreateDtoIn {
    private String name;
    private String address;
    private String phoneNumber;
    private String ico;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }
}
