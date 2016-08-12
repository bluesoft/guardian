package br.com.bluesoft.guardian.fixture.fixtures;

import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.models.Person;


public class PersonFixture extends AbstractPersonFixture<Person> {

    public PersonFixture(GuardianFixture fixture) {
        super(fixture);
    }

    @Override
    public Person convert() {
        return new Person(name.getValue(), age.getValue(), document.getValue());
    }

    public PersonFixture juridic() {
        this.document.setTemplate((f) -> f.faker().numerify("##.###.###/####-##"));
        return this;
    }

}
