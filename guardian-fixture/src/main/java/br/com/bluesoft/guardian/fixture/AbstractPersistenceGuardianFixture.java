package br.com.bluesoft.guardian.fixture;


public abstract class AbstractPersistenceGuardianFixture extends AbstractGuardianFixture implements GuardianPersistenceFixture {

    public AbstractPersistenceGuardianFixture(GuardianFixtureConfig guardianFixtureConfig) {
        super(guardianFixtureConfig);
    }

    @Override
    public <T> T create(Fixture<T> fixture) {
        T object = build(fixture);
        persist(object);
        return object;
    }

    @Override
    public GuardianPersistenceFixture query() {
        return this;
    }

    abstract <T> T persist(T object);
}
