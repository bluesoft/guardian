package br.com.bluesoft.guardian.faker;


public class Color {
    private final FakeValuesServiceInterface fakeValuesService;

    public Color(FakeValuesServiceInterface fakeValuesService) {
        this.fakeValuesService = fakeValuesService;
    }

    public String name() {
        return fakeValuesService.fetchString("color.name");
    }
}
