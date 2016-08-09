package br.com.bluesoft.guardian.faker;

public class LocaleDoesNotExistException extends RuntimeException {
    public LocaleDoesNotExistException(String message) {
        super(message);
    }
}
