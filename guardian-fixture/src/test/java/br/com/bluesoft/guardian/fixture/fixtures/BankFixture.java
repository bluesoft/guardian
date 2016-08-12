package br.com.bluesoft.guardian.fixture.fixtures;


import br.com.bluesoft.guardian.fixture.Fixture;
import br.com.bluesoft.guardian.fixture.FixtureField;
import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.models.Bank;


public class BankFixture extends Fixture<Bank> {
    private FixtureField<Long> number;
    private FixtureField<String> name;

    public BankFixture(GuardianFixture fixture) {
        super(fixture);
        number = field( (f) -> f.faker().number().randomNumber(3,true) );
        name   = field( (f) -> f.faker().company().name()              );
    }

    @Override
    public Bank convert() {
        return new Bank(number.getValue(), name.getValue());
    }
}
