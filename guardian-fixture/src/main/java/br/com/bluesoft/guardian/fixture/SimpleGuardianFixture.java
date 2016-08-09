package br.com.bluesoft.guardian.fixture;


import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class SimpleGuardianFixture extends AbstractGuardianFixture implements Factory {

    public SimpleGuardianFixture(FactoryConfig factoryConfig) {
        super(factoryConfig);
    }

    public SimpleGuardianFixture(Locale locale) {
        this(new FactoryConfig(locale));
    }

    public SimpleGuardianFixture() {
        this(new FactoryConfig());
    }

    @Override
    public <R> TemplateField<R> field(Function<Factory, R> template) {
        return new TemplateField<>(this, template);
    }

    @Override
    public <T> T create(Template<T> template) {
        return build(template);
    }

    @Override
    public <T> List<T> create(int numberOfObjects, Template<T> template) {
        return build(numberOfObjects, template);
    }
}
