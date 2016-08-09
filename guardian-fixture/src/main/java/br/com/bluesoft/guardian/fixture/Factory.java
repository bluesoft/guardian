package br.com.bluesoft.guardian.fixture;


import java.util.List;
import java.util.function.Function;

import br.com.bluesoft.guardian.faker.Faker;

public interface Factory {

    Faker faker();

    <R> TemplateField<R> field(Function<Factory, R> template);

    <T> T build(Template<T> template);

    <T> List<T> build(int numberOfObjects, Template<T> template);

    <T> T create(Template<T> template);

    <T> List<T> create(int numberOfObjects, Template<T> template);
}
