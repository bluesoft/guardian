package br.com.bluesoft.guardian.fixture.fixtures;

import br.com.bluesoft.guardian.fixture.Fixture;
import br.com.bluesoft.guardian.fixture.FixtureField;
import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.models.Person;


public abstract class AbstractPersonFixture<T extends Person> extends Fixture<T> {
    protected FixtureField<String> name;
    protected FixtureField<Integer> age;
    protected FixtureField<String> document;

    protected AbstractPersonFixture(GuardianFixture guardianFixture) {
        super(guardianFixture);
        name     = field( (f) -> f.faker().name().fullName()             );
        age      = field( (f) -> f.faker().number().numberBetween(1, 90) );
        document = field( (f) -> f.faker().numerify("###.###.###-##")    );
    }

    public AbstractPersonFixture<T> name(String name) {
        this.name.setValue(name);
        return this;
    }

    public AbstractPersonFixture<T> age(Integer age) {
        this.age.setValue(age);
        return this;
    }

    public AbstractPersonFixture<T> document(String document) {
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
