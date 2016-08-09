package br.com.bluesoft.guardian.fixture;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.bluesoft.guardian.faker.Faker;

public abstract class AbstractGuardianFixture implements GuardianFixture {

    private final GuardianFixtureConfig guardianFixtureConfig;

    AbstractGuardianFixture(GuardianFixtureConfig guardianFixtureConfig) {
        Objects.requireNonNull(guardianFixtureConfig);
        this.guardianFixtureConfig = guardianFixtureConfig;
    }

    @Override
    public Faker faker() {
        return this.guardianFixtureConfig.getFaker();
    }

    @Override
    public <T> T build(Fixture<T> fixture) {
        return guardianFixtureConfig.getModelMapper().map(fixture, fixture.getModelClass());
    }

    @Override
    public <T> List<T> build(int numberOfObjects, Fixture<T> fixture) {
        return IntStream.range(0, numberOfObjects).mapToObj(value -> build(fixture)).collect(Collectors.toList());
    }
}
