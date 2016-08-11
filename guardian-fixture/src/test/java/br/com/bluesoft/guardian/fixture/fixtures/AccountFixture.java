package br.com.bluesoft.guardian.fixture.fixtures;


import br.com.bluesoft.guardian.fixture.Fixture;
import br.com.bluesoft.guardian.fixture.FixtureField;
import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.models.Account;
import br.com.bluesoft.guardian.fixture.models.Agency;
import br.com.bluesoft.guardian.fixture.models.Person;

public class AccountFixture extends Fixture<Account> {

    private FixtureField<String> number;
    private FixtureField<String> digit;
    private FixtureField<Person> owner;
    private FixtureField<Agency> agency;

    public AccountFixture(GuardianFixture fixture) {
        super(fixture);
        number = field( (f) -> f.faker().numerify("#####")    );
        digit  = field( (f) -> f.faker().numerify("#")        );
        owner  = field( (f) -> f.build(new PersonFixture(f)) );
        agency = field( (f) -> f.build(new AgencyFixture(f)) );
    }

    public AccountFixture number(String number) {
        this.number.setValue(number);
        return this;
    }

    public AccountFixture digit(String digit) {
        this.digit.setValue(digit);
        return this;
    }

    public AccountFixture owner(Person owner) {
        this.owner.setValue(owner);
        return this;
    }

    public AccountFixture agency(Agency agency) {
        this.agency.setValue(agency);
        return this;
    }

    public String getNumber() {
        return number.getValue();
    }

    public String getDigit() {
        return digit.getValue();
    }

    public Person getOwner() {
        return owner.getValue();
    }

    public Agency getAgency() {
        return agency.getValue();
    }
}
