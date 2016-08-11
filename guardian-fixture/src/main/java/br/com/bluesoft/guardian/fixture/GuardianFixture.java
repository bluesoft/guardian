package br.com.bluesoft.guardian.fixture;


import java.util.List;
import java.util.function.Function;

import br.com.bluesoft.guardian.faker.Faker;

public interface GuardianFixture {

    Faker faker();

    GuardianPersistenceFixture query();

    <R> FixtureField<R> field(Function<GuardianFixture, R> template);

    <T> T build(Fixture<T> fixture);

    <T> List<T> build(int numberOfObjects, Fixture<T> fixture);

    <T> T create(Fixture<T> fixture);

    <T> List<T> create(int numberOfObjects, Fixture<T> fixture);
}
