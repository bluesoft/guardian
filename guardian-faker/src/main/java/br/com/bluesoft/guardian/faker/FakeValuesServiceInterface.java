package br.com.bluesoft.guardian.faker;


public interface FakeValuesServiceInterface {

    Object fetch(String key);

    String fetchString(String key);

    String safeFetch(String key);

    Object fetchObject(String key);

    String numerify(String numberString);

    String bothify(String string);

    String letterify(String letterString);

    String resolve(String key, Object current, Resolver resolver);
}
