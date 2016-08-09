package br.com.bluesoft.guardian.fixture;


import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.Locale;
import java.util.Objects;

import br.com.bluesoft.guardian.faker.Faker;

public class GuardianFixtureConfig {

    private final Faker faker;
    private final ModelMapper modelMapper;

    public GuardianFixtureConfig(Faker faker, ModelMapper modelMapper) {
        Objects.requireNonNull(faker);
        Objects.requireNonNull(modelMapper);
        this.faker = faker;
        this.modelMapper = modelMapper;
    }

    public GuardianFixtureConfig(Locale locale) {
        this(new Faker(locale), new ModelMapper());
        setupDefaultModelMapper();
    }

    public GuardianFixtureConfig() {
        this(Locale.getDefault());
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public Faker getFaker() {
        return faker;
    }

    private void setupDefaultModelMapper() {
        modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }
}
