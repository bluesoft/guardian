package br.com.bluesoft.guardian.faker;


public class Document {

    private final Faker faker;

    public Document(final Faker faker) {
        this.faker = faker;
    }

    public String cnpj() {
        return faker.numerify("##.###.###/####-##");
    }

    public String cpf() {
        return faker.numerify("###.###.###-##");
    }
}
