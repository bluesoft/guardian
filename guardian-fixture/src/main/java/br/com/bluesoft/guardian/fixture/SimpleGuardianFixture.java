package br.com.bluesoft.guardian.fixture;


import java.util.Locale;
import java.util.function.Function;

public class SimpleGuardianFixture extends AbstractGuardianFixture implements GuardianFixture {

    public SimpleGuardianFixture(GuardianFixtureConfig guardianFixtureConfig) {
        super(guardianFixtureConfig);
    }

    public SimpleGuardianFixture(Locale locale) {
        this(new GuardianFixtureConfig(locale));
    }

    public SimpleGuardianFixture() {
        this(new GuardianFixtureConfig());
    }

    @Override
    public <R> FixtureField<R> field(Function<GuardianFixture, R> template) {
        return new FixtureField<>(this, template);
    }

    @Override
    public GuardianPersistenceFixture query() {
        throw new IncompatibleClassChangeError("Only Persistence Fixtures can query objects");
    }
}
