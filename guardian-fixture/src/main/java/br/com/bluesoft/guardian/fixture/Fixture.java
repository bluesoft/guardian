package br.com.bluesoft.guardian.fixture;


import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.function.Function;

public abstract class Fixture<T> {

    private final Class<T> modelClass;
    private final GuardianFixture guardianFixture;

    protected Fixture(GuardianFixture guardianFixture) {
        this.guardianFixture = guardianFixture;
        this.modelClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getModelClass() {
        return this.modelClass;
    }

    public <R> FixtureField<R> field(Function<GuardianFixture, R> template) {
        return guardianFixture.field(template);
    }

    public T build() {
        return guardianFixture.build(this);
    }

    public List<T> build(int numberOfObjects) {
        return guardianFixture.build(numberOfObjects, this);
    }

    public T create() {
        return guardianFixture.create(this);
    }

    public List<T> create(int numberOfObjects) {
        return guardianFixture.create(numberOfObjects, this);
    }

}
