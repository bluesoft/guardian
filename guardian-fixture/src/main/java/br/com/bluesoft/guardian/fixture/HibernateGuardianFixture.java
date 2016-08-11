package br.com.bluesoft.guardian.fixture;


import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class HibernateGuardianFixture extends AbstractPersistenceGuardianFixture {

    private final SessionFactory sessionFactory;

    public HibernateGuardianFixture(SessionFactory sessionFactory, GuardianFixtureConfig guardianFixtureConfig) {
        super(guardianFixtureConfig);
        this.sessionFactory = sessionFactory;
    }

    public HibernateGuardianFixture(SessionFactory sessionFactory, Locale locale) {
        this(sessionFactory, new GuardianFixtureConfig(locale));
    }

    public HibernateGuardianFixture(SessionFactory sessionFactory) {
        this(sessionFactory, Locale.getDefault());
    }

    @Override
    public <R> FixtureField<R> field(Function<GuardianFixture, R> template) {
        return new FixtureField<>(this, template);
    }

    @Override
    <T> T persist(T object) {
        sessionFactory.getCurrentSession().persist(object);
        return object;
    }

    @Override
    public <T> T any(Class<T> clazz) {
        List<T> items = sessionFactory.getCurrentSession().createQuery("select t from " + clazz.getCanonicalName() + " t ").list();
        T object = faker().options().option(items);
        return object;
    }
}
