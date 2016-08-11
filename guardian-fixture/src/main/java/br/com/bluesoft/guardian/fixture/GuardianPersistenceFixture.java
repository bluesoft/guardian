package br.com.bluesoft.guardian.fixture;


public interface GuardianPersistenceFixture extends GuardianFixture {

    <T> T any(Class<T> clazz);

}
