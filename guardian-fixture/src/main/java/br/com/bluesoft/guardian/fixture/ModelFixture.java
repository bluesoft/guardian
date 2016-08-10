package br.com.bluesoft.guardian.fixture;


public abstract class ModelFixture<T> extends Fixture<T> {

    protected ModelFixture(GuardianFixture guardianFixture) {
        super(guardianFixture);
    }

    public Long longId() {
        return faker().number().numberBetween(1, 999999999L);
    }

    public Integer intId() {
        return faker().number().numberBetween(1, 999999);
    }
}
