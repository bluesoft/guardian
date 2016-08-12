package br.com.bluesoft.guardian.fixture.fixtures;

import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.models.Person;


public class PersonFixture extends AbstractPersonFixture<Person> {

    public PersonFixture(GuardianFixture fixture) {
        super(fixture);
    }

    public PersonFixture juridic() {
        this.document.setTemplate((f) -> f.faker().numerify("##.###.###/####-##"));
        return this;
    }

}
