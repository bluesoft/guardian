package br.com.bluesoft.guardian.fixture.models;


public class Agency extends BaseModel {

    private String number;
    private String digit;
    private Bank bank;

    protected Agency() {
    }

    public Agency(String number, String digit, Bank bank) {
        this.number = number;
        this.digit = digit;
        this.bank = bank;
    }

    public String getNumber() {
        return number;
    }

    public String getDigit() {
        return digit;
    }

    public Bank getBank() {
        return bank;
    }
}
