package br.com.bluesoft.guardian.fixture.fixtures;

import br.com.bluesoft.guardian.fixture.Fixture;
import br.com.bluesoft.guardian.fixture.FixtureField;
import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.models.Person;


public class PersonFixture extends Fixture<Person> {

    private FixtureField<String> name;
    private FixtureField<Integer> age;
    private FixtureField<String> document;

    public PersonFixture(GuardianFixture fixture) {
        super(fixture);
        name     = field( (f) -> f.faker().name().fullName()             );
        age      = field( (f) -> f.faker().number().numberBetween(1, 90) );
        document = field( (f) -> f.faker().numerify("###.###.###-##")    );
    }

    public PersonFixture juridic() {
        this.document.setTemplate((f) -> f.faker().numerify("##.###.###/####-##"));
        return this;
    }

    public PersonFixture name(String name) {
        this.name.setValue(name);
        return this;
    }

    public PersonFixture age(Integer age) {
        this.age.setValue(age);
        return this;
    }

    public PersonFixture document(String document) {
        this.document.setValue(document);
        return this;
    }

    public String getName() {
        return name.getValue();
    }

    public Integer getAge() {
        return age.getValue();
    }

    public String getDocument() {
        return document.getValue();
    }
}
