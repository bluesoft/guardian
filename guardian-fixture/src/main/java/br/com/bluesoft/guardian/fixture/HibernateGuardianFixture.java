package br.com.bluesoft.guardian.fixture;


import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HibernateGuardianFixture extends AbstractGuardianFixture implements GuardianFixture {

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
    public <T> T create(Fixture<T> fixture) {
        T object = build(fixture);
        sessionFactory.getCurrentSession().persist(object);
        return object;
    }

    @Override
    public <T> List<T> create(int numberOfObjects, Fixture<T> fixture) {
        return IntStream.range(0, numberOfObjects).mapToObj(value -> create(fixture)).collect(Collectors.toList());
    }
}
