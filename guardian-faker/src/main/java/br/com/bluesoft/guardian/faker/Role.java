package br.com.bluesoft.guardian.faker;


public class Role {
    private final FakeValuesServiceInterface fakeValuesService;

    public Role(FakeValuesServiceInterface fakeValuesService) {
        this.fakeValuesService = fakeValuesService;
    }

    public String name() {
        return fakeValuesService.fetchString("role.name");
    }
}
