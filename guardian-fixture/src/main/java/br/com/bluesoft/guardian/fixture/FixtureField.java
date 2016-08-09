package br.com.bluesoft.guardian.fixture;


import java.util.function.Function;

public class FixtureField<R> extends LazyField<GuardianFixture, R> {

    public FixtureField(GuardianFixture guardianFixture, Function<GuardianFixture, R> func) {
        super(guardianFixture, func);
    }
}
