package br.com.bluesoft.guardian.fixture.fixtures;


import java.util.function.Function;

import br.com.bluesoft.guardian.fixture.Fixture;
import br.com.bluesoft.guardian.fixture.FixtureField;
import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.models.Agency;
import br.com.bluesoft.guardian.fixture.models.Bank;

public class AgencyFixture extends Fixture<Agency> {

    private final FixtureField<String> number;
    private final FixtureField<String> digit;
    private final FixtureField<Bank> bank;

    public AgencyFixture(GuardianFixture fixture) {
        super(fixture);
        number = field( (f) -> f.faker().numerify("#####")  );
        digit  = field( (f) -> f.faker().numerify("#")      );
        bank   = field( (f) -> f.build(new BankFixture(f)) );
    }

    public AgencyFixture number(String number) {
        this.number.setValue(number);
        return this;
    }

    public AgencyFixture number(Function<GuardianFixture, String> number) {
        this.number.setTemplate(number);
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
