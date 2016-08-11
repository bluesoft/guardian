package br.com.bluesoft.guardian.fixture;


import java.util.List;
import java.util.Locale;
import java.util.function.Function;

import javax.persistence.EntityManager;

public class JpaGuardianFixture extends AbstractPersistenceGuardianFixture {

    private final EntityManager em;

    public JpaGuardianFixture(EntityManager em, GuardianFixtureConfig guardianFixtureConfig) {
        super(guardianFixtureConfig);
        this.em = em;
    }

    public JpaGuardianFixture(EntityManager em, Locale locale) {
        this(em, new GuardianFixtureConfig(locale));
    }

    public JpaGuardianFixture(EntityManager em) {
        this(em, Locale.getDefault());
    }

    @Override
    public <R> FixtureField<R> field(Function<GuardianFixture, R> template) {
        return new FixtureField<>(this, template);
    }

    @Override
    <T> T persist(T object) {
        em.persist(object);
        return object;
    }

    @Override
    public <T> T any(Class<T> clazz) {
        List<T> items = em.createQuery("select t from " + clazz.getCanonicalName() + " t ").getResultList();
        T object = faker().options().option(items);
        return object;
    }
}
