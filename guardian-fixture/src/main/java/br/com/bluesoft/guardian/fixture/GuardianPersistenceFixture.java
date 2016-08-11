package br.com.bluesoft.guardian.fixture;


public interface GuardianPersistenceFixture extends GuardianFixture {

    public <T> T any(Class<T> clazz);
}
