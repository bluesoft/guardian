package br.com.bluesoft.demo.fixtures;


import br.com.bluesoft.demo.models.Bank;
import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.Fixture;
import br.com.bluesoft.guardian.fixture.FixtureField;

public class BankFixture extends Fixture<Bank> {

    private FixtureField<Long> number;
    private FixtureField<String> name;

    public BankFixture(GuardianFixture guardianFixture) {
        super(guardianFixture);
        number = field((f) -> f.faker().number().randomNumber(3,true));
        name   = field((f) -> f.faker().company().name());
    }

    @Override
    public Bank convert() {
        return new Bank(number.getValue(), name.getValue());
    }

    public Long getNumber() {
        return number.getValue();
    }

    public String getName() {
        return name.getValue();
    }
}
