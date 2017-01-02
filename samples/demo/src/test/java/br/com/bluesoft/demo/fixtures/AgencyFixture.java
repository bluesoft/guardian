package br.com.bluesoft.demo.fixtures;


import java.util.function.Function;

import br.com.bluesoft.demo.models.Agency;
import br.com.bluesoft.demo.models.Bank;
import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.Fixture;
import br.com.bluesoft.guardian.fixture.FixtureField;

public class AgencyFixture extends Fixture<Agency> {

    private FixtureField<String> number;
    private FixtureField<String> digit;
    private FixtureField<Bank> bank;

    public AgencyFixture(GuardianFixture guardianFixture) {
        super(guardianFixture);
        number = field((f) -> f.faker().numerify("#####"));
        digit  = field((f) -> f.faker().numerify("#"));
        bank   = field((f) -> f.create(new BankFixture(f)));
    }

    @Override
    public Agency convert() {
        return new Agency(number.getValue(), digit.getValue(), bank.getValue());
    }

    public AgencyFixture number(String number) {
        this.number.setValue(number);
        return this;
    }

    public AgencyFixture digit(String digit) {
        this.digit.setValue(digit);
        return this;
    }

    public AgencyFixture bank(Bank bank) {
        this.bank.setValue(bank);
        return this;
    }

    public AgencyFixture bank(Function<GuardianFixture, Bank> bank) {
        this.bank.setTemplate(bank);
        return this;
    }

    public String getNumber() {
        return number.getValue();
    }

    public String getDigit() {
        return digit.getValue();
    }

    public Bank getBank() {
        return bank.getValue();
    }
}
