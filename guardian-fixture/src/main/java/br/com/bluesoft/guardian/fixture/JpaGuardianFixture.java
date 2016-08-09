package br.com.bluesoft.guardian.fixture;


import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;

public class JpaGuardianFixture extends AbstractGuardianFixture implements GuardianFixture {

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
    public <T> T create(Fixture<T> fixture) {
        T object = build(fixture);
        em.persist(object);
        return object;
    }

    @Override
    public <T> List<T> create(int numberOfItems, Fixture<T> fixture) {
        return IntStream.range(0, numberOfItems).mapToObj(value -> create(fixture)).collect(Collectors.toList());
    }
}
